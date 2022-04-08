package com.omfine.day.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.day.bean.User;
import com.omfine.day.service.UService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RestController
public class HelloController {

    @Resource
    private UService uService;

    @RequestMapping("/hello")
    public String hello(){
        List<User> users = uService.getAll();
        System.err.println(users.toString());
        return "Hi";
    }

    String[] cityS = new String[]{"bj" , "sz" , "cs" , "cd" , "gz", "gz"};
    String[] nameS = new String[]{"John" , "Price" , "Blink" , "Luci", "Rose", "Flower", "Apple"};

    @RequestMapping("/a")
    public String insert(){
        User user = new User();
        int cityRandom = new Random().nextInt(500);
        int nameRandom = new Random().nextInt(1000);
        user.city = cityS[cityRandom%(cityS.length)] + new Random().nextInt(5000);
        user.name = nameS[nameRandom%(nameS.length)] + new Random().nextInt(3000);
        int result = uService.insert(user);
        System.err.println("===========================添加结果: " + result);
        return "添加结果: " + result;
    }

    int[] idS = new int[]{10005, 10009, 10018, 10019, 10020, 10021, 10022, 10023, 10024, 10025, 10026, 10027, 10028, 10029, 10030};

    @RequestMapping("/d")
    public String deleteById(){
        int idRandom = new Random().nextInt(500);
        int result = uService.deleteById(idS[idRandom%(idS.length)]);
        System.err.println("===========================删除结果: " + result);
        return "删除结果: " + result;
    }

    @RequestMapping("/u")
    public String updateById(){
        User user = new User();
        int cityRandom = new Random().nextInt(500);
        int nameRandom = new Random().nextInt(1000);
        int idRandom = new Random().nextInt(300);
        user.city = cityS[cityRandom%(cityS.length)] + new Random().nextInt(5000);
        user.name = nameS[nameRandom%(nameS.length)] + new Random().nextInt(3000);
        user.uid = idS[idRandom%(idS.length)];
        int result = uService.updateById(user);
        System.err.println("===========================更新结果: " + result);
        return "更新结果: " + result;
    }

    @RequestMapping("/s")
    public String selectPage(){
        List<User> users = uService.selectPage(2 , 10);
        return "分页查询结果: " + JSON.toJSONString(users);
    }

    @RequestMapping("/query")
    public String selectPageF(){
        List<User> users = uService.selectPage(2 , 10);
        String result = JSON.toJSONString(users);
        System.err.println("===========================更新结果: " + result);
        return result;
    }

}
