package com.humanbooster.model;

import java.util.Map;

public abstract class GenericEntity {
    private final String entityName;

    public GenericEntity() {
        entityName = this.getClass().getSimpleName();
    }

    protected void print(Map<String,String> attributes){
        System.out.println("==========================================");
        System.out.println("              PRINT operation");
        System.out.println("==========================================");

        if (!attributes.isEmpty()) {
            System.out.println(entityName.toUpperCase() + " entity");
            System.out.println("------------------------------------------");
            for (Map.Entry<String,String> attr : attributes.entrySet()) {
                System.out.println(attr.getKey() + " : " + attr.getValue());
            }
        } else {
            System.err.println("ERROR : Impossible to PRINT null entity " + entityName);
        }
        System.out.println("\n");
    }
}
