/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginGUI;
import view.PaginaInicialGUI;

public class ControllerLogin {
    private LoginGUI view;

    public ControllerLogin(LoginGUI view) {
        this.view = view;
    }
    
    public void procurarUsuario() {
        String nome = view.getCaixaUsuarioLogin().getText();
        String user = view.getCaixaUsuarioLogin().getText();
        String senha = view.getCaixaSenhaLogin().getText();
        if (senha.isEmpty() || user.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos.",
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario(nome, user, senha);

        Conexao conn = new Conexao();
        try (Connection connection = conn.getConnection()) {
            connection.setAutoCommit(false);

            UsuarioDAO dao = new UsuarioDAO(connection);

            dao.consultar(usuario);

            connection.commit();
            JOptionPane.showMessageDialog(view, "Usuário Logado com sucesso", 
                    "Login", JOptionPane.INFORMATION_MESSAGE);
            new PaginaInicialGUI().setVisible(true);

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(view, "Falha no rollback", 
                        "Erro!", JOptionPane.ERROR_MESSAGE);
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(view, "Falha no Login", 
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

}
