package com.zingmp3.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class SongForm {
    private long id;
    private String name;
    private String description;
    private String dateUpLoad;

    public SongForm() {
    }

    public SongForm(long id, String name, String description, String dateUpLoad) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateUpLoad = dateUpLoad;
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

    public String getDateUpLoad() {
        return dateUpLoad;
    }

    public void setDateUpLoad(String dateUpLoad) {
        this.dateUpLoad = dateUpLoad;
    }
}
