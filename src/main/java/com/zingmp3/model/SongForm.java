package com.zingmp3.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
@Data
public class SongForm {
    private long id;
    private String name;
    private String description;
    private String avatar;
    private String fileMp3;
    private String dateUpLoad;
}
