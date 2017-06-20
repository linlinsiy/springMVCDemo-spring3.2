package com.gaussic.controller;

import com.gaussic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lsy on 2017/6/20.
 */
@Controller
public class UserController {

    @Autowired
    ProductRepository productRepository;


    @RequestMapping(value = "/user/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
