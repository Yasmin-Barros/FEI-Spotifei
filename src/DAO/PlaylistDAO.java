/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dao.Conexao;
import model.Playlist;
import model.Musica;
import java.sql.*;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author Lukinhas
 */
public class PlaylistDAO {
    private Connection conn;
    private int idUsuario = Usuario.getUsuarioLogado().getId();

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
        this.idUsuario = Usuario.getUsuarioLogado().getId();
    }

    public ArrayList<Playlist> listarPlaylistsDoUsuario() throws SQLException {
        ArrayList<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT * FROM tabelaplaylist WHERE usuarioid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Playlist p = new Playlist();
                p.setIdPlaylist(rs.getInt("idplaylist"));
                p.setPlaylistTitulo(rs.getString("nomeplaylist"));
                playlists.add(p);
            }
        }

        return playlists;
    }

    public void adicionarMusicaNaPlaylist(int idPlaylist, int idMusica) throws SQLException {
        String sql = "INSERT INTO playlistMusicas (playlistid, musicaid) VALUES (?, ?) ON CONFLICT DO NOTHING";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
        }
    }

    public void removerMusicaDaPlaylist(int idPlaylist, int idMusica) throws SQLException {
        String sql = "DELETE FROM playlistMusicas WHERE playlistid = ? AND musicaid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
        }
    }

    public void criarPlaylist(String nome) throws SQLException {
        String sql = "INSERT INTO tabelaplaylist (usuarioid, nomeplaylist) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setString(2, nome);
            stmt.executeUpdate();
        }
    }

    public void excluirPlaylist(int idPlaylist) throws SQLException {
        String sql = "DELETE FROM tabelaplaylist WHERE idplaylist = ? AND usuarioid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();
        }
    }

    public void editarNomePlaylist(int idPlaylist, String novoNome) throws SQLException {
        String sql = "UPDATE tabelaplaylist SET nomeplaylist = ? WHERE idplaylist = ? AND usuarioid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, idPlaylist);
            stmt.setInt(3, idUsuario);
            stmt.executeUpdate();
        }
    }
}
