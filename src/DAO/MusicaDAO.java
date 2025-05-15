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
        System.out.println("Valor em musica.getMusicaTitulo(): '" + musica.getMusicaTitulo() + "'");
         String sql = "SELECT * FROM tabelaMusicas WHERE musicatitulo ILIKE ? "
                       +"OR musicaGenero ILIKE ? OR nomeArtista ILIKE ?";
        

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            String busca = "%" + musica.getMusicaTitulo() + "%";
        System.out.println("Texto da busca: " + busca);

            statement.setString(1, busca);
            statement.setString(2, busca);
            statement.setString(3, busca);
            
            ResultSet resultado = statement.executeQuery();
            
            DefaultTableModel resp = (DefaultTableModel) tabelaResultadoMusicas.getModel();
            resp.setRowCount(0);
        
            while (resultado.next()) {
                Object[] row = {
                resultado.getString("musicaTitulo"),
                resultado.getString("musicaGenero"),
                resultado.getString("nomeArtista")
            };
            resp.addRow(row);
}

            }
        }
}