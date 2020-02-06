package com.zingmp3.service;

import com.zingmp3.model.LikeSong;
import com.zingmp3.model.Song;
import com.zingmp3.repository.LikeSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLikeSong implements IServiceLikeSong {

    @Autowired
    private LikeSongRepository likeSongRepository;

    @Override
    public List<LikeSong> findAll() {
        return likeSongRepository.findAll();
    }

    @Override
    public Iterable<LikeSong> findBySong(Song song) {
        return likeSongRepository.findBySong(song);
    }

    @Override
    public void save(LikeSong likeSong) {
        likeSongRepository.save(likeSong);
    }

    @Override
    public void delete(long id) {
        likeSongRepository.deleteById(id);
    }
}
