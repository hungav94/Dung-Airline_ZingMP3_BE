package com.zingmp3.service;

import com.zingmp3.model.Song;

import java.util.List;

public interface IServiceSong {
    Iterable<Song> findAll();

    Song findById(long id);

    void save(Song song);

    void saveList(List<Song> songs);

    void delete(long id);

    List<Song> findByName(String nameSong);

    List<Song> findAllById(Iterable<Long> ids);

    List<Song> findAllByOrderByIdDesc();

    List<Song> findAllByOrderByDateUpLoadSongs();

    List<Song> findAllByOrderByListenSongDesc();

    List<Song> findAllByOrderByLikeSongDesc();
}
