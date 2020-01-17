package com.zingmp3.service.playlist;

import com.zingmp3.model.PlayList;
import com.zingmp3.repository.IPlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private IPlayListRepository playListRepository;
    @Override
    public Iterable<PlayList> findAll() {
        return playListRepository.findAll();
    }

    @Override
    public PlayList findById(long id) {
        return playListRepository.findById(id).get();
    }

    @Override
    public void save(PlayList playList) {
        playListRepository.save(playList);
    }

    @Override
    public void delete(long id) {
        playListRepository.deleteById(id);
    }

    @Override
    public List<PlayList> findByNamePlayList(String namePlaylist) {
        return playListRepository.findAllByPlaylistNameContaining(namePlaylist);

    }
}
