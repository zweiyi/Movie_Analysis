package com.example.demo.dao;

import com.example.demo.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shkstart
 * @date 2020/12/16-9:17
 */

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    @Query(name = "findMovieByName", nativeQuery = true, value = "select * from movies where title = :name ")
    List<Movies> findMovieByName(@Param("name") String name);

}
