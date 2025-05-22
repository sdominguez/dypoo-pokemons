package com.user;

import com.pokemon.dao.PokemonDAO;
import com.pokemon.dao.PokemonDAOImp;
import com.pokemon.model.Pokemon;

import java.sql.SQLException;

public class MainPokemon {
    public static void main(String[] args) {
        PokemonDAO pokemonDAO = new PokemonDAOImp();
        System.out.println("Pokemons en base de datos");
        try {
            for(Pokemon pok : pokemonDAO.readAll()){
                System.out.println(pok);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
