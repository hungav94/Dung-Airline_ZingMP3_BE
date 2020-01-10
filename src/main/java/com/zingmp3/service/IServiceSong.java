package com.zingmp3.service;

import com.zingmp3.model.Song;

import java.util.List;

public interface IServiceSong {
    Iterable<Song> findAll();

    Song findById(long id);

    void save(Song song);

    void delete(long id);

    List<Song> findByName(String nameSong);

    List<Song> findAllById(Iterable<Long> ids);
}
