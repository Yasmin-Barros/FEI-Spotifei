/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.MusicaDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Musica;
import model.Usuario;
import view.HistoricoGUI;

/**
 *
 * @author Lukinhas
 */
public class ControllerHistorico {
    private HistoricoGUI viewH;
    private MusicaDAO dao;
    int idUsuario = Usuario.getUsuarioLogado().getId();
    
    public ControllerHistorico(HistoricoGUI viewH) throws SQLException {
        this.viewH = viewH;
        
        Usuario usuariologado = Usuario.getUsuarioLogado();

        if (usuariologado == null) {
            JOptionPane.showMessageDialog(viewH, "Nenhum usuário está logado. Faça login primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalStateException("Tentativa de usar, sem usuário logado.");
        }
        this.idUsuario = usuariologado.getId();

        Connection conn = new Conexao().getConnection();
        this.dao = new MusicaDAO(conn);
    }
    
    public void carregarHistorico() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) viewH.getTabelaResultadoHistorico().getModel();
        model.setRowCount(0); 

        ArrayList<String> historico = dao.ultimasBuscas(idUsuario);
        for (String texto : historico) {
            model.addRow(new Object[]{texto});
        }
    }

    public void carregarCurtidas() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) viewH.getTabelaResultadoCurtidas().getModel();
        model.setRowCount(0); // limpa

        ArrayList<Musica> lista = dao.buscarCurtidas();
        for (Musica m : lista) {
            model.addRow(new Object[]{
                m.getMusicaTitulo(),
                m.getMusicaGenero(),
                m.getNomeArtista()
            });
        }
    }

    public void carregarDescurtidas() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) viewH.getTabelaResultadoDescurtidas().getModel();
        model.setRowCount(0); // limpa

        ArrayList<Musica> lista = dao.buscarDescurtidas();
        for (Musica m : lista) {
            model.addRow(new Object[]{
                m.getMusicaTitulo(),
                m.getMusicaGenero(),
                m.getNomeArtista()
            });
        }
    }
}
