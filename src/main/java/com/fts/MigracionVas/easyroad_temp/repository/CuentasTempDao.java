
package com.fts.MigracionVas.easyroad_temp.repository;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_temp.entity.CuentasTemp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CuentasTempDao extends CrudRepository <CuentasTemp,Integer >{
    
    @Query(value="Select * from easyroad_temp.cuentas ct where ct.cliente_id = :idCliente ",nativeQuery = true)
    public List<CuentasTemp> finByListCuentas(@Param("idCliente") int id);
    
}
