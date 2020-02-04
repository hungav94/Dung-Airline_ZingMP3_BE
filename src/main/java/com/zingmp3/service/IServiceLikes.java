package com.zingmp3.service;

import com.zingmp3.model.Likes;
import com.zingmp3.model.Song;

import java.util.List;

public interface IServiceLikes {

    List<Likes> findAll();

    Iterable<Likes> findBySong(Song song);

    void save(Likes likes);

    void delete(long id);
}
