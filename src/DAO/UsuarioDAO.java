/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Usuario;
/**
 *
 * @author unifybarros
 */

public class UsuarioDAO {
    private Connection conn;
    
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
   
    public int buscarIdUsuario(Usuario usuario) throws SQLException {
        String sql = "SELECT id FROM tabelausuarios WHERE usuario = ? AND senha = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getUser());
            statement.setString(2, usuario.getSenha());
            
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                return resultado.getInt("id");
            } else {
                throw new SQLException("Usuário não encontrado.");
            }
        }
    }

    
    public void cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO tabelausuarios(nome, usuario, senha) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getUser());
            statement.setString(3, usuario.getSenha());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public boolean consultar(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM tabelausuarios WHERE usuario = ? AND senha = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getUser());
            statement.setString(2, usuario.getSenha());
            ResultSet resultado = statement.executeQuery(); // Use executeQuery para SELECT
            if (resultado.next()) {
                // Se encontrar resultados, pode retornar verdadeiro ou um objeto de usuário
                return true;  // Ou você pode retornar um objeto 'usuario' caso precise.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Retorna falso caso não encontre
    }
}
