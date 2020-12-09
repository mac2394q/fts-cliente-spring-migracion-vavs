package com.fts.MigracionVas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fts.MigracionVas.cofidi.services.CofidiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.Scanner;
import com.fts.MigracionVas.easyroad_db.services.ClientesRechazadosCofidiService;

@SpringBootApplication
public class MigracionVasApplication implements CommandLineRunner {

    @Autowired
    private ClientesRechazadosCofidiService ClienteServiceObj;

    @Autowired
    private CofidiServiceImpl CofidiServiceImplObj;

    @Value("${fts.ws.consultaNitCofidi}")
    private String WsUrl;

    @Value("${fts.ws.habilitarValidacionCofidi}")
    private boolean habilitarValidacionCofidi;

    @Value("${spring.datasource.url}")
    private String urldb;
    @Value("${spring.datasource.username}")
    private String usernamedb;
    @Value("${spring.datasource.password}")
    private String passworddb;
    @Value("${server.port}")
    private String port;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.jpa.database-platform}")
    private String versionDialect;

    private static final Logger LOG = LoggerFactory.getLogger(MigracionVasApplication.class);

    public static void main(String[] args) {
        LOG.info("Aplicacion Migracion VAS : Lanzamiento.");
        SpringApplication.run(MigracionVasApplication.class, args);
        LOG.info("Aplicacion Migracion VAS :Lanzamiento Terminado.");
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Aplicacion Migracion Vas : En funcionamiento.");
        this.menuMigracionVas();
    }

    public void menuMigracionVas() {

        String inputKey;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("*================================================*");
        System.out.println("**************************************************");
        System.out.println("**         MIGRACION VAS    v2.0                 **");
        System.out.println("**************************************************");
        System.out.println("**FTS TECNOLOGIA    ******************************");
        System.out.println("*===================================mac===========*\n");
        System.out.println("*=====      OPCIONES       ======================*");
        System.out.println("**************************************************");
        System.out.println("** 1  -  Validacion/Migracion Clientes Vas        **");
        System.out.println("** 0  -  Informacion de configuracion             **");
        System.out.println("** 3 -  CONSULTA NIT - COFIDI                    **");
        System.out.println("*====================================mac============*\n");
        System.out.println("*SELECCIONE OPCION   \r  ->                         *");
        inputKey = inputScanner.nextLine();
        switch (Integer.parseInt(inputKey)) {

            case 1:
                this.CofidiServiceImplObj.implementacionMigracion(String.valueOf(habilitarValidacionCofidi));
                break;
                
            

            case 3:
                String inputKeyNit_;
                Scanner inputScannerNit_ = new Scanner(System.in);
                System.out.println("*=====================================================================================================*");
                System.out.println("** CONSULTA NIT - COFIDI");
                System.out.println("** Ingresa el nit a consultar: ");
                inputKeyNit_ = inputScannerNit_.nextLine();
                break;

            case 0:
                System.out.println("*=====================================================================================================*");
                System.out.println("** INFORMACION DE CONFIGURACION");
                System.out.println("**");
                System.out.println("** Info : application.properties");
                System.out.println("**");
                System.out.println("**           BASE DE DATOS");
                System.out.println("**");
                System.out.println("** Usuario : " + usernamedb);
                System.out.println("**");
                System.out.println("** Clave : " + passworddb);
                System.out.println("**");
                System.out.println("** URL : " + urldb);
                System.out.println("**");
                System.out.println("** Driver : " + driver);
                System.out.println("**");
                System.out.println("** Dialecto  y version  Mysql : " + versionDialect);
                System.out.println("**");
                System.out.println("**        OTRAS CONFIGURACIONES");
                System.out.println("**");
                System.out.println("** PUERTO : " + port + "");
                System.out.println("**");
                System.out.println("** SERVICIO WEB COFIDI : " + WsUrl);
                System.out.println("*=====================================================================================================*");
                break;
        }
        
        

    }




   

}

