/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.repository;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
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
public interface CuentasDao  extends CrudRepository <Cuentas,Integer>{
    
   @Query(value="Select * from easyroad_temp.cuentas ct where ct.cliente_id = :idCliente ",nativeQuery = true)
   public List<Cuentas> finByListCuentas(@Param("idCliente") int id);
   
   @Query(value="SELECT MAX(id) AS id FROM easyroad_db.cuentas ",nativeQuery = true)
   public int ultimoIDregistrado();
   
   
   @Query(value="select COUNT(*) as idbolsa from easyroad_db.cuentas where cuentas.isBolsa = 1 and cuentas.cliente_id = :idCliente",nativeQuery=true)
   public int isBolsaCliente(@Param("idCliente") String id);
   
   @Modifying
   @Transactional
   @Query(value="update easyroad_db.cuentas set saldo = :saldo where cuentas.isBolsa = 1 and cliente_id = :idCliente",nativeQuery = true)
   public int actualizarSaldoCuenta(@Param("saldo") int saldo , @Param("idCliente") String idCliente);
   
   @Query(value="select * from easyroad_db.cuentas ct where ct.cliente_id = :idCliente and ct.isBolsa = 0" , nativeQuery = true)
   public List<Cuentas> finByListCuentasSaldoVerificacion(@Param("idCliente") String idCliente);
   
   
   @Query(value="select * from easyroad_db.cuentas ct where ct.cliente_id = :idCliente and ct.isBolsa = 1" , nativeQuery = true)
   public List<Cuentas> finByCuentasBolsa(@Param("idCliente") String idCliente);
   
}


