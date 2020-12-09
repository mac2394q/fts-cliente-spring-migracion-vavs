/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.services;

import com.fts.MigracionVas.easyroad_db.entity.Tags;
import com.fts.MigracionVas.easyroad_db.repository.TagsDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsServicesImpl implements TagsServices{

    @Autowired
    TagsDao tagsdaoObj;
    
    @Override
    public void RegistarTags(Tags tags) {
        tagsdaoObj.save(tags);
    }

}
