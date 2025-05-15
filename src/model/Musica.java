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
    String musicaTitulo, musicaGenero, musicaArtista;

    public Musica(int idMusica, String musicaNome, String musicaGenero, String musicaArtista) {
        this.idMusica = idMusica;
        this.musicaTitulo = musicaTitulo;
        this.musicaGenero = musicaGenero;
        this.musicaArtista = musicaArtista;
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

    public void setMusicaTitulo(String musicaNome) {
        this.musicaTitulo = musicaTitulo;
    }

    public String getMusicaGenero() {
        return musicaGenero;
    }

    public void setMusicaGenero(String musicaGenero) {
        this.musicaGenero = musicaGenero;
    }

    public String getMusicaArtista() {
        return musicaArtista;
    }

    public void setMusicaArtista(String musicaArtista) {
        this.musicaArtista = musicaArtista;
    }
    
    
}
