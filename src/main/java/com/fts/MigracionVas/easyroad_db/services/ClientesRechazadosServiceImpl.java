/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_temp.repository.ClienteRechazadosCofidiDao;
import com.fts.MigracionVas.easyroad_temp.entity.ClientesRechazadosCofidi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Priceleggan
 */
@Service
public class ClientesRechazadosServiceImpl implements ClientesRechazadosCofidiService {
    
    @Autowired
    private ClienteRechazadosCofidiDao ClienteDaoObj;

   
    
    @Override
    @Transactional(readOnly = true)
    public long NumeroClientes() {
        return ClienteDaoObj.count();
    }
    
    @Override
    public void RegistrarCliente(ClientesRechazadosCofidi ClienteObj) {
        ClienteDaoObj.save(ClienteObj);
    }

    @Override
    @Transactional()
    public List<ClientesRechazadosCofidi> ListadoClientes() {
        return (List<ClientesRechazadosCofidi>)ClienteDaoObj.findAll();
    }

//    @Override
//    public ClientesRechazadosCofidi ConsultaNitCofidi(String nit) {
//        return ClienteDaoObj.ConsultaNitCofidi(nit);
//    }

    @Override
    public void EliminarClienteRechazado(int id) {
        ClienteDaoObj.deleteById(id);
    }

    @Override
    public ClientesRechazadosCofidi BuscarClienteRechazadosCofidi(ClientesRechazadosCofidi ClienteObj) {
        return ClienteDaoObj.findById(ClienteObj.getId()).orElse(null);
     
    }


}
