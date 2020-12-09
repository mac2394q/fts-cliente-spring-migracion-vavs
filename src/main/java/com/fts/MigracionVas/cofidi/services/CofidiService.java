/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.cofidi.services;

/**
 * Interface (Servicio de cliente)
 * @author: Miguel Angel Claros Quintero
 * @version: 23/06/2020/
 * @see Implementacion Api rest Codifi Consulta nit
 */
public interface CofidiService {
    
    
    /**
     * Metodo para Consultar Nit - Cofidi -Api rest 
     * @param nit(String)
     * @return Json Format
     * @version 1.0
     */
    public boolean implementacionCofidi();
    
    
    

    
    public void implementacionMigracion(String tipoValidacion);
    
  
    
    
    
    
}

