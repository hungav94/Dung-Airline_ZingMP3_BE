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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "play_list_songs",
            joinColumns = {@JoinColumn(name = "songs_id")},
            inverseJoinColumns = {@JoinColumn(name = "play_list_id")}
    )
    private List<Song> songs = new ArrayList<>();

    public PlayList() {
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

    public String getAvatarPlaylist() {
        return avatarPlaylist;
    }

    public void setAvatarPlaylist(String avatarPlaylist) {
        this.avatarPlaylist = avatarPlaylist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
