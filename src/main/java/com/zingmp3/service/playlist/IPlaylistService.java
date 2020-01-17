package com.zingmp3.service.playlist;

import com.zingmp3.model.PlayList;
import com.zingmp3.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPlaylistService {
    Iterable<PlayList> findAll();

    PlayList findById(long id);

    void save(PlayList playList);

    void delete(long id);

    List<PlayList> findByNamePlayList(String namePlaylist);
}
