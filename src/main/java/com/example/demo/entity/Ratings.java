package com.example.demo.entity;

import javax.persistence.*;

/**
 * @author shkstart
 * @date 2020/12/16-10:25
 */

@Entity
@Table(name = "ratings")
public class Ratings {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "movieid")
    private Integer movieId;

    @Column(name = "rating")     //评级，1，1.5 2，2.5，到5
    private double rating;

    @Column(name = "timestamp")   //时间戳
    private String timestamp;

    public Ratings() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
