
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.CuentasTemp;
import com.fts.MigracionVas.easyroad_temp.repository.CuentasTempDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentasTempServiceImpl implements CuentasTempService{
    
    @Autowired
    private CuentasTempDao CuentasDaoObj;

    @Override
    public void eliminarCuentaValidado(int idcuenta) {
        CuentasDaoObj.deleteById(idcuenta);
    }

    @Override
    public List<CuentasTemp> listadoCuentaByCliente(int idcliente) {
        return CuentasDaoObj.finByListCuentas(idcliente);
    }
    
}
