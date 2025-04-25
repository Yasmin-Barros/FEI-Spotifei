/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifybarros
 */
public class Usuario extends Pessoa implements IAutenticacao{
    String nome, usuario, senha;
    String sexo;

    public Usuario(String nome, String sobrenome, int idade, String cpf, String sexo) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
}
