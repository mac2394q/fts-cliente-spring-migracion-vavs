package com.fts.MigracionVas.cofidi.services;

import com.fts.MigracionVas.easyroad_temp.services.ClientesTempService;
import com.fts.MigracionVas.as2.entity.ClientesAS2;
import com.fts.MigracionVas.as2.services.ClientesAS2ServiceImpl;
import com.fts.MigracionVas.easyroad_db.entity.Clientes;
import com.fts.MigracionVas.easyroad_db.entity.Cuentas;
import com.fts.MigracionVas.easyroad_temp.entity.ClientesRechazadosCofidi;
import com.fts.MigracionVas.easyroad_temp.entity.ClientesTemp;
import com.fts.MigracionVas.easyroad_temp.entity.CuentasTemp;
import com.fts.MigracionVas.easyroad_db.entity.Tags;
import com.fts.MigracionVas.easyroad_db.entity.Vehiculos;
import com.fts.MigracionVas.easyroad_db.services.ClientesRechazadosServiceImpl;
import com.fts.MigracionVas.easyroad_db.services.ClientesServiceImpl;
import com.fts.MigracionVas.easyroad_db.services.CuentasServiceImpl;
import com.fts.MigracionVas.easyroad_db.services.TagsServicesImpl;
import com.fts.MigracionVas.easyroad_db.services.VehiculosServiceImpl;
import com.fts.MigracionVas.easyroad_temp.entity.TagsTemp;
import com.fts.MigracionVas.easyroad_temp.entity.VehiculosTemp;
import com.fts.MigracionVas.easyroad_temp.services.CuentasTempServiceImpl;
import com.fts.MigracionVas.easyroad_temp.services.TagsTempServiceImpl;
import com.fts.MigracionVas.easyroad_temp.services.VehiculosTempServiceImpl;
import com.fts.MigracionVas.rest.cofidiWebService;
import com.fts.MigracionVas.tools.generateUUID;
import com.fts.MigracionVas.tools.validacionDatos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CofidiServiceImpl implements CofidiService {

    @Value("${fts.ws.consultaNitCofidi}")
    private String WsUrl;

    @Value("${fts.ws.habilitarValidacionCofidi}")
    private boolean habilitarValidacionCofidi;

    /* easyroad_temp*/
    @Autowired
    private ClientesTempService ClienteTempServiceObj;

    @Autowired
    private ClientesRechazadosServiceImpl ClientesRechazadosServiceObj;

    @Autowired
    private CuentasTempServiceImpl CuentaTempServiceObj;

    @Autowired
    private VehiculosTempServiceImpl VehiculoTempServiceObj;

    @Autowired
    private TagsTempServiceImpl TagsTempServiceImpl;

    /*easyroad_db*/
    @Autowired
    private ClientesServiceImpl ClienteServiceObj;

    @Autowired
    private ClientesAS2ServiceImpl ClienteServiceAs2Obj;

    @Autowired
    private CuentasServiceImpl CuentaServiceObj;

    @Autowired
    private VehiculosServiceImpl VehiculoServiceObj;

    @Autowired
    private TagsServicesImpl TagsServiceObj;

    @Override
    public void implementacionMigracion(String tipoValidacion) {
        switch (tipoValidacion) {
            case "true":
                this.implementacionCofidi();
                break;
        }
    }

    @Override
    public boolean implementacionCofidi() {

        System.out.println("*=========================================*");
        System.out.println("*=     HABILITADO WS COFIDI              =*");
        System.out.println("*=========================================*\n");

        this.registrarMasivoClientes(ClienteTempServiceObj.ListadoClientes());
        return true;
    }

    public String registroMasivoClientesFacturacion(ClientesTemp clienteTemp) {

        ClientesAS2 clienteObjecto = new ClientesAS2();
        clienteObjecto.GenerarObjectoClienteAS2(clienteTemp);

        ClientesAS2 clienteVerificacion = ClienteServiceAs2Obj.obtenerClienteFacturacionVerificacion(clienteTemp.getIdentificacion());
        if (clienteVerificacion == null) {
            System.out.println("Creando Cliente Facturacion - AS2 OK");
            ClienteServiceAs2Obj.registrarClienteFacturacion(clienteObjecto);
            return clienteObjecto.getId();
        } else {
            System.out.println("Cliente Facturacion - AS2 Ya existente ");
            return clienteVerificacion.getId();
        }
        /* Retorna el idfacturacion es decir el UUID que se asignara al cliente. */
    }

    public boolean registrarMasivoClientes(List<ClientesTemp> listClientes) {

        for (ClientesTemp clienteTemp : listClientes) {

            if (ClienteServiceObj.BuscarClienteId(clienteTemp.getId()) == null) {

                cofidiWebService cofidiWS = new cofidiWebService();
                validacionDatos validacion = new validacionDatos();
                String NitCui = validacion.limpiarString(clienteTemp.getIdentificacion());

                int cf = NitCui.compareTo("C/F");
                if (cf == 0) {
                    System.out.println("Consumidor final");
                    this.registrarClienteCF(clienteTemp);
                } else {

                    ClientesAS2 clienteVerificacion = ClienteServiceAs2Obj.obtenerClienteFacturacionVerificacion(clienteTemp.getIdentificacion());
                    if (clienteVerificacion == null) {

                        try {
                            JSONObject ObjectJson = new JSONObject(cofidiWS.restConsultaNitCofidi(NitCui, WsUrl));
                            int estado = (int) ObjectJson.get("estado");

                            if (estado == 1) {
                                System.out.println("CLIENTE NUEVO ");
                                this.registrarClienteUnico(clienteTemp, ObjectJson);
                            } else {
                                System.out.println("cliente rechazado");
                                this.registrarClienteRechazadoCofidi(clienteTemp);
                            }

                        } catch (JSONException ex) {
                            System.out.println("Error de respuesta del servicio web cofidi, Reinicie este proceso para continuar");
                        }

                    } else {

                            System.out.println("Cliente Validado Cofidi -> TRUE " + clienteTemp.getNombre()+ " " + NitCui + "\n");

                            Clientes clienteObj = new Clientes();
                            clienteObj.objectoClientes(clienteTemp);

                            System.out.println(clienteTemp);
                          
                            clienteObj.setCliente_facturacion_id( clienteVerificacion.getId() );
                            clienteObj.setIdentificacion( String.valueOf( clienteTemp.getId() ) );

                            System.out.println( clienteObj );
                            ClienteServiceObj.RegistrarCliente(clienteObj);
                            ClienteTempServiceObj.eliminarClienteValidado(clienteTemp.getId());
                            this.registroMasivoCuentas(CuentaTempServiceObj.listadoCuentaByCliente(clienteTemp.getId()), String.valueOf(clienteObj.getId()));

                            System.out.println("*** Cliente Registrado satisfactoriamente. ***");
                            System.out.println("ID: " + clienteTemp.getId() + " Nombre " + clienteTemp.getNombre());
                    }
                }

            } else {
                System.out.println("Cliente ya Existente!");
            }
        }
        return true;
    }

    public boolean registroMasivoCuentas(List<CuentasTemp> listCuentas, String idcliente) {

        int id_bolsa = 0;
        int saldoBolsa = 0;
        String idClienteCuentas = idcliente;

        for (CuentasTemp cuentaTemp : listCuentas) {

            System.out.println(cuentaTemp);
            if (CuentaServiceObj.isBolsaCliente(idClienteCuentas) == 0) {
                Cuentas cuentaBolsa = new Cuentas(
                        idClienteCuentas,
                        cuentaTemp.getCuentaEstadosId(),
                        0,
                        0,
                        cuentaTemp.getInsertTime(),
                        cuentaTemp.getUpdateTime(),
                        idClienteCuentas,
                        "Cuenta - Bolsa ",
                        0,
                        1,
                        idClienteCuentas
                );

                CuentaServiceObj.RegistrarCuentas(cuentaBolsa);
                id_bolsa = CuentaServiceObj.ultimoIDregistrado();
                System.out.println("Bolsa Generada -> " + id_bolsa);
                saldoBolsa += cuentaTemp.getSaldo();
            }
            Cuentas cuenta = new Cuentas(
                    cuentaTemp.getId(),
                    String.valueOf(cuentaTemp.getId()),
                    cuentaTemp.getCuentaEstadosId(),
                    0,
                    0,
                    cuentaTemp.getInsertTime(),
                    cuentaTemp.getUpdateTime(),
                    String.valueOf(cuentaTemp.getId()),
                    "Cuenta Conectada a la bolsa",
                    id_bolsa,
                    0,
                    String.valueOf(cuentaTemp.getId())
            );
            System.out.println("Cuenta conectada a la bolsa ->" + cuentaTemp.getId());
            CuentaServiceObj.RegistrarCuentas(cuenta);
            CuentaTempServiceObj.eliminarCuentaValidado(cuentaTemp.getId());
            this.registroMasivoVehiculos(cuentaTemp.getId(), VehiculoTempServiceObj.findVehiculosByCuenta(cuentaTemp.getId()));
        }

        CuentaServiceObj.actualizarSaldoCuenta(saldoBolsa, idClienteCuentas);
        for (Cuentas listCuenta : CuentaServiceObj.finByListCuentasSaldoVerificacion(idClienteCuentas)) {
            VehiculoServiceObj.actualizarSaldoVehiculo(saldoBolsa, listCuenta.getId());
        }

        return true;
    }

    public boolean registroMasivoVehiculos(int idCuenta, List<VehiculosTemp> vehiculostemp) {

        vehiculostemp.stream().map(vehiculosTemp -> {
            System.out.println(vehiculosTemp);
            System.out.println(vehiculosTemp.getTid() + " - " + vehiculosTemp.getPlacaVehiculo() + " - " + idCuenta);
            Vehiculos vehiculos = new Vehiculos();
            vehiculos.objectoVehiculos(vehiculosTemp);
            //0 - categoria ,1 - numero ejes ,2 - tipo eje 
            int array[] = vehiculos.equivalenciaCategorias(vehiculosTemp.getCategoriaId());
            vehiculos.setCategoriaId(array[0]);
            vehiculos.setNumEjes(array[1]);
            vehiculos.setTipoEspecialesId(array[2]);
            VehiculoServiceObj.registrarVehiculo(vehiculos);
            VehiculoTempServiceObj.eliminarVehiculoValidado(vehiculosTemp.getId());
            List<TagsTemp> tagsTemp = TagsTempServiceImpl.listadoTagsByCuenta(vehiculosTemp.getCuentaId());
            tagsTemp.forEach(tagstemp -> {
                System.out.println(tagstemp.getId() + " " + tagstemp.getClienteId() + " " + tagstemp.getCuentaId());
            });
            this.registroMasivoTags(tagsTemp, idCuenta);
            return vehiculosTemp;
        }).map(vehiculosTemp -> {
            return vehiculosTemp;
        }).forEachOrdered(vehiculosTemp -> {
            //
        });

        return true;
    }

    public boolean registroMasivoTags(List<TagsTemp> tagsTemp, int idCuenta) {

        validacionDatos validacion = new validacionDatos();

        tagsTemp.forEach(tagstemp -> {
            System.out.println(tagstemp);
            System.out.println(" TAG ID  " + tagstemp.getId() + " " + tagstemp.getCuentaId());
            Tags tags = new Tags(
                    tagstemp.getId(),
                    tagstemp.getTagId(),
                    tagstemp.getClienteId(),
                    tagstemp.getNumeroFacial(),
                    tagstemp.getCuentaId(),
                    tagstemp.getVehiculoId(),
                    tagstemp.getTarjetaEstadosId(),
                    tagstemp.getInsertTime(),
                    tagstemp.getUpdateTime(),
                    tagstemp.getArchivoContrato(),
                    tagstemp.getPlacaVehiculo(),
                    tagstemp.getEstadoCompra()
            );
            TagsServiceObj.RegistarTags(tags);
            TagsTempServiceImpl.eliminarTagsValidado(tagstemp.getId());
        });
        return true;
    }

    public boolean registrarClienteUnico(ClientesTemp clienteTemp, JSONObject ObjectJson) {

        try {
            validacionDatos validacion = new validacionDatos();
            String nombre = validacion.limpiarString(String.valueOf(ObjectJson.get("nombre")));
            String NitCui = validacion.limpiarString(clienteTemp.getIdentificacion());

            System.out.println("Cliente Validado Cofidi -> TRUE " + nombre + " " + NitCui + "\n");

            clienteTemp.setIdentificacion(NitCui);
            clienteTemp.setNombre(nombre);

            Clientes clienteObj = new Clientes();
            clienteObj.objectoClientes(clienteTemp);

            System.out.println(clienteTemp);
            String idFacturacion = this.registroMasivoClientesFacturacion(clienteTemp);

            clienteObj.setCliente_facturacion_id(idFacturacion);
            clienteObj.setIdentificacion(String.valueOf(clienteTemp.getId()));

            System.out.println(clienteObj);
            ClienteServiceObj.RegistrarCliente(clienteObj);
            ClienteTempServiceObj.eliminarClienteValidado(clienteTemp.getId());
            this.registroMasivoCuentas(CuentaTempServiceObj.listadoCuentaByCliente(clienteTemp.getId()), String.valueOf(clienteObj.getId()));

            System.out.println("*** Cliente Registrado satisfactoriamente. ***");
            System.out.println("ID: " + clienteTemp.getId() + " Nombre " + clienteTemp.getNombre());

        } catch (JSONException ex) {
            Logger.getLogger(CofidiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

    public boolean registrarClienteCF(ClientesTemp clienteTemp) {

        validacionDatos validacion = new validacionDatos();

        clienteTemp.setIdentificacion("");
        Clientes clienteObj = new Clientes();
        clienteObj.objectoClientes(clienteTemp);
        System.out.println(clienteTemp);
        ClientesAS2 clienteAs2 = ClienteServiceAs2Obj.obtenerClienteCF();
        System.out.println(clienteAs2);
        System.out.println("Cliente C/F Validado Cofidi -> TRUE " + clienteAs2.toString() + "  \n");
        clienteObj.setCliente_facturacion_id(clienteAs2.getId());
        clienteObj.setIdentificacion(String.valueOf(clienteTemp.getId()));

        System.out.println(clienteObj);
        ClienteServiceObj.RegistrarCliente(clienteObj);
        ClienteTempServiceObj.eliminarClienteValidado(clienteTemp.getId());
        this.registroMasivoCuentas(CuentaTempServiceObj.listadoCuentaByCliente(clienteTemp.getId()), String.valueOf(clienteObj.getId()));

        System.out.println("*** Cliente Registrado satisfactoriamente. ***");
        System.out.println("ID: " + clienteTemp.getId() + " Nombre " + clienteTemp.getNombre());

        return true;

    }

    public boolean registrarClienteRechazadoCofidi(ClientesTemp clienteTemp) {

        System.out.println("Cliente Rechazado Cofidi -> FALSE " + clienteTemp.getNombre() + " " + clienteTemp.getIdentificacion() + "\n");

        ClientesRechazadosCofidi clienteRechazadosObj = new ClientesRechazadosCofidi(
                clienteTemp.getId(),
                clienteTemp.getNombre(),
                clienteTemp.getIdentificacion(),
                clienteTemp.getTipoDocumento(),
                clienteTemp.getDireccion(),
                clienteTemp.getTelefono(),
                clienteTemp.getEmail(),
                clienteTemp.getClienteEstadosId(),
                clienteTemp.getInsertTime(),
                clienteTemp.getUpdateTime(),
                clienteTemp.getTipoClienteId(),
                clienteTemp.getTelefono(),
                clienteTemp.getCiudad(),
                clienteTemp.getSyncField(),
                clienteTemp.getCliente_facturacion_id()
        );
        System.out.println(clienteRechazadosObj);
        ClientesRechazadosServiceObj.RegistrarCliente(clienteRechazadosObj);
        ClienteTempServiceObj.eliminarClienteValidado(clienteTemp.getId());
        System.out.println("Cliente  registrado como rechazado !");
        System.out.println("ID: " + clienteTemp.getId() + " Nombre " + clienteTemp.getNombre());

        return true;

    }

}






