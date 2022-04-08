package com.omfine.day.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    public String name = null;
    public String city = null;
    @TableId
    public int uid = 0;
}
