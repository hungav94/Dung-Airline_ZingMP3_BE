package com.zingmp3.service.playlist;

import com.zingmp3.model.PlayList;
import com.zingmp3.model.PlayListLike;

import java.util.List;

public interface IPlayListLikeService {
    List<PlayListLike> findAll();

    Iterable<PlayListLike> findByPlayList(PlayList playList);

    void save(PlayListLike playListLike);

    void delete(long id);
}
