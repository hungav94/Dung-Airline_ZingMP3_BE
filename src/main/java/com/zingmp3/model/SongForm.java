package com.zingmp3.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class SongForm {
    private String name;
    private String description;
    private String dateUpload;
    private int listenSong;

    public SongForm() {
    }

    public SongForm( String name, String description, String dateUpload) {
        this.name = name;
        this.description = description;
        this.dateUpload = dateUpload;
    }

    public int getListenSong() {
        return listenSong;
    }

    public void setListenSong(int listenSong) {
        this.listenSong = listenSong;
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

    public String getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(String dateUpload) {
        this.dateUpload = dateUpload;
    }
}
