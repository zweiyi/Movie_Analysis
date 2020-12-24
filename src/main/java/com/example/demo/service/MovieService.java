package com.example.demo.service;

import com.example.demo.dao.MoviesRepository;
import com.example.demo.entity.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @date 2020/12/16-10:03
 */

@Service
public class MovieService {
    @Autowired
    MoviesRepository moviesRepository;

    public List<Movies> findAllMovies (){
        return moviesRepository.findAll();
    }


    public List<Movies> findMovieByName(String name) {
        return moviesRepository.findMovieByName(name);
    }


    //返回所有电影的genre
    public List<String> findAllGenres(){
        List<String> allGenres = new ArrayList<>();
        List<Movies> movies = moviesRepository.findAll();
        for (Movies eachmovie : movies){
            allGenres.add(eachmovie.getGenres());
        }
        return allGenres;
    }

    //返回所有电影的名称
    public List<String> findAllMoviesName() {
        List<String> allmovies = new ArrayList<>();
        List<Movies> movies = moviesRepository.findAll();
        for (Movies eachmovie : movies) {
            allmovies.add(eachmovie.getTitle());
        }
        return allmovies;
    }



    //查找每一类的电影
    public List<String> kindMovies(String genre) {
        List<Movies> allMovies = findAllMovies();
        List<String> movies = new ArrayList<>();
        for (Movies movies1 : allMovies) {
            if (movies1.getGenres().contains(genre)) {
               movies.add(movies1.getTitle());
            }
        }
        return movies;
    }


}














