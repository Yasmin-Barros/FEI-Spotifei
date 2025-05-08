/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author unifybarros
 */
public class Conexao {
    private Connection conexao;

    public Connection getConnection() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/spotifeiDB", "postgres", "fei"
                //"jdbc:postgresql://localhost:5432/postgres", "postgres", "fei"
            );
        }
        return conexao;
    }

    public void rollback() throws SQLException {
        if (conexao != null && !conexao.getAutoCommit()) {
            conexao.rollback();
        }
    }
}
