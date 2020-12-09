/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.repository;

import java.util.List;
import com.fts.MigracionVas.easyroad_temp.entity.VehiculosTemp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Priceleggan
 */
public interface VehiculosTempDao extends CrudRepository <VehiculosTemp,Integer>{
    
    @Query(value="Select * from easyroad_temp.vehiculos vt where vt.cuenta_id = :idCuenta ",nativeQuery = true)
    public List<VehiculosTemp> finVehiculosByCuentas(@Param("idCuenta") int id);
    
}
