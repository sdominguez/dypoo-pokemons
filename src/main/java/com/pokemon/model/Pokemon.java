package com.pokemon.model;

import java.io.Serializable;

/**
 * Pokemon es una clase que mapea un esquema en la base de datos
 */
public class Pokemon implements Serializable {
    private int id;
    private String name;
    private double weight;
    private double height;
    private int baseExperience;
    private PokemonType pokemonType;

    public Pokemon() {
    }

    public Pokemon(int id, String name, double weight, double height, int baseExperience) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.baseExperience = baseExperience;
    }

    public Pokemon(int id, String name, double weight, double height, int baseExperience, PokemonType pokemonType) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.baseExperience = baseExperience;
        this.pokemonType = pokemonType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return "{\n" +
                "   id: "+id+"\n"+
                "   name: "+name+"\n"+
                "   weight: "+weight+"\n"+
                "   height: "+height+"\n"+
                "   baseExperience: "+baseExperience+"\n"+
                "   type: "+pokemonType.getTypeName()+
                "\n}";
    }
}
