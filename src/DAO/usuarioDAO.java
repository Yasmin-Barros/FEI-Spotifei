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
    
    public void cadastrar(Usuario usuario) throws SQLException {
    String sql = "INSERT INTO \"tabelaUsuarios\"(idUsuario,nome, usuario, senha) VALUES (?, ?, ?)";
    
    try (PreparedStatement statement = conn.prepareStatement(sql)) {
        // Definindo os parâmetros
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getUser());
        statement.setString(4, usuario.getSenha());
        
        // Executando a inserção
        statement.executeUpdate();  // Usamos executeUpdate para inserções
        
        // Confirmando a transação
        conn.commit(); // Confirmando a transação no banco de dados
    } catch (SQLException e) {
        e.printStackTrace();
        // Caso aconteça algum erro, faz rollback da transação
        conn.rollback();
    }
}

    
    public boolean consultar(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM tabelaUsuarios WHERE usuario = ? AND senha = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsuario());
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
