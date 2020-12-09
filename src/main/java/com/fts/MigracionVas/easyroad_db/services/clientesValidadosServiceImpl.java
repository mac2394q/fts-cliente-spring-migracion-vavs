
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.ClientesValidados;
import com.fts.MigracionVas.easyroad_db.repository.clienteValidadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clientesValidadosServiceImpl implements clientesValidadosService{

    @Autowired
    private clienteValidadoDao objClienteValidado;
    
    @Override
    public void RegistrarClienteValidados(ClientesValidados ClienteObj) {
        objClienteValidado.save(ClienteObj);
    }
    
    
    
}
