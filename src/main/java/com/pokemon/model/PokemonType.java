package com.pokemon.model;

import java.io.Serializable;

/**
 * PokemonType es una clase que mapea un esquema en la base de datos
 */
public class PokemonType implements Serializable {
    private int id;
    private String typeName;

    public PokemonType() {
    }

    public PokemonType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
