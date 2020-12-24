package com.example.demo.dao;

import com.example.demo.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author shkstart
 * @date 2020/12/16-9:59
 */
@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {
}