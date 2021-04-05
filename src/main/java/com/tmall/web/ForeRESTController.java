package com.tmall.web;

import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;
//import com.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeRESTController {
    @Autowired
    CategoryService categoryService;
    //@Autowired
    //ProductService productService;

    @GetMapping("/forehome")
    public Object home() {
        List<Category> cs= categoryService.list();
        //productService.fill(cs);
        //productService.fillByRow(cs);
        //categoryService.removeCategoryFromProduct(cs);
        return cs;
    }

}