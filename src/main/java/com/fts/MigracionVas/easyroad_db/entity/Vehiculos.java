/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.easyroad_db.entity;

import com.fts.MigracionVas.easyroad_temp.entity.VehiculosTemp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Priceleggan
 */
@Data
@Entity
@Table(name="easyroad_db.vehiculos")
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "TID")
    private String tid;
    @Column(name = "EPC")
    private String epc;
    @Column(name = "recaudador_id")
    private int recaudadorId;
    
    @Column(name = "categoria_id")
    private int categoriaId;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    
    @Column(name = "estado")
    private int estado;
    @Column(name = "tipos_contrato_id")
    private int tiposContratoId;
    
    @Column(name = "placa_vehiculo")
    private String placaVehiculo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "saldo")
    private int saldo;
    @Column(name = "num_ejes")
    private int numEjes;
    @Column(name = "tipo_ejes_id")
    private int tipoEjesId;
    @Column(name = "tipo_especiales_id")
    private int tipoEspecialesId;
    @Column(name = "cuenta_id")
    private int cuentaId;
    
    @Column(name = "forma_pago_id")
    private int formaPagoId;
    @Column(name = "credito")
    private int credito;
    @Column(name = "estado_saldo_id")
    private int estadoSaldoId;
    @Column(name = "estado_sincro_id")
    private int estadoSincroId;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "fecha_sincronizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSincronizacion;

    @Column(name = "modelo_vehiculo")
    private String modeloVehiculo;
    @Column(name = "marca_vehiculo")
    private String marca_vehiculo;
    @Column(name = "color_vehiculo")
    private String colorVehiculo;
    @Column(name = "fecha_insercion")
    private String fechaInsercion;
    @Column(name = "descripcion_vehiculo")
    private String descripcioVehiculo;

    public Vehiculos(
            int id, String tid,String epc, int recaudadorId,int categoriaId,Date fechaEmision,int estado,
            int tiposContratoId, String placaVehiculo, int saldo, int numEjes, int tipoEjesId,
            int tipoEspecialesId, int cuentaId, int formaPagoId,int credito, int estadoSaldoId, 
            int estadoSincroId, Date fechaActualizacion, Date fechaSincronizacion, 
            String modeloVehiculo,String marca_vehiculo,  String colorVehiculo, String fechaInsercion, 
            String descripcioVehiculo) {
        this.id = id;
        this.tid = tid;
        this.epc = epc;
        this.recaudadorId = recaudadorId;
        this.categoriaId = categoriaId;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.tiposContratoId = tiposContratoId;
        this.placaVehiculo = placaVehiculo;
        this.saldo = saldo;
        this.numEjes = numEjes;
        this.tipoEjesId = tipoEjesId;
        this.tipoEspecialesId = tipoEspecialesId;
        this.cuentaId = cuentaId;
        this.formaPagoId = formaPagoId;
        this.credito = credito;
        this.estadoSaldoId = estadoSaldoId;
        this.estadoSincroId = estadoSincroId;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaSincronizacion = fechaSincronizacion;
        this.modeloVehiculo = modeloVehiculo;
        this.marca_vehiculo = marca_vehiculo;
        this.colorVehiculo = colorVehiculo;
        this.fechaInsercion = fechaInsercion;
        this.descripcioVehiculo = descripcioVehiculo;
 
    }
    
    public void objectoVehiculos(  VehiculosTemp vehiculosTemp ) {
        
        this.id =  vehiculosTemp.getId();
        this.tid = vehiculosTemp.getTid();
        this.epc = vehiculosTemp.getEpc();
        this.recaudadorId = 0;//recaudadorId;
        this.categoriaId = 0;//CategoriaId;
        this.fechaEmision = vehiculosTemp.getFechaEmision();
        this.estado = vehiculosTemp.getEstado();
        this.tiposContratoId = vehiculosTemp.getTiposContratoId();
        this.placaVehiculo = vehiculosTemp.getPlacaVehiculo();
        this.saldo =  0;//saldo;
        this.numEjes = 0; //setNumEjes;
        this.tipoEjesId = 0;//tipoEjesId;
        this.tipoEspecialesId =  0; //TipoEspecialesId;
        this.cuentaId = vehiculosTemp.getCuentaId();
        this.formaPagoId = vehiculosTemp.getFormaPagoId();
        this.credito =  vehiculosTemp.getCredito();
        this.estadoSaldoId = vehiculosTemp.getEstadoSaldoId();
        this.estadoSincroId = vehiculosTemp.getEstadoSincroId();
        this.fechaActualizacion = vehiculosTemp.getFechaActualizacion();
        this.fechaSincronizacion =  vehiculosTemp.getFechaSincronizacion();
        this.modeloVehiculo =  vehiculosTemp.getModeloVehiculo();
        this.marca_vehiculo = vehiculosTemp.getMarca_vehiculo();
        this.colorVehiculo = vehiculosTemp.getColorVehiculo();
        this.fechaInsercion = vehiculosTemp.getFechaInsercion();
        this.descripcioVehiculo = vehiculosTemp.getDescripcioVehiculo();
 
    }

    public Vehiculos() {
    }
    
    public int[] equivalenciaCategorias(int categoriasVas) {
        int categoriasEquivalente = 0;
        int numeroEje =0;
        int idEspecial = 0;
        switch (categoriasVas) {

            case 1:  
                categoriasEquivalente = 1;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 2:  
                categoriasEquivalente = 1;
                numeroEje =2;
                idEspecial = 2;
            break; 
            
            case 3:  
                categoriasEquivalente = 1;
                numeroEje =2;
                idEspecial = 3;
            break; 
            
            case 4:  
                categoriasEquivalente = 2;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 5:
                categoriasEquivalente = 3;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 6:  
                categoriasEquivalente = 4;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 7:  
                categoriasEquivalente = 5;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 8:  
                categoriasEquivalente = 6;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 9:  
                categoriasEquivalente = 7;
                numeroEje =0;
                idEspecial = 0;
            break; 
            
            case 10:  
                categoriasEquivalente = 8;
                numeroEje =0;
                idEspecial = 0;
            break; 

        }

        return new int[] {categoriasEquivalente,numeroEje,idEspecial};
    }

    
    
}














