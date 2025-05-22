package com.pokemon.dao;

import com.pokemon.connection.DatabaseConnetion;
import com.pokemon.model.Pokemon;
import com.pokemon.model.PokemonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAOImp implements PokemonDAO{

    private String tableName;

    public PokemonDAOImp(){
        tableName = "Pokemon";
    }
    @Override
    public void create(Pokemon pokemon) throws SQLException {

    }

    @Override
    public Pokemon read(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Pokemon pokemon) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<Pokemon> readAll() throws SQLException {
        List<Pokemon> pokemons = new ArrayList();
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "SELECT pokemon.id, name, weight, height, base_experience, type_id, type_name \n" +
                "FROM pokemon INNER JOIN pokemontype \n" +
                "WHERE type_id = pokemontype.id\n" +
                "ORDER BY pokemon.id;";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            pokemons.add(new Pokemon(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getDouble(4),
                    rs.getInt(5),
                    new PokemonType(rs.getInt(6), rs.getString(7))
            ));
        }
        return pokemons;
    }

    public List<Pokemon> readAll2() throws SQLException {
        List<Pokemon> pokemons = new ArrayList();
        PokemonTypeDAO typedao = new PokemonTypeDAOImp();
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "SELECT pokemon.id, name, weight, height, base_experience, type_id FROM pokemon ";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            pokemons.add(new Pokemon(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getDouble(4),
                    rs.getInt(5),
                    typedao.read(rs.getInt(6))
            ));
        }
        return pokemons;
    }
}
