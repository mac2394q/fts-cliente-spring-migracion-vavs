/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.repository;

import com.fts.MigracionVas.easyroad_db.entity.Tags;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Priceleggan
 */
public interface TagsDao extends CrudRepository<Tags,Integer> {
    
}
