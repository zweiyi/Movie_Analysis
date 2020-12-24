package com.example.demo.entity;

import javax.persistence.*;

/**
 * @author shkstart
 * @date 2020/12/16-10:24
 */
@Entity
@Table(name = "movies")
public class Movies {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer movieID;    //电影ID；

    @Column(name = "title")
    private String title;   //电影名称

    @Column(name = "genres")
    private String genres;

    public Movies() {
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
