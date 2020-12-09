
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_db.repository.CuentasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentasServiceImpl implements CuentasService{

    @Autowired
    CuentasDao cuentasDaoObj;
    
    @Override
    public List<Cuentas> ListadoCuentas(int idcuentas) {
        return cuentasDaoObj.finByListCuentas( idcuentas);
    }

    @Override
    public void RegistrarCuentas(Cuentas cuenta) {
        cuentasDaoObj.save(cuenta);
    }

    @Override
    public Cuentas BuscarCuentas(int idcuenta) {
        return cuentasDaoObj.findById(idcuenta).orElse(null);

    }

    @Override
    public void eliminarCuenta(int idcuenta) {
        cuentasDaoObj.deleteById(idcuenta);
    }

    @Override
    public int ultimoIDregistrado() {
        return cuentasDaoObj.ultimoIDregistrado();
    }

    @Override
    public int isBolsaCliente(String idcliente) {
        return cuentasDaoObj.isBolsaCliente(idcliente);
        
    }

    @Override
    public int actualizarSaldoCuenta(int saldoCuenta, String idCuenta) {
        return cuentasDaoObj.actualizarSaldoCuenta(saldoCuenta, idCuenta);
    }

    @Override
    public List<Cuentas> finByListCuentasSaldoVerificacion(String idCliente) {
        return cuentasDaoObj.finByListCuentasSaldoVerificacion(idCliente);
    }

    @Override
    public Cuentas finByCuentaBolsa(String idCliente) {
        return (Cuentas) cuentasDaoObj.finByCuentasBolsa(idCliente);
    }
   
    
}


