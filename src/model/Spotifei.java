/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;
import javax.swing.SwingUtilities;
import view.LoginGUI;
/**
 *
 * @author unifybarros
 */
public class Spotifei {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("Spotifei iniciado!");

            new LoginGUI(); // Inicia a tela de login
        });
    }
    
}
