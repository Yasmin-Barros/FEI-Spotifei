/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author unifybarros
 */
public class MusicaDAO {
     public List<Musica> buscarMusicas(String termo) {
        String sql = "SELECT * FROM musicas WHERE titulo LIKE ? OR artista LIKE ? OR genero LIKE ?";
        List<Musica> musicas = new ArrayList<>();

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, "%" + ? + "%");
            statement.setString(2, "%" + ? + "%");
            statement.setString(3, "%" + ? + "%");
            
             ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Musica musica = new Musica();
                musica.setId(resultado.getInt("id"));
                musica.setTitulo(resultado.getString("titulo"));
                musica.setArtista(resultado.getString("artista"));
                musica.setGenero(resultado.getString("genero"));
                musica.setDuracao(resultado.getInt("duracao"));
                musicas.add(musica);
            }
        }
