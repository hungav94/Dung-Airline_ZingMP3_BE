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
}
