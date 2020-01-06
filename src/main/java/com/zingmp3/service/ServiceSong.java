package com.zingmp3.service;

import com.zingmp3.model.Song;
import com.zingmp3.repository.IRepositorySong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSong implements IServiceSong {
    @Autowired
    private IRepositorySong repositorySong;

    @Override
    public Iterable<Song> findAll() {
        return repositorySong.findAll();
    }

    @Override
    public Iterable<Song> findAllByNameContaining(String name) {
        return repositorySong.findAllByNameContaining(name);
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
    public void delete(long id) {
        repositorySong.deleteById(id);
    }
}
