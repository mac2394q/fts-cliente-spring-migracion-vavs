/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.as2.services;

import com.fts.MigracionVas.as2.entity.ClientesAS2;
import com.fts.MigracionVas.as2.repository.ClienteAS2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class ClientesAS2ServiceImpl implements ClientesAS2Service {
    
    @Autowired
    private ClienteAS2Dao clienteAs2DaObj;

    @Override
    public ClientesAS2 obtenerClienteFacturacion(ClientesAS2 clienteAs2Obj) {
      
        return clienteAs2DaObj.clienteFacturacionByIdentificacion(clienteAs2Obj.getIdentificacion());
         
    }
    
    
    public ClientesAS2 obtenerClienteFacturacionVerificacion(String identificacion) {
      
        return clienteAs2DaObj.clienteFacturacionByIdentificacion(identificacion);
         
    }

    @Override
    public void registrarClienteFacturacion(ClientesAS2 clienteAs2Obj) {
        clienteAs2DaObj.save(clienteAs2Obj);
    }

    @Override
    public ClientesAS2 obtenerClienteCF() {
        
        return clienteAs2DaObj.findByCF();
        
    }
    
    
    
    
    
}




