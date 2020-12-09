
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.CuentasTemp;
import com.fts.MigracionVas.easyroad_temp.entity.TagsTemp;
import java.util.List;

public interface TagsTempService {
    
    public void eliminarTagsValidado(int idcuenta);
    
    public List<TagsTemp> listadoTagsByCuenta(int idcuenta);
    
}
