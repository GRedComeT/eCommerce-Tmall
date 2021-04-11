package com.tmall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tmall.pojo.Product;
import com.tmall.pojo.Review;

public interface ReviewDAO extends JpaRepository<Review,Integer>{

    List<Review> findByProductOrderByIdDesc(Product product);//返回评价列表
    int countByProduct(Product product);//评价数量

}