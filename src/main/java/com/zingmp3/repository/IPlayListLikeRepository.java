package com.zingmp3.repository;

import com.zingmp3.model.PlayList;
import com.zingmp3.model.PlayListLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlayListLikeRepository extends JpaRepository<PlayListLike, Long> {
    List<PlayListLike> findByPlayList(PlayList playList);
}
