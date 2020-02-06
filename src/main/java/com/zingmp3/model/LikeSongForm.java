package com.zingmp3.model;

import lombok.Data;

@Data
public class LikeSongForm {
    private Song song;
    private User user;
}
