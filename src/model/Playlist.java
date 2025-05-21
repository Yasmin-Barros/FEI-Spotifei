/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lukinhas
 */
public class Playlist {
    private int idPlaylist;
    private String playlistTitulo;

    public Playlist(int idPlaylist, String playlistTitulo) {
        this.idPlaylist = idPlaylist;
        this.playlistTitulo = playlistTitulo;
    }

    public Playlist() {
    }

    
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getPlaylistTitulo() {
        return playlistTitulo;
    }

    public void setPlaylistTitulo(String playlistTitulo) {
        this.playlistTitulo = playlistTitulo;
    }
    
}
