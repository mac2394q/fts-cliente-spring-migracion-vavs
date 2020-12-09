/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.ClientesTemp;
import com.fts.MigracionVas.easyroad_temp.entity.VehiculosTemp;
import java.util.List;

/**
 *
 * @author Priceleggan
 */
public interface VehiculosTempService {
    
    public void eliminarVehiculoValidado(int idcuenta);
    
    public List<VehiculosTemp> findVehiculosByCuenta(int idcuenta);
    
}
