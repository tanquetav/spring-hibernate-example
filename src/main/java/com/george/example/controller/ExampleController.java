package com.george.example.controller;

import com.george.example.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 9/10/17.
 */
@RestController
public class ExampleController {

    @Autowired
    PartService partService;

    @RequestMapping(value = "/sample1",method = RequestMethod.GET)
    public Object sample1() {
        Map map = new HashMap<String,Object>();
        map.put("result","ok");
        return map;
    }
    @RequestMapping(value = "/sample2",method = RequestMethod.GET)
    public Object sample2() {
        return partService.sample2();
    }
    @RequestMapping(value = "/sample3",method = RequestMethod.GET)
    public Object sample3() {
        return partService.sample3();
    }
    @RequestMapping(value = "/sample4",method = RequestMethod.GET)
    public Object sample4() {
        return partService.sample4();
    }
}
