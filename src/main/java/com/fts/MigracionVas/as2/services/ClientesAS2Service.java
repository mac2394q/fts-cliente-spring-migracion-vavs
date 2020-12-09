
package com.fts.MigracionVas.as2.services;

import com.fts.MigracionVas.as2.entity.ClientesAS2;



public interface ClientesAS2Service {
    
    public ClientesAS2 obtenerClienteFacturacion(ClientesAS2 clienteAs2Obj);
    
    public void registrarClienteFacturacion(ClientesAS2 clienteAs2Obj);
    
    public ClientesAS2 obtenerClienteCF();
    
    
}

