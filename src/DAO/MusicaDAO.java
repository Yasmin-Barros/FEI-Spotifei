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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Musica;
import model.Usuario;

/**
 *
 * @author unifybarros
 */
public class MusicaDAO {

    private Connection conn;
    int idUsuario = Usuario.getUsuarioLogado().getId();

    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }

    public void buscarMusicas(Musica musica, JTable tabelaResultadoMusicas) throws SQLException {
        System.out.println("Valor em musica.getMusicaTitulo(): '" + musica.getMusicaTitulo() + "'");
        System.out.println("idUsuario recebido: " + idUsuario);

        String sql = "SELECT * FROM tabelaMusicas WHERE musicatitulo ILIKE ? "
                + "OR musicaGenero ILIKE ? OR nomeArtista ILIKE ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            String busca = "%" + musica.getMusicaTitulo() + "%";
            //Era p ver oq tava retornando(e tava retornando null rsrs mas já tá arrumado
            //System.out.println("Texto da busca: " + busca);

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
                    resultado.getString("nomeArtista"),
                    resultado.getInt("idmusica")
                };
                resp.addRow(row);
            }

        }
    }

    public void registrarHistorico(String texto) throws SQLException {
        String sql = "INSERT INTO tabelahistorico (usuarioid, textoBusca) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            System.out.println("Salvando no histórico: " + texto + " para usuário: " + idUsuario);
            statement.setInt(1, idUsuario);
            statement.setString(2, texto);
            statement.executeUpdate();
        }
    }

    public ArrayList<String> ultimasBuscas(int idUsuario) throws SQLException {
        ArrayList<String> historico = new ArrayList<>();
        String sql = "SELECT textoBusca FROM tabelahistorico WHERE usuarioid = ? "
                + "ORDER BY id DESC LIMIT 10";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                System.out.println(resultado.getString("textoBusca"));
                historico.add(resultado.getString("textoBusca"));
            }
        }

        return historico;
    }

    public ArrayList<Musica> buscarCurtidas() throws SQLException {
        ArrayList<Musica> lista = new ArrayList<>();

        String sql = "SELECT m.* FROM tabelacurtidas c JOIN tabelamusicas m ON c.musicaid = m.idmusica WHERE c.usuarioid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Musica m = new Musica();
                m.setMusicaTitulo(rs.getString("musicatitulo"));
                m.setMusicaGenero(rs.getString("musicagenero"));
                m.setNomeArtista(rs.getString("nomeartista"));
                lista.add(m);
            }
        }

        return lista;
    }

    public ArrayList<Musica> buscarDescurtidas() throws SQLException {
        ArrayList<Musica> lista = new ArrayList<>();

        String sql = "SELECT m.* FROM tabeladescurtidas d JOIN tabelamusicas m ON d.musicaid = m.idmusica WHERE d.usuarioid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Musica m = new Musica();
                m.setMusicaTitulo(rs.getString("musicatitulo"));
                m.setMusicaGenero(rs.getString("musicagenero"));
                m.setNomeArtista(rs.getString("nomeartista"));
                lista.add(m);
            }
        }

        return lista;
    }

    public void curtirMusicas(int idMusica, int idUsuario) throws SQLException {

        //P caso o usuário curta uma musica que está descurtida, tira a musica da tabela descurtida
        String sql = "DELETE FROM tabeladescurtidas WHERE usuarioid = ? AND musicaid = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idMusica);
            statement.executeUpdate();
        }

        // pra curtir
        String curtida = "INSERT INTO tabelacurtidas (usuarioid, musicaid) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (PreparedStatement statement = conn.prepareStatement(curtida)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idMusica);
            statement.executeUpdate();
        }

    }

    public void descurtirMusicas(int idMusica, int idUsuario) throws SQLException {
        String sql = "DELETE FROM tabeladescurtidas WHERE usuarioid = ? AND musicaid = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idMusica);
            statement.executeUpdate();
        }

        // pra curtir
        String curtida = "INSERT INTO tabeladescurtidas (usuarioid, musicaid) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(curtida)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idMusica);
            statement.executeUpdate();
        }
    }
}
