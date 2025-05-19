/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.MusicaDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Musica;
import model.Usuario;
import view.BuscarMusicasGUI;
/**
 *
 * @author Lukinhas
 */
public class ControllerMusicas {
    private BuscarMusicasGUI view;
    private MusicaDAO dao;
    int idUsuario;

    public ControllerMusicas(BuscarMusicasGUI view) throws SQLException{
        Usuario usuariologado = Usuario.getUsuarioLogado();
        
        if (usuariologado == null) {
        JOptionPane.showMessageDialog(view, "Nenhum usuário está logado. Faça login primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        throw new IllegalStateException("Tentativa de usar ControllerMusicas sem usuário logado.");
    }
        this.idUsuario = usuariologado.getId();
        this.view = view;
        //this.idUsuario = idUsuario;
        
        Connection conn = new Conexao().getConnection();
        this.dao = new MusicaDAO(conn);
    }

    public void buscarMusica() throws SQLException{
        String textoBusca = view.getCaixaBusca().getText();
        System.out.println("Texto digitado: '" + textoBusca + "'");
        
        if (textoBusca == null || textoBusca.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Digite algo!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Musica musica = new Musica();
        musica.setMusicaTitulo(textoBusca); 

        try {
            dao.buscarMusicas(musica, view.getTabelaResultadoMusicas()); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar músicas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void curtirMusica() throws SQLException{
        int linhaSelecionada = view.getTabelaResultadoMusicas().getSelectedRow();
        
        if (linhaSelecionada == -1) {
            
            JOptionPane.showMessageDialog(view, "Selecione uma música para curtir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idMusica = (int) view.getTabelaResultadoMusicas().getValueAt(linhaSelecionada, 3);
        
        dao.curtirMusicas(idMusica, this.idUsuario);
        JOptionPane.showMessageDialog(view, "Música curtida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void descurtirMusica() throws SQLException{
        int linhaSelecionada = view.getTabelaResultadoMusicas().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Selecione uma música para descurtir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idMusica = (int) view.getTabelaResultadoMusicas().getValueAt(linhaSelecionada, 3);

        try {
            dao.descurtirMusicas(idMusica, this.idUsuario);
            JOptionPane.showMessageDialog(view, "Música descurtida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao descurtir música: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}




