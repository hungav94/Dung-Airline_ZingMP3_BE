package com.zingmp3.service;

import com.zingmp3.model.LikeSong;
import com.zingmp3.model.Song;

import java.util.List;

public interface IServiceLikeSong {

    List<LikeSong> findAll();

    Iterable<LikeSong> findBySong(Song song);

    void save(LikeSong likeSong);

    void delete(long id);
}
