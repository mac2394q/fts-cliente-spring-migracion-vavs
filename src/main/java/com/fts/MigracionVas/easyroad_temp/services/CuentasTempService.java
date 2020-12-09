/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.CuentasTemp;
import java.util.List;

/**
 *
 * @author Priceleggan
 */
public interface CuentasTempService {
    
    public void eliminarCuentaValidado(int idcuenta);
    
    public List<CuentasTemp> listadoCuentaByCliente(int idcliente);
    
}
