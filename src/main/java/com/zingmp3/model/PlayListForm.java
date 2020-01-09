package com.zingmp3.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayListForm {
    private long id;
    private String playlistName;
    private String playlistDescription;
    private List<Song> songs = new ArrayList<>();

    public PlayListForm() {
    }

    public PlayListForm(long id, String playlistName, String playlistDescription, List<Song> songs) {
        this.id = id;
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
        this.songs = songs;
    }
}
