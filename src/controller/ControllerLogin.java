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

public class ControllerLogin {
    private LoginGUI view;

    public ControllerLogin(LoginGUI view) {
        this.view = view;
    }
    
    public void procurarUsuario() {
        String nome = view.getCaixaUsuarioLogin().getText();
        String user = view.getCaixaUsuarioLogin().getText();
        String senha = view.getCaixaSenhaLogin().getText();
        // Verifica se os campos não estão vazios
        if (senha.isEmpty() || user.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos.",
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario(nome, user, senha);

        // Estabelecendo a conexão com o banco
        Conexao conn = new Conexao();
        try (Connection connection = conn.getConnection()) {
            // Inicia a transação manualmente, se necessário
            connection.setAutoCommit(false);

            UsuarioDAO dao = new UsuarioDAO(connection);

            // Tenta cadastrar o usuário
            dao.consultar(usuario);

            // Se chegar aqui, o cadastro foi bem-sucedido
            connection.commit();  // Confirma a transação
            JOptionPane.showMessageDialog(view, "Usuário Logado com sucesso", 
                    "Login", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                // Caso ocorra um erro, faz rollback da transação
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(view, "Falha no rollback", 
                        "Erro!", JOptionPane.ERROR_MESSAGE);
                rollbackEx.printStackTrace();
            }

            // Exibe a mensagem de erro
            JOptionPane.showMessageDialog(view, "Falha no Login", 
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

}
