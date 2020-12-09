/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_db.entity.Vehiculos;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Priceleggan
 */
public interface VehiculosService {
    
    public int actualizarSaldoVehiculo(int saldoCuenta , int idCuenta);
    
   
    
    
}
