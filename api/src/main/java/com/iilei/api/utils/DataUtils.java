package com.iilei.api.utils;

import org.springframework.beans.BeanUtils;

public class DataUtils {
    public static <T, S> S copyProperties(T source, S tag) {
        if(source==null) return null;
        BeanUtils.copyProperties(source, tag);
        return tag;
    }
}
