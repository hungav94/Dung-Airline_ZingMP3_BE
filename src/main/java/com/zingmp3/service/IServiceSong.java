package com.zingmp3.service;

import com.zingmp3.model.Song;

public interface IServiceSong {
    Iterable<Song> findAll();

    void save(Song song);

    void delete(long id);
}
