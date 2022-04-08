package com.omfine.day.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class News {

    @TableId
    public int nid = 0;

    public String title = null;
    public String source = null;
    public String images = null;
    public long updateTimestamp = 0;
    public long cTime = 0;
    public String url = null;

}
