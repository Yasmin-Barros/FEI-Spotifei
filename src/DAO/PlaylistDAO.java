/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Playlist;
import model.Musica;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Lukinhas
 */
public class PlaylistDAO {
       private Connection connection;

    public PlaylistDAO(Connection connection) {
        this.connection = connection;
    }

    // Cria uma nova playlist
    public boolean criarPlaylist(String nome, int usuarioId) throws SQLException {
        String sql = "INSERT INTO tabelaplaylist (nome, usuarioid) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, usuarioId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Edita o nome de uma playlist
    public boolean editarPlaylist(int playlistId, String novoNome) throws SQLException {
        String sql = "UPDATE tabelaplaylist SET nome = ? WHERE playlist_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, playlistId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Exclui uma playlist
    public boolean excluirPlaylist(int playlistId) throws SQLException {
        String sql = "DELETE FROM tabelaplaylist WHERE playlist_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Adiciona uma música à playlist
    public boolean adicionarMusicaPlaylist(int playlistId, int musicaId) throws SQLException {
        String sql = "INSERT INTO playlist_musicas (playlist_id, musica_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Remove uma música da playlist
    public boolean removerMusicaPlaylist(int playlistId, int musicaId) throws SQLException {
        String sql = "DELETE FROM playlist_musicas WHERE playlist_id = ? AND musica_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Lista todas as playlists de um usuário
    public ArrayList<Playlist> listarPlaylistsUsuario(int usuarioId) throws SQLException {
        ArrayList<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT playlist_id, nome FROM tabelaplaylist WHERE usuarioid = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Playlist playlist = new Playlist();
                playlist.setIdPlaylist(rs.getInt("playlist_id"));
                playlist.setPlaylistTitulo(rs.getString("nome"));
                playlists.add(playlist);
            }
        }
        return playlists;
    }

    // Lista todas as músicas de uma playlist
    public ArrayList<Musica> listarMusicasPlaylist(int playlistId) throws SQLException {
        ArrayList<Musica> musicas = new ArrayList<>();
        String sql = "SELECT m.idmusica, m.musicatitulo, m.musicagenero, m.nomeartista " +
                     "FROM tabelamusicas m JOIN playlist_musicas pm ON m.idmusica = pm.musica_id " +
                     "WHERE pm.playlist_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Musica musica = new Musica();
                musica.setIdMusica(rs.getInt("idmusica"));
                musica.setMusicaTitulo(rs.getString("musicatitulo"));
                musica.setMusicaGenero(rs.getString("musicagenero"));
                musica.setNomeArtista(rs.getString("nomeartista"));
                musicas.add(musica);
            }
        }
        return musicas;
    }
}