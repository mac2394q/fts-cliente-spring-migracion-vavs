/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.tools;

/**
 *
 * @author Priceleggan
 */
public class validacionDatos {
    
    public String limpiarString( String cadena){
        
        cadena  = cadena.replace("-", "");
        cadena  = cadena .replace(".", "");
        cadena  = cadena .replace("\\s", "");
        cadena  = cadena .replace(" ", "");
        cadena  = cadena.replace(",", " ");
        return cadena;
        
    }
    
}





