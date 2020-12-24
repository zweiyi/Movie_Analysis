package com.example.demo.entity;

/**
 * @author shkstart
 * @date 2020/12/22-11:05
 */
public class MovieMsg {
    private String title;
    private Double rank;

    public MovieMsg(String title, Double rank) {
        this.title = title;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
