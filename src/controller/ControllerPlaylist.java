/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Lukinhas
 */
import DAO.PlaylistDAO;
import dao.Conexao;
import model.Playlist;
import model.Usuario;
import view.BuscarMusicasGUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerPlaylist {

    private PlaylistDAO dao;
    private BuscarMusicasGUI view;
    private int idUsuario;

    public ControllerPlaylist(BuscarMusicasGUI view) throws SQLException {
        Usuario usuarioLogado = Usuario.getUsuarioLogado();

        if (usuarioLogado == null) {
            JOptionPane.showMessageDialog(view, "Nenhum usuário está logado. Faça login primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalStateException("Tentativa de usar ControllerPlaylist sem usuário logado.");
        }

        this.idUsuario = usuarioLogado.getId();
        this.view = view;

        Connection conn = new Conexao().getConnection();
        this.dao = new PlaylistDAO(conn);
    }

    public void adicionarMusicaNaPlaylist(int idMusica, String nomePlaylist) throws SQLException {
        List<Playlist> playlists = dao.listarPlaylistsDoUsuario();

        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistTitulo().equalsIgnoreCase(nomePlaylist)) {
                dao.adicionarMusicaNaPlaylist(playlist.getIdPlaylist(), idMusica);
                JOptionPane.showMessageDialog(view, "Música adicionada à playlist com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        throw new SQLException("Playlist não encontrada: " + nomePlaylist);
    }

    public void criarPlaylist(String nome) throws SQLException {
        dao.criarPlaylist(nome);
        JOptionPane.showMessageDialog(view, "Playlist criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void excluirPlaylist(int idPlaylist) throws SQLException {
        dao.excluirPlaylist(idPlaylist);
        JOptionPane.showMessageDialog(view, "Playlist excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void editarNomePlaylist(int idPlaylist, String novoNome) throws SQLException {
        dao.editarNomePlaylist(idPlaylist, novoNome);
        JOptionPane.showMessageDialog(view, "Nome da playlist editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void removerMusicaDaPlaylist(int idMusica, String nomePlaylist) throws SQLException {
        List<Playlist> playlists = dao.listarPlaylistsDoUsuario();

        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistTitulo().equalsIgnoreCase(nomePlaylist)) {
                dao.removerMusicaDaPlaylist(playlist.getIdPlaylist(), idMusica);
                JOptionPane.showMessageDialog(view, "Música removida da playlist com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        throw new SQLException("Playlist não encontrada: " + nomePlaylist);
    }
    
    
}
