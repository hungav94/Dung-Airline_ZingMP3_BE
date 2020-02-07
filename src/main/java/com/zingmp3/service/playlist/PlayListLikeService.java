package com.zingmp3.service.playlist;

import com.zingmp3.model.PlayList;
import com.zingmp3.model.PlayListLike;
import com.zingmp3.repository.IPlayListLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayListLikeService implements IPlayListLikeService{
    @Autowired
    private IPlayListLikeRepository playListLikeRepository;

    @Override
    public List<PlayListLike> findAll() {
        return playListLikeRepository.findAll();
    }

    @Override
    public Iterable<PlayListLike> findByPlayList(PlayList playList) {
        return playListLikeRepository.findByPlayList(playList);
    }

    @Override
    public void save(PlayListLike playListLike) {
        playListLikeRepository.save(playListLike);
    }

    @Override
    public void delete(long id) {
        playListLikeRepository.deleteById(id);
    }
}
