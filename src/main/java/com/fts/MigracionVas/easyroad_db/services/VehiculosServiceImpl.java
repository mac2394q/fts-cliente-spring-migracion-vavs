/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Clientes;
import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_db.entity.Vehiculos;
import com.fts.MigracionVas.easyroad_db.repository.VehiculosDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculosServiceImpl implements VehiculosService {
    
    @Autowired
    private VehiculosDao vehiculoDaoObj;
    
    public void registrarVehiculo(Vehiculos vehiculo){
        vehiculoDaoObj.save(vehiculo);
    }

   
    @Override
    public int actualizarSaldoVehiculo(int saldoCuenta, int idCliente) {
        return vehiculoDaoObj.actualizarSaldoVehiculo(saldoCuenta, idCliente);
        
    }

   
    
    
    
    
}
