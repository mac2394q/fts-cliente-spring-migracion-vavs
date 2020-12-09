/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.as2.entity;

import com.fts.MigracionVas.easyroad_temp.entity.ClientesTemp;
import com.fts.MigracionVas.tools.generateUUID;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "as2.cliente")
public class ClientesAS2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "tipoIdentificacion")
    private Integer tipoIdentificacion;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipoCliente")
    private int tipoCliente;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "codigoISOPais")
    private String codigoISOPais;

    @Column(name = "pais")
    private String pais;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "formaPago")
    private Integer formaPago;

    @Column(name = "condicionPago")
    private Integer condicionPago;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @Column(name = "sync_field")
    private Integer syncField;

    @Column(name = "codigoPostal")
    private String codigoPostal;
    
    @Column(name = "tipoFacturacion")
    private Integer tipoFacturacion;

    public ClientesAS2(){}

    public ClientesAS2(String id, String codigo, Integer tipoIdentificacion, String identificacion, String nombre, int tipoCliente, String telefono, String email, String codigoISOPais, String pais, String provincia, String ciudad, String direccion, Integer formaPago, Integer condicionPago, String descripcion, Integer estado, Date fechaCreacion, Date fechaActualizacion, Integer syncField, String codigoPostal, int tipoFacturacion) {
        this.id = id;
        this.codigo = codigo;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.telefono = telefono;
        this.email = email;
        this.codigoISOPais = codigoISOPais;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.formaPago = formaPago;
        this.condicionPago = condicionPago;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.syncField = syncField;
        this.codigoPostal = codigoPostal;
        this.tipoFacturacion = tipoFacturacion;
    }
    
    public void GenerarObjectoClienteAS2( ClientesTemp clienteTemp ){
        
        this.id = new generateUUID().getUUID();
        this.codigo = "0";
        this.tipoIdentificacion = 1;
        this.identificacion = clienteTemp.getIdentificacion();
        this.nombre = clienteTemp.getNombre();
        this.tipoCliente = 1;
        this.telefono = clienteTemp.getTelefono();
        this.email = clienteTemp.getEmail();
        this.codigoISOPais = "GTA";
        this.pais = "GT";
        this.provincia = "";
        this.ciudad = clienteTemp.getCiudad();
        this.direccion = clienteTemp.getDireccion();
        this.formaPago = 1;
        this.condicionPago = 99;
        this.descripcion = "";
        this.estado = 1;
        this.fechaCreacion = clienteTemp.getInsertTime();
        this.fechaActualizacion = clienteTemp.getUpdateTime();
        this.syncField = clienteTemp.getSyncField();
        this.codigoPostal = "01005";
        this.tipoFacturacion = 1;
        
    }
    
    



}











