package com.omfine.day.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageUI implements Serializable {

    private long total = 0;

    private List<User> rows = null;
}
