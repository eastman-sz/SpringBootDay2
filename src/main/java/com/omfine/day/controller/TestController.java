package com.omfine.day.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.day.bean.User;
import com.omfine.day.service.UService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TestController {

    @Resource
    private UService uService;

    @RequestMapping("")
    public String testM(){
        return "index";
    }

    @RequestMapping("/t")
    public String test(){
        return "test";
    }

    @RequestMapping("/r")
    public String result(User user , Model model){
        System.err.println(JSON.toJSONString(user));
        int result = uService.insert(user);
        model.addAttribute("result" , 1 == result ? "操作成功" : "操作失败");
        return "result";
    }

    @RequestMapping("/e")
    public String operate(Model model){
        List<User> list = uService.selectPage(1 , 10);
        model.addAttribute("users" , list);
        return "edit";
    }

    @RequestMapping("/e/{page}")
    public String operateByPageIndex(@PathVariable int page,  Model model){
        System.err.println("================分页显示数据===========page: " + page);
        List<User> list = uService.selectPage(page , 10);
        model.addAttribute("users" , list);
        return "edit";
    }

    @RequestMapping("/edit/{uid}")
    public String editData(@PathVariable int uid , Model model){
        User user = uService.selectById(uid);
        model.addAttribute("user" , user);
        return "edit_data";
    }

    @RequestMapping("/update")
    public String update(User user, Model model){
        int result = uService.updateById(user);
        model.addAttribute("result" , 1 == result ? "操作成功" : "操作失败");
        return "result";
    }

    @RequestMapping("/del")
    public String del(int uid , Model model){
        System.err.println("================del===========uid: " + uid);
        int result = uService.deleteById(uid);
        model.addAttribute("result" , 1 == result ? "操作成功" : "操作失败");
        return "result";
    }

    @RequestMapping("/delete/{uid}")
    public String delete(@PathVariable int uid , Model model, HttpServletResponse response) throws IOException {
        System.err.println("================delete===========uid: " + uid);
        int result = uService.deleteById(uid);
        model.addAttribute("result" , 1 == result ? "操作成功" : "操作失败");
        response.sendRedirect("/e");
        return "result";
    }

}
