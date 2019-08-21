package com.iilei.api.utils;

import org.springframework.beans.BeanUtils;

public class DataUtils {
    public static <T, S> S copyProperties(T source, S tag) {
        BeanUtils.copyProperties(source, tag);
        return tag;
    }
}
