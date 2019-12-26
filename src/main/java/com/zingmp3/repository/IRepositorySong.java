package com.zingmp3.repository;

import com.zingmp3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorySong extends CrudRepository<Song, Long> {
}
