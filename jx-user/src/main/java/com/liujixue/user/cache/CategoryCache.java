package com.liujixue.user.cache;

import com.liujixue.redis.init.AbstractCache;
import com.liujixue.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author LiuJixue
 * @Date 2023/9/13 13:58
 * @ClassName: SysCache
 */
@Component
public class CategoryCache extends AbstractCache {
    @Autowired
    private static final String CATEGORY = "CATEGORY";
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void initCache() {
        // 跟数据库做联动，跟其他的数据来源进行联动
        redisUtil.set("category","知识");
    }
    @Override
    public <T> T getCache(String key) {
        if(redisTemplate.hasKey(key).booleanValue()){
            reloadCache();
        }
        return (T)redisTemplate.opsForValue().get(key);
    }
    @Override
    public void clearCache() {
        redisTemplate.delete(CATEGORY);
    }
}
