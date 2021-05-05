package com.tmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tmall.dao.ReviewDAO;
import com.tmall.pojo.Product;
import com.tmall.pojo.Review;

@Service
public class ReviewService {

    @Autowired ReviewDAO reviewDAO;
    @Autowired ProductService productService;

    public void add(Review review) {//存一个评论
        reviewDAO.save(review);
    }

    public List<Review> list(Product product){//得到评论列表
        List<Review> result =  reviewDAO.findByProductOrderByIdDesc(product);
        return result;
    }

    public int getCount(Product product) {//得到评论数量
        return reviewDAO.countByProduct(product);
    }

}