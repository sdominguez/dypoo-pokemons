package com.user;

import com.pokemon.connection.DatabaseConnetion;
import com.pokemon.dao.PokemonTypeDAO;
import com.pokemon.dao.PokemonTypeDAOImp;
import com.pokemon.model.PokemonType;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PokemonTypeDAO typeDAO = new PokemonTypeDAOImp();
            List<PokemonType> types = typeDAO.readAll();
            System.out.println("Lista de tipos de pokemons: ");
            for (PokemonType type : types){
                System.out.println(type.getTypeName());
            }

            //creando un tipo de pokemon
            PokemonType nuevoTipo = new PokemonType(0, "Fuego");
            //typeDAO.create(nuevoTipo);

            PokemonType tipo = typeDAO.read(12);
            System.out.println("Tipo de Pokemon: "+tipo.getTypeName());
            tipo.setTypeName("tipo actualizado");
            typeDAO.update(tipo);

            //typeDAO.delete(13);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
