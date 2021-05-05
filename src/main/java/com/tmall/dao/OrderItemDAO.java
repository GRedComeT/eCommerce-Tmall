package com.tmall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
import com.tmall.pojo.Product;
import com.tmall.pojo.User;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);//得到产品的订单
}