package com.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.tmall.pojo.*;
import com.tmall.service.*;
import com.tmall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import  java.util.HashMap;
@Controller
public class ForePageController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;

    @GetMapping(value = "/")
    public String index() {
        return "redirect:home";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "fore/home";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "fore/register";
    }

    @GetMapping(value = "/registerSuccess")
    public String registerSuccess() {
        return "fore/registerSuccess";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "fore/login";
    }

    @GetMapping("/forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:home";//url ***/home
    }

    @GetMapping("/foreproduct/{pid}")
    public Object product(@PathVariable("pid") int pid) {
        Product product = productService.get(pid);
        //图片在这里才设置在product里，然后通过product发送给浏览器
        List<ProductImage> productSingleImages = productImageService.listSingleProductImages(product);
        List<ProductImage> productDetailImages = productImageService.listDetailProductImages(product);
        product.setProductSingleImages(productSingleImages);
        product.setProductDetailImages(productDetailImages);

        List<PropertyValue> pvs = propertyValueService.list(product);
        List<Review> reviews = reviewService.list(product);
        productService.setSaleAndReviewNumber(product);
        productImageService.setFirstProductImage(product);

        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("pvs", pvs);
        map.put("reviews", reviews);

        return Result.success(map);
    }
}