/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Clientes;
import com.fts.MigracionVas.easyroad_temp.entity.ClientesRechazadosCofidi;
import java.util.List;

/**
 * Interface (Servicio de cliente)
 * @author: Miguel Angel Claros Quintero
 * @version: 23/06/2020/
 * @see Implementacion Api rest Codifi Consulta nit
 */
public interface ClientesRechazadosCofidiService {

    /**
     * Metodo para listar todos los registros de la tabla clientes DB Clientes Rechazados Vas
     * @param: 
     * @return: List<ClientesRechazadosCofidi>
     * @version: 1.0
     */
    public List<ClientesRechazadosCofidi> ListadoClientes();

    /**
     * Metodo para registrar nuevo cliente DB Vas Rechazados Cofidi final
     * @param: Obj ClientesRechazadosCofidi
     * @return: void
     * @version: 1.0
     */
    public void RegistrarCliente(ClientesRechazadosCofidi ClienteObj);
    
    
    /**
     * Metodo contar el numero de clientes rechazados cofidi
     * @param 
     * @return List<ClientesRechazadosCofidi>
     * @version 1.0
     */
    public long NumeroClientes();
    
//    public ClientesRechazadosCofidi ConsultaNitCofidi(String nit);
    
    public ClientesRechazadosCofidi  BuscarClienteRechazadosCofidi(ClientesRechazadosCofidi ClienteObj);
    public void EliminarClienteRechazado(int id);
    

}
