package com.zingmp3.repository;

import com.zingmp3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorySong extends JpaRepository<Song, Long> {
    List<Song> findAllByNameContaining(String nameSong);

    List<Song> findAllById(Iterable<Long> ids);

    List<Song> findAllByOrderByDateUpLoadDesc();

    List<Song> findAllByOrderByListenSongDesc();

    List<Song> findAllByOrderByIdDesc();

}
