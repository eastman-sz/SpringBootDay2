package com.omfine.day.service;

import com.omfine.day.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UService {

    int insert(User user);

    int deleteById(int userId);

    int updateById(User user);

    List<User> getAll();

    List<User> selectPage(int page , int rows);

    User selectById(int userId);
}
