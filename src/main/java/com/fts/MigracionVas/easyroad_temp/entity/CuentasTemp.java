/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_temp.entity;

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
@Table(name="easyroad_temp.cuentas")
public class CuentasTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "cliente_id")
    private String clienteId;
    
    @Column(name = "cuenta_estados_id")
    private int cuentaEstadosId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "credito")
    private int credito;
    
    @Column(name = "saldo")
    private int saldo;
    @Column(name = "insertTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "updateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "cliente_identificacion")
    private String clienteIdentificacion;
    @Column(name = "descripcion_cuenta")
    private String descripcionCuenta;
    @Column(name = "relacion_bolsa")
    private int relacion_bolsa;
    @Column(name = "isBolsa")
    private int isBolsa;
     @Column ( name = "contrato")
    private String contrato;

    public CuentasTemp(int id, String clienteId, int cuentaEstadosId, int credito, 
            int saldo, Date insertTime, Date updateTime, String clienteIdentificacion, 
            String descripcionCuenta,int relacion_bolsa,int isBolsa) {
        this.id = id;
        this.clienteId = clienteId;
        this.cuentaEstadosId = cuentaEstadosId;
        this.credito = credito;
        this.saldo = saldo;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.clienteIdentificacion = clienteIdentificacion;
        this.descripcionCuenta = descripcionCuenta;
        this.relacion_bolsa = relacion_bolsa;
        this.isBolsa = isBolsa;
        this.contrato = contrato;
    }

    public CuentasTemp() {
    }
    
    
    

    
    
}


