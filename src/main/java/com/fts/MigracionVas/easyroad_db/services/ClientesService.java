/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Clientes;
import java.util.List;

/**
 * Interface (Servicio de cliente)
 * @author: Miguel Angel Claros Quintero
 * @version: 23/06/2020/
 * @see Implementacion Api rest Codifi Consulta nit
 */
public interface ClientesService {

    /**
     * Metodo para listar todos los registros de la tabla clientes DB Temp Vas
     * @param: 
     * @return: List<ClientesTemp>
     * @version: 1.0
     */
    public List<Clientes> ListadoClientes();

    /**
     * Metodo para registrar nuevo cliente DB Vas final
     * @param: Obj Clientes
     * @return: void
     * @version: 1.0
     */
    public void RegistrarCliente(Clientes ClienteObj);
    
    /**
     * Metodo para buscar registro de cliente por nit
     * @param String nit
     * @return Obj Clientes
     * @version 1.0
     */
    public Clientes BuscarClientesNit(String identificacion);
    
    /**
     * Metodo para buscar registro de cliente por nit
     * @param String nit
     * @return Obj Clientes
     * @version 1.0
     */
    public long NumeroClientes();
    
    /**
     * Metodo para buscar registro de cliente por nit
     * @param String nit
     * @return Obj Clientes
     * @version 1.0
     */
    public Clientes BuscarClienteId(Clientes ClienteObj);
    
    /**
     * Metodo para buscar registro de cliente por nit
     * @param String nit
     * @return Obj Clientes
     * @version 1.0
     */
    public Clientes BuscarClienteId(int id);
    
    

    

}

