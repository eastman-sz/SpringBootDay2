package com.omfine.day.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.omfine.day.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UMapper extends BaseMapper<User> {


    @Select("select * from user")
    //@Results({@Result(property = "uid",column = "uid",javaType = Integer.class)})
    List<User> getAll();


}
