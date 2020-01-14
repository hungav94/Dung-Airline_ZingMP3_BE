package com.zingmp3.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PlayListForm {
    private long id;
    private String playlistName;
    private String playlistDescription;
    private Iterable<Long> songs = new ArrayList<>();

    public PlayListForm() {
    }

    public PlayListForm(long id, String playlistName, String playlistDescription, Iterable<Long> songs) {
        this.id = id;
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
        this.songs = songs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public void setPlaylistDescription(String playlistDescription) {
        this.playlistDescription = playlistDescription;
    }

    public Iterable<Long> getSongs() {
        return songs;
    }

    public void setSongs(Iterable<Long> songs) {
        this.songs = songs;
    }
}
