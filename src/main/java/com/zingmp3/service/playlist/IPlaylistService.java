package com.zingmp3.service.playlist;

import com.zingmp3.model.PlayList;

public interface IPlaylistService {
    Iterable<PlayList> findAll();

    PlayList findById(long id);

    void save(PlayList playList);

    void delete(long id);
}
