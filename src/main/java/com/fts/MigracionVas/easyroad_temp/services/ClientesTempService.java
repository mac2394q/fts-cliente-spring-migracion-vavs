/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.ClientesTemp;
import java.util.List;

/**
 * Interface (Servicio de cliente)
 * @author: Miguel Angel Claros Quintero
 * @version: 23/06/2020/
 * @see Implementacion Api rest Codifi Consulta nit
 */
public interface ClientesTempService {


    public List<ClientesTemp> ListadoClientes();
    
    public void eliminarClienteValidado(int idcliente);



}
