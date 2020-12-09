/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.entity;

/**
 *
 *  @author ING Miguel Angel Claros Quintero
 * 
 *
 **/
public class CofidiConsultaNit {
    
    /*Datos para consumir soap web service consulta nit cofidi*/
    private String VNit;
    private String Entity ;
    private String Requestor ;
    private String url ;
    private int estado; //1 - procesado , 0 - No hay conexion , 2 - Error : nit Desconocido
    private String descripcion;

     /* Datos de respuesta del servidor*/
    
     private String resultado;
     private String nombre;
     private String nit;
     private String error;

    public String getVNit() {
        return VNit;
    }

    public void setVNit(String VNit) {
        this.VNit = VNit;
    }

    public String getEntity() {
        return Entity;
    }

    public void setEntity(String Entity) {
        this.Entity = Entity;
    }

    public String getRequestor() {
        return Requestor;
    }

    public void setRequestor(String Requestor) {
        this.Requestor = Requestor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

   
    
    
    
    
    
    
    
}
