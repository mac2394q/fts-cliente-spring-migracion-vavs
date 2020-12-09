/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.services;

import com.fts.MigracionVas.easyroad_temp.entity.CuentasTemp;
import com.fts.MigracionVas.easyroad_temp.entity.TagsTemp;
import com.fts.MigracionVas.easyroad_temp.repository.TagsTempDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TagsTempServiceImpl implements TagsTempService{

    @Autowired
    private TagsTempDao TagsTempDaoObj;
    
    @Override
    public void eliminarTagsValidado(int idcuenta) {
        TagsTempDaoObj.deleteById(idcuenta);
    }

    @Override
    public List<TagsTemp> listadoTagsByCuenta(int idcuenta) {
        return TagsTempDaoObj.finByListTags(idcuenta);
    }
    
    
 
    
}
