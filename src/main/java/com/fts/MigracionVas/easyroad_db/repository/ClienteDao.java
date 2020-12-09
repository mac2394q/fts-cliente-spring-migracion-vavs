/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.repository;

import com.fts.MigracionVas.easyroad_db.entity.Clientes;
import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Priceleggan
 */
public interface ClienteDao  extends CrudRepository<Clientes,Integer>{
    
    
    @Query(value="Select * from easyroad_db.clientes c where c.identificacion = :identificacion ",nativeQuery = true)
    public Clientes finByClienteNit(@Param("identificacion") String identificacion);
    
}







