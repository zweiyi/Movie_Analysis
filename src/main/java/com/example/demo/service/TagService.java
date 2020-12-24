package com.example.demo.service;

import com.example.demo.dao.TagsRepository;
import com.example.demo.entity.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author shkstart
 * @date 2020/12/16-11:07
 */
@Service
public class TagService {
    @Autowired
    TagsRepository tagsRepository;

    public List<Tags> finAllTags() {
        return tagsRepository.findAll();
    }

    public void insertUserTag(Tags tags) {
        tagsRepository.save(tags);
    }

    public void delete(Tags tags) {
        tagsRepository.delete(tags);
    }

    public Optional<Tags> finTags(Integer id){
        return tagsRepository.findById(id);
    }

}
