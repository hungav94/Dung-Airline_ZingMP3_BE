package com.zingmp3.service;

import com.zingmp3.model.Song;
import com.zingmp3.repository.IRepositorySong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSong implements IServiceSong {
    @Autowired
    private IRepositorySong repositorySong;

    @Override
    public Iterable<Song> findAll() {
        return repositorySong.findAll();
    }

    @Override
    public Song findById(long id) {
        return repositorySong.findById(id).get();
    }

    @Override
    public void save(Song song) {
        repositorySong.save(song);
    }

    @Override
    public void saveList(List<Song> songs) {
        repositorySong.saveAll(songs);
    }

    @Override
    public void delete(long id) {
        repositorySong.deleteById(id);
    }

    @Override
    public List<Song> findByName(String nameSong) {
        return repositorySong.findAllByNameContaining(nameSong);
    }

    @Override
    public List<Song> findAllById(Iterable<Long> ids) {
        return repositorySong.findAllById(ids);
    }

    @Override
    public List<Song> findAllByOrderByIdDesc() {
        return repositorySong.findAllByOrderByIdDesc();
    }


    @Override
    public List<Song> findAllByOrderByDateUpLoadSongs() {
        return repositorySong.findAllByOrderByDateUpLoadDesc();
    }

    @Override
    public List<Song> findAllByOrderByListenSongDesc() {
        return repositorySong.findAllByOrderByListenSongDesc();
    }

    @Override
    public List<Song> findAllByOrderByLikeSongDesc() {
        return repositorySong.findAllByOrderByLikeSongDesc();
    }


}
