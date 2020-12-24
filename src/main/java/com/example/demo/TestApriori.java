package com.example.demo;

import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @date 2020/12/18-9:53
 */
public class TestApriori {

    public static void main(String[] args) {
        Apriori apriori = new Apriori(Arrays.asList("A、C、D","B、C、E","A、B、C、E","B、E"));
        Map<List<String>, Integer> frequentCollectionMap = apriori.getFC();
        System.out.println("---------------------频繁项集"+"-------------------------");

        for (List<String> list: frequentCollectionMap.keySet()) {
            System.out.println(list+"\t"+frequentCollectionMap.get(list));
        }

        Map<String, Double> relationRulesMap = apriori.getRelationRules(frequentCollectionMap);
        System.out.println("-------关联规则"+"---------");
        for (String s: relationRulesMap.keySet()) {
            System.out.println(s+"\t"+relationRulesMap.get(s));
        }
    }
}
