/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Musica;

/**
 *
 * @author unifybarros
 */
public class MusicaDAO {
    private Connection conn;
    
    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }

     public void buscarMusicas(Musica musica, JTable tabelaResultadoMusicas) throws SQLException {
        String sql = "SELECT * FROM tabelaMusicas WHERE musicaTitulo ILIKE ? "
                       +"OR nomeArtista ILIKE ? OR musicaGenero ILIKE ?";
        

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            String busca = "%" + musica + "%";

            statement.setString(1, busca); // Se for tal ttitulo
            statement.setString(2, busca); // tal artista etc
            statement.setString(3, busca);
            
            ResultSet resultado = statement.executeQuery();
            
            DefaultTableModel resp = (DefaultTableModel) tabelaResultadoMusicas.getModel();
            resp.setRowCount(0);
        
            while (resultado.next()) {
                Object[] row = {
                resultado.getString("musicaTitulo"),
                resultado.getString("nomeArtista"),
                resultado.getString("musicaGenero")
            };
            resp.addRow(row);
}

            }
        }
}