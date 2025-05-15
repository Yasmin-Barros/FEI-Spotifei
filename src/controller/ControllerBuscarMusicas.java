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
import view.BuscarMusicasGUI;
/**
 *
 * @author Lukinhas
 */
public class ControllerBuscarMusicas {
    private BuscarMusicasGUI view;
    private MusicaDAO dao;

    public ControllerBuscarMusicas(BuscarMusicasGUI view) throws SQLException{
        this.view = view;
        
        Connection conn = new Conexao().getConnection();
        this.dao = new MusicaDAO(conn);
    }

    public void buscarMusica() {
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
}

