/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Priceleggan
 */
public interface CuentasService {
    
    public List<Cuentas> ListadoCuentas(int id);
    
    public void RegistrarCuentas(Cuentas cuenta);
    
    public Cuentas BuscarCuentas(int idcuenta);
    
    public void eliminarCuenta(int idcuenta);
    
    public int ultimoIDregistrado();
    
    public int isBolsaCliente(String idcliente);
    
    public int actualizarSaldoCuenta(int saldoCuenta , String idCliente);
    
    public List<Cuentas> finByListCuentasSaldoVerificacion(String idCliente);
    
    public Cuentas finByCuentaBolsa( String idCliente );
    
    
    
}


