package com.zingmp3.repository;

import com.zingmp3.model.PlayList;
import com.zingmp3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlayListRepository extends JpaRepository<PlayList, Long> {

    List<PlayList> findAllByPlaylistNameContaining(String namePlaylist);

}
