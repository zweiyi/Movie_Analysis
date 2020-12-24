package com.example.demo.entity;

import javax.persistence.*;

/**
 * @author shkstart
 * @date 2020/12/16-10:27
 */

@Entity
@Table(name = "tags")
public class Tags {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "movieid")
    private int movieId;

    @Column(name = "tag")
    private String tag;

    @Column(name = "timestamp")
    private int timestamp;

    public Tags() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
