package com.fts.MigracionVas.easyroad_temp.repository;

import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_db.entity.Tags;
import com.fts.MigracionVas.easyroad_temp.entity.TagsTemp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TagsTempDao extends  CrudRepository<TagsTemp,Integer>{
    
    @Query(value="Select * from easyroad_temp.tags tt where tt.cuenta_id = :idCuentas ",nativeQuery = true)
    public List<TagsTemp> finByListTags(@Param("idCuentas") int id);
    
}
