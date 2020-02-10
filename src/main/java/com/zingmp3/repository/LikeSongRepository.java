package com.zingmp3.repository;

import com.zingmp3.model.LikeSong;
import com.zingmp3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikeSongRepository extends JpaRepository<LikeSong, Long> {
    List<LikeSong> findBySong(Song song);
}
