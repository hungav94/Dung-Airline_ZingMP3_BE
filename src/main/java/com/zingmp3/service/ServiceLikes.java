package com.zingmp3.service;

import com.zingmp3.model.Likes;
import com.zingmp3.model.Song;
import com.zingmp3.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLikes implements IServiceLikes {

    @Autowired
    private LikesRepository likesRepository;

    @Override
    public List<Likes> findAll() {
        return likesRepository.findAll();
    }

    @Override
    public Iterable<Likes> findBySong(Song song) {
        return likesRepository.findBySong(song);
    }

    @Override
    public void save(Likes likes) {
        likesRepository.save(likes);
    }

    @Override
    public void delete(long id) {
        likesRepository.deleteById(id);
    }
}
