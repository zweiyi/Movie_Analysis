package com.example.demo.controller;

import com.example.demo.Apriori;
import com.example.demo.entity.*;
import com.example.demo.service.MovieService;
import com.example.demo.service.RatingsService;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author shkstart
 * @date 2020/12/14-11:21
 */

//@RestController
@Controller
//@RequestMapping

public class HelloController {

    @Autowired
    MovieService movieService;

    @Autowired
    RatingsService ratingsService;

    @Autowired
    TagService tagService;


    @RequestMapping("/hello")
    public String hello(Model model){
        List<Movies> movies = movieService.findAllMovies();
        model.addAttribute("movies", movies);
        List<Map<String, Object>> movieRating = ratingsService.movieAvgRating();
        return "hello";

    }

    @PostMapping("/kindMovie")
    public String getMoviesFromGenre(@RequestParam("genre") String genre,Map<String,Object> map) {
            List<String> kindMovies = movieService.kindMovies(genre);
            map.put("kindMovies",kindMovies);
            System.out.println(genre);
            return "kindMovie";
    }

    @PostMapping("/insertUser")
    public String insertUserMovies(@RequestParam("userid") Integer userid,
                                   @RequestParam("movieid") Integer movieid,
                                   @RequestParam("tag") String tag,
                                   @RequestParam("rating") Double rating
                                   ){
        Ratings ratings = new Ratings();
        Tags tags = new Tags();
        tags.setMovieId(movieid);
        tags.setUserId(userid);
        tags.setTag(tag);
        ratings.setMovieId(movieid);
        ratings.setUserId(userid);
        ratings.setRating(rating);
        System.out.println(userid+movieid+rating);
        ratingsService.insertUserRating(ratings);
        tagService.insertUserTag(tags);
        return "insertUser";
    }

    @RequestMapping("/useRank")
    public String useRank(Model model) {
        List<Map<String, Object>> movieRank = ratingsService.movieAvgRating();
        model.addAttribute(movieRank);
        List<MovieMsg> movieMsgList = new ArrayList<MovieMsg>();

        for (int i = 0; i < movieRank.size(); i++) {
            Set<Map.Entry<String, Object>> entrySet=movieRank.get(i).entrySet();
            String title = new String("abc");
            Double avg = new Double(0.0);
            for (Map.Entry<String,Object> entry:entrySet){

                if (entry.getKey().equals("title")) {
                    title = (String) entry.getValue();
                }
                if (entry.getKey().equals("avg(rating)")) {
                    avg = (Double) entry.getValue();
                }
            }
            movieMsgList.add(new MovieMsg(title, avg));
        }
        model.addAttribute(movieMsgList);
        List<Ratings> ratingsList = ratingsService.finAllRratings();

        List<Tags> tagsList = tagService.finAllTags();

//        for (Tags tags : tagsList) {
//            System.out.println(tags.getMovieId());
//        }
        model.addAttribute(tagsList);
        model.addAttribute(ratingsList);
        return "useRank";
    }

    @RequestMapping("/updateht")
    public String updateht() {
        return "updateht";
    }

    @PostMapping("/update")
    public String updateUserRat(@RequestParam("userid") Integer userid,
                                @RequestParam("movieid") Integer movieid,
                                @RequestParam("ratingvalue") Double ratingvalue,
                                Model model) {
        List<Ratings> ratings = ratingsService.findByUserIdAndMovieId(userid, movieid);
//        System.out.println(ratings.size()+"ddddd"+ratings.get(0).getMovieId());
        Ratings ratings1 = ratings.get(0);
        Ratings ratingsnew = new Ratings();
        ratingsnew.setRating(ratingvalue);
        ratingsnew.setUserId(userid);
        ratingsnew.setMovieId(movieid);
        ratingsnew.setId(ratings1.getId());

        System.out.println("--------"+ratings1.getId()+"-----"+ratingsnew.getId());
        ratingsService.insertUserRating(ratingsnew);
//        ratingsService.updateRating(ratings1.getId(), ratingvalue);
        return "update";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

    @PostMapping("/deletetag")
    public String deleteTag(@RequestParam("id")Integer id){
        Optional<Tags> optionalTags = tagService.finTags(id);
        Tags tags = optionalTags.get();
        tagService.delete(tags);
        return "delete";
    }

    @RequestMapping("/analysis")
    public String analysis(Model model) {
        List<String> allGenres = movieService.findAllGenres();
        Apriori apriori = new Apriori(allGenres);
        Map<List<String>, Integer> frequentCollectionMap = apriori.getFC();
        Map<String, Double> relationRulesMap = apriori.getRelationRules(frequentCollectionMap);
        model.addAttribute("frequentMap",frequentCollectionMap);
        model.addAttribute("relationMap", relationRulesMap);
        System.out.println("---------------------频繁项集"+"-------------------------");

        for (List<String> list: frequentCollectionMap.keySet()) {
            System.out.println(list+"\t"+frequentCollectionMap.get(list));
        }
        System.out.println("-------关联规则"+"---------");
        for (String s: relationRulesMap.keySet()) {
            System.out.println(s+"\t"+relationRulesMap.get(s));
        }
        return "analysis";
    }



}
