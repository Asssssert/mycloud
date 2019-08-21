package com.iilei.basicsauthority.utils;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * author:Lilei
 * email:670182350@qq.com
 * desc:分页用工具类
 */
public class PageUtils {
    public static Page pageSizeCheck(Integer page, Integer size) {
        page = page == null ? 1 : page;
        size = size == null ? 10 : size;
        return new Page<>(page, size);
    }
}
