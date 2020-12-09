/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fts.MigracionVas.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class cofidiWebService {

    public String restConsultaNitCofidi(String nit, String WsUrl) {

        String response = null;
        try {
            String nitVerificar = nit.replace(" ", "");
            RestTemplate restTemplate = new RestTemplate();
            String requestJson = "{\"nit\":\"" + nitVerificar + "\"}";
            requestJson = requestJson.replace(" ", "");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
            response  = restTemplate.postForObject(WsUrl, entity, String.class);
 
            System.out.println("\n<========================>\n URL: " + response + "\n");
            System.out.println("Solicitud: " + requestJson + "\n<=======================>\n");

        } catch (Exception ex) {
            System.out.println("-> Excepcion "+ex.getMessage());

        }
       
        return response;

    }

}

