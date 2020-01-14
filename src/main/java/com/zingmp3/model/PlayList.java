package com.zingmp3.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String playlistName;

    @NotEmpty
    @Size(min = 6, max = 100)
    private String playlistDescription;

    @NotEmpty
    private String avatarPlaylist;

    @ManyToMany
    private List<Song> songs = new ArrayList<>();

    public PlayList() {
    }
}
