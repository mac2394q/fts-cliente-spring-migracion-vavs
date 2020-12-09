/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.repository;

import com.fts.MigracionVas.easyroad_temp.entity.ClientesRechazadosCofidi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Priceleggan
 */
public interface ClienteRechazadosCofidiDao  extends CrudRepository<ClientesRechazadosCofidi,Integer>{
    

}

