/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.as2.repository;

import com.fts.MigracionVas.as2.entity.ClientesAS2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ClienteAS2Dao extends CrudRepository<ClientesAS2, Long> {
    
    
    @Query(value="SELECT * FROM as2.cliente WHERE identificacion = :identificacion ",nativeQuery=true)
    public ClientesAS2 clienteFacturacionByIdentificacion(@Param("identificacion") String identificacion);
    
     @Query(value="SELECT * FROM as2.cliente WHERE identificacion = 'C/F' ",nativeQuery=true)
    public ClientesAS2 findByCF();
    
    
}



