/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.ClientesTemp;
import com.fts.MigracionVas.easyroad_temp.repository.ClienteTempDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Priceleggan
 */
@Service
public class ClientesTempServiceImpl implements ClientesTempService {
    
    @Autowired
    private ClienteTempDao ClienteTempDaoObj;

    @Override
    public List<ClientesTemp> ListadoClientes() {
        return (List<ClientesTemp>) ClienteTempDaoObj.findAll();
        
    }

    @Override
    public void eliminarClienteValidado(int idcliente) {
        ClienteTempDaoObj.deleteById(idcliente);
    }

  
  

   

   

  

    
    
}
