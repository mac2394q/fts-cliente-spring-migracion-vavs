
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

@Data
@Entity
@Table(name="easyroad_temp.tags")
public class TagsTemp implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "tag_id")
    private String tagId;
    
    @Column(name = "cliente_id")
    private int clienteId;
    @Column(name = "numero_facial")
    private String numeroFacial;
    
    @Column(name = "cuenta_id")
    private int cuentaId;
    
    @Column(name = "vehiculo_id")
    private int vehiculoId;
    
    @Column(name = "tarjeta_estados_id")
    private int tarjetaEstadosId;
    @Column(name = "insertTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "updateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "archivo_contrato")
    private String archivoContrato;
    @Column(name = "placa_vehiculo")
    private String placaVehiculo;
    @Column(name = "estado_compra")
    private int estadoCompra;

    public TagsTemp(int id, String tagId, int clienteId, String numeroFacial, int cuentaId, int vehiculoId, int tarjetaEstadosId, Date insertTime, Date updateTime, String archivoContrato, String placaVehiculo, int estadoCompra) {
        this.id = id;
        this.tagId = tagId;
        this.clienteId = clienteId;
        this.numeroFacial = numeroFacial;
        this.cuentaId = cuentaId;
        this.vehiculoId = vehiculoId;
        this.tarjetaEstadosId = tarjetaEstadosId;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.archivoContrato = archivoContrato;
        this.placaVehiculo = placaVehiculo;
        this.estadoCompra = estadoCompra;
    }

    public TagsTemp() {
    }
    
}
