package com.example.demo.dao;


import com.example.demo.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @date 2020/12/16-9:57
 */

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Integer> {

    //返回每个电影的平均评级
    @Query(name = "movieAvgRating",nativeQuery = true, value = "select title, avg(rating) from ratings, movies where movies.movieId = ratings.movieId group by ratings.movieId")
    public List<Map<String,Object>> movieAvgRating();

    @Query(name = "findByUserIdAndMovieId", nativeQuery = true, value = "select * from ratings where userId = :integer1 and movieId = :integer2 ")
    public List<Ratings> findByUserIdAndMovieId(@Param("integer1") Integer integer1, @Param("integer2") Integer integer2);

    @Query(name = "updateRating", nativeQuery = true, value = "update ratings set rating =:newrating where id=:integer ")
    public void updateRating(@Param("integer") Integer integer, @Param("newrating") Double newrating);
}
