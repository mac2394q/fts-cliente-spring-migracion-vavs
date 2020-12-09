/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.VehiculosTemp;
import com.fts.MigracionVas.easyroad_temp.repository.VehiculosTempDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculosTempServiceImpl implements VehiculosTempService{

    @Autowired
    private VehiculosTempDao VehiculosTempDaoObj;
    
    @Override
    public void eliminarVehiculoValidado(int idcuenta) {
        VehiculosTempDaoObj.deleteById(idcuenta);
        
    }

    @Override
    public List<VehiculosTemp> findVehiculosByCuenta(int idcuenta) {
        return VehiculosTempDaoObj.finVehiculosByCuentas(idcuenta);
    }
    
}
