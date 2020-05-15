package com.luoyan.controller;

import com.luoyan.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return indexService.index();
    }

}
