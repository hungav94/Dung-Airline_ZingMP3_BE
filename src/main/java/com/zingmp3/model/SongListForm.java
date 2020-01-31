package com.zingmp3.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SongListForm {
    private Iterable<Long> songs = new ArrayList<>();

    public SongListForm() {
    }

    public SongListForm(Iterable<Long> songs) {
        this.songs = songs;
    }
}
