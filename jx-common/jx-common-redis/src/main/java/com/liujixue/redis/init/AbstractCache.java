package com.liujixue.redis.init;

import org.springframework.stereotype.Component;

/**
 * @Author LiuJixue
 * @Date 2023/9/13 11:28
 * @ClassName: AbstractCache
 */
@Component
public abstract class AbstractCache {
    public void initCache(){}
    public <T> T getCache(String key){
        return null;
    }
    public void clearCache(){}
    public void reloadCache(){
        clearCache();
        initCache();
    }
}
