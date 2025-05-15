/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lukinhas
 */
public class Musica{
    int idMusica;
    String musicaTitulo, musicaGenero, nomeArtista;

    public Musica(int idMusica, String musicaTitulo, String musicaGenero, String nomeArtista) {
        this.idMusica = idMusica;
        this.musicaTitulo = musicaTitulo;
        this.musicaGenero = musicaGenero;
        this.nomeArtista = nomeArtista;
    }
    
    public Musica() {
        
    }
    
    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public String getMusicaTitulo() {
        return musicaTitulo;
    }

    public void setMusicaTitulo(String musicaTitulo) {
        this.musicaTitulo = musicaTitulo;
    }

    public String getMusicaGenero() {
        return musicaGenero;
    }

    public void setMusicaGenero(String musicaGenero) {
        this.musicaGenero = musicaGenero;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeaArtista) {
        this.nomeArtista = nomeaArtista;
    }
    
    
}
