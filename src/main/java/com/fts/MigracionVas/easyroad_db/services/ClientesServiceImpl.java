/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.repository.ClienteDao;
import com.fts.MigracionVas.easyroad_db.entity.Clientes;
import com.fts.MigracionVas.easyroad_db.entity.ClientesValidados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Priceleggan
 */
@Service
public class ClientesServiceImpl implements ClientesService {
    
    @Autowired
    private ClienteDao ClienteDaoObj;
 
    @Override
    @Transactional(readOnly = true)
    public List<Clientes> ListadoClientes() {
        return (List<Clientes>) ClienteDaoObj.findAll();
    }

    @Override
    @Transactional
    public void RegistrarCliente(Clientes ClienteObj) {
        ClienteDaoObj.save(ClienteObj);
    }

    @Override
    public Clientes BuscarClientesNit(String identificacion) {
        return ClienteDaoObj.finByClienteNit(identificacion);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long NumeroClientes() {
        return ClienteDaoObj.count();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Clientes BuscarClienteId(Clientes ClienteObj) {
        return ClienteDaoObj.findById(ClienteObj.getId() ).orElse(null);
    }

    @Override
    public Clientes BuscarClienteId( int idcliente ) {
        System.out.println( "id cliente a validar "+idcliente);
        return ClienteDaoObj.findById( idcliente ).orElse( null );
    }


}






