package com.zingmp3.service;

import com.zingmp3.model.Song;

public interface IServiceSong {
    Iterable<Song> findAll();

    Iterable<Song> findAllByNameContaining(String name);

    Song findById(long id);

    void save(Song song);

    void delete(long id);
}
