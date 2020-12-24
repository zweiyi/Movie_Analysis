package com.example.demo.service;

import com.example.demo.dao.RatingsRepository;
import com.example.demo.entity.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @date 2020/12/16-10:45
 */

@Service
public class RatingsService {
    @Autowired
    RatingsRepository ratingsRepository;

    public List<Ratings> finAllRratings() {
        return ratingsRepository.findAll();
    }

    public List<Map<String, Object>> movieAvgRating() {
        return ratingsRepository.movieAvgRating();
    }

    public void insertUserRating(Ratings ratings){
        ratingsRepository.save(ratings);
    }

    public List<Ratings> findByUserIdAndMovieId(Integer userId, Integer movieId) {
        return ratingsRepository.findByUserIdAndMovieId(userId, movieId);
    }

    public void updateRating(Integer integer,  Double newrating){
        ratingsRepository.updateRating(integer, newrating);
    }

}
