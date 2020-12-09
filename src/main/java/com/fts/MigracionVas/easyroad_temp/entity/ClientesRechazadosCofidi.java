/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Priceleggan
 */
@Data
@Entity
@Table(name="easyroad_temp.clientes_rechazados_cofidi")
public class ClientesRechazadosCofidi implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "identificacion")
    private String identificacion;
    
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "cliente_estados_id")
    private int clienteEstadosId;
    
    @Column(name = "insertTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    
    @Column(name = "updateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    
    @Column(name = "tipo_cliente_id")
    private int tipoClienteId;
    
    @Column(name = "celular")
    private String celular;
    
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "sync_field")
    private Integer syncField;
    
     @Column(name = "cliente_facturacion_id")
    private String cliente_facturacion_id;

    public ClientesRechazadosCofidi() {
    }
    
    public ClientesRechazadosCofidi(int id, String nombre, String identificacion, String tipoDocumento, String direccion, String telefono, String email, int clienteEstadosId, Date insertTime, Date updateTime, int tipoClienteId, String celular, String ciudad, Integer syncField, String idFacturacion) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoDocumento = tipoDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.clienteEstadosId = clienteEstadosId;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.tipoClienteId = tipoClienteId;
        this.celular = celular;
        this.ciudad = ciudad;
        this.syncField = syncField;
        this.cliente_facturacion_id =  idFacturacion;
    }
    
    
    

    
 

    
    
    
    
    
    
}







