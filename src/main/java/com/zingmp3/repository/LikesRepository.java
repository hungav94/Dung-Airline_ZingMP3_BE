package com.zingmp3.repository;

import com.zingmp3.model.Likes;
import com.zingmp3.model.Song;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findBySong(Song song);
}
