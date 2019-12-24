package com.zingmp3.repository;

import com.zingmp3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorySong extends JpaRepository<Song, Long> {
}
