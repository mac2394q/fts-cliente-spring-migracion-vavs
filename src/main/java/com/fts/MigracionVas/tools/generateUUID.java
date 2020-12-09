package com.fts.MigracionVas.tools;


import java.util.UUID;



public class generateUUID {
    
    private  UUID rev;
    
    public String getUUID(){
        rev = UUID.randomUUID();
        return String.valueOf(rev);
    }
    
}
