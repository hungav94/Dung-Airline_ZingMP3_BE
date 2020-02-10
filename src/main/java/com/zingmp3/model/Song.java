package com.zingmp3.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String avatar;
    @Column(nullable = false)
    private String fileMp3;
    private String dateUpLoad;

    private int listenSong;

    private int likeSong;

    private String username;

    public Song() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFileMp3() {
        return fileMp3;
    }

    public void setFileMp3(String fileMp3) {
        this.fileMp3 = fileMp3;
    }

    public String getDateUpLoad() {
        return dateUpLoad;
    }

    public void setDateUpLoad(String dateUpLoad) {
        this.dateUpLoad = dateUpLoad;
    }

    public int getListenSong() {
        return listenSong;
    }

    public void setListenSong(int listenSong) {
        this.listenSong = listenSong;
    }

    public int getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(int likeSong) {
        this.likeSong = likeSong;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
