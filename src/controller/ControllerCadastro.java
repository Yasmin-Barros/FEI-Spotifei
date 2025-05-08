/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import view.CadastroGUI;
import javax.swing.*;
import view.LoginGUI;

public class ControllerCadastro {
    private CadastroGUI view;

    public ControllerCadastro(CadastroGUI view) {
        this.view = view;
    }
    
    public void salvarUsuario() {
        String nome = view.getCaixaNome().getText();
        String user = view.getCaixaUsuario().getText();
        String senha = view.getCaixaSenha().getText();

        // Verifica se os campos não estão vazios
        if (nome.isEmpty() || user.isEmpty() || senha.isEmpty()) {
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
            dao.cadastrar(usuario);

            // Se chegar aqui, o cadastro foi bem-sucedido
            connection.commit();  // Confirma a transação
            JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso", 
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            new LoginGUI().setVisible(true);

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
            JOptionPane.showMessageDialog(view, "Falha no cadastro", 
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
