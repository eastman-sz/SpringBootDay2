package com.omfine.day.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.omfine.day.bean.User;
import com.omfine.day.mapper.UMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UServiceImp implements UService {

    @Resource
    private UMapper uMapper;

    @Override
    public int insert(User user) {
        return uMapper.insert(user);
    }

    @Override
    public int deleteById(int userId) {
        return uMapper.deleteById(userId);
    }

    @Override
    public int updateById(User user) {
        return uMapper.updateById(user);
    }

    @Override
    public List<User> getAll() {
        // return uMapper.getAll();
        return uMapper.selectList(null);
    }

    @Override
    public List<User> selectPage(int page, int rows) {
        IPage<User> iPage = new Page<>(page , rows);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("uid");

        IPage<User> resultPage = uMapper.selectPage(iPage , queryWrapper);
        List<User> users = resultPage.getRecords();
        return users;
    }

    @Override
    public User selectById(int userId) {
        return uMapper.selectById(userId);
    }

}
