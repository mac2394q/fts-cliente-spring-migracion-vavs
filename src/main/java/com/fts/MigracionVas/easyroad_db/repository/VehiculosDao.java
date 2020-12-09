/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.repository;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_db.entity.Vehiculos;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Priceleggan
 */
public interface VehiculosDao extends CrudRepository<Vehiculos,Integer>{
    
   @Modifying
   @Transactional
   @Query(value="update easyroad_db.vehiculos set saldo = :saldo where cuenta_id = :idCuenta" , nativeQuery = true)
   public int actualizarSaldoVehiculo(@Param("saldo") int saldo , @Param("idCuenta") int idCuenta);
   
   
    
    
    
}
