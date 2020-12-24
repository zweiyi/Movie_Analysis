package com.example.demo;

import java.util.*;

/**
 * Aprior算法，发现电影类别之间的联系
 * @author shkstart
 * @date 2020/12/18-9:25
 */
public class Apriori {
    private final static double SUPPORT = 0.005; // 支持度阈值
    private final static double CONFIDENCE = 0.5; // 置信度阈值

    private final static String ITEM_SPLIT="\\|"; // 项之间的分隔符
    private final static String CON=" → "; // 项之间的分隔符

    private List<String> transList ; //所有交易

    public Apriori(List<String> transList) {
        this.transList = transList;
    }


    /**
     *
     * @return  交易的所有频繁项集
     */
    public Map<List<String>,Integer> getFC(){
        Map<List<String>,Integer> frequentCollectionMap = new HashMap<>();//所有的频繁集
        frequentCollectionMap.putAll(getItem1FC());//合并频繁1项集

        Map<List<String>,Integer> itemkFcMap = getItem1FC(),candidateCollection;
        while (itemkFcMap!=null && itemkFcMap.size()!=0){
            candidateCollection = getCandidateCollection(itemkFcMap);//获得候选集

            //对候选集项进行累加计数
            for (List<String> candidate : candidateCollection.keySet()){
                for (String trans : transList){
                    boolean flag = true;// 用来判断交易中是否出现该候选项，如果出现，计数加1
                    for (String candidateItem : candidate){
                        if (trans.indexOf(candidateItem)==-1){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        candidateCollection.put(candidate,candidateCollection.get(candidate)+1);
                    }
                }
            }

            itemkFcMap.clear();
            //从候选集中找到符合支持度的频繁集项
            for (List<String> candidate : candidateCollection.keySet()){
                Integer fc = candidateCollection.get(candidate);
                double fcdouble = (double)fc/(double) transList.size();
                if (fcdouble>=SUPPORT){
                    itemkFcMap.put(candidate,fc);
                }
            }

            //合并所有频繁集
            frequentCollectionMap.putAll(itemkFcMap);
        }
        return frequentCollectionMap;
    }

    /**
     * 关联规则
     * @param frequentCollectionMap 频繁集
     * @return 关联规则
     */
    public Map<String, Double> getRelationRules(Map<List<String>,Integer> frequentCollectionMap){
        Map<String,Double> relationRules=new HashMap<>();
        for (List<String> itmes : frequentCollectionMap.keySet()){
            if (itmes.size()>1){
                double countAll = frequentCollectionMap.get(itmes);
                List<List<String>> result = getSubsets(itmes);//获得itmes的所有非空子集

                for (List<String> itemList : result){
                    if (itemList.size() < itmes.size()){//只处理真子集

                        StringBuilder reasonStr = new StringBuilder();//前置
                        StringBuilder resultStr = new StringBuilder();//结果
                        for (String item : itemList) reasonStr.append(",").append(item);
                        for (String item : itmes) if (!itemList.contains(item)) resultStr.append(",").append(item);

                        double countReason = frequentCollectionMap.get(itemList);
                        double itemConfidence = countAll / countReason;//计算置信度

                        if (itemConfidence >= CONFIDENCE){
                            String rule = reasonStr.append(CON).append(resultStr.substring(1)).substring(1);
                            relationRules.put(rule,itemConfidence);
                        }
                    }
                }

            }
        }
        return relationRules;
    }


    /**
     *对于给定的频繁K项集，获得他的K+1项候选集
     * @param itemkFcMap 频繁K项集
     * @return  K+1项候选集
     */
    private Map<List<String>,Integer> getCandidateCollection(Map<List<String>,Integer> itemkFcMap){
        Map<List<String>,Integer> candidateCollection = new HashMap<>();
        Set<List<String>> itemkSet1 = itemkFcMap.keySet();
        Set<List<String>> itemkSet2 = itemkFcMap.keySet();

        //连接
        for (List<String> itemk1 : itemkSet1){
            for (List<String> itemk2 : itemkSet2){
                if (!itemk1.equals(itemk2)){
                    for (String item : itemk2){
                        if (itemk1.contains(item)) continue;
                        List<String> temp = new ArrayList<>(itemk1);
                        temp.add(item);
                        temp.sort(Comparator.naturalOrder());
                        candidateCollection.put(temp,0);
                    }
                }
            }
        }
        return candidateCollection;
    }

    /**
     * 获取频繁1项集
     * @return map<key,value> key-items value-frequency
     */
    private Map<List<String>,Integer> getItem1FC(){
        Map<List<String>,Integer> sItem1FCMap = new HashMap<>();//statistics frequency of each item
        Map<List<String>,Integer> rItem1FCMap = new HashMap<>();//频繁1项集

        for (String trans : transList){
            String[] transSplit = trans.split(ITEM_SPLIT);
            for(String item:transSplit){
                List<String> itemList = new ArrayList<>();
                itemList.add(item);
                sItem1FCMap.put(itemList, sItem1FCMap.getOrDefault(itemList, 0) +1);
            }
        }

        for (List itemList : sItem1FCMap.keySet()){
            Integer fc = sItem1FCMap.get(itemList);
            double fcc = (double)fc/(double)transList.size();
            if (fcc>=SUPPORT) rItem1FCMap.put(itemList,fc);
        }
        return rItem1FCMap;
    }

    /**
     * 构造子集
     * @param sourceSet
     * @return sourceSet的所有非空子集
     */
    private List<List<String>> getSubsets(List<String> sourceSet){
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0;i<sourceSet.size();i++){
            int size = result.size();
            for (int j = 0;j<size;j++){
                List<String> temp = new ArrayList<>(result.get(j));
                temp.add(sourceSet.get(i));
                result.add(temp);
            }
        }
        return result.subList(1,result.size());//去掉空集
    }

}

