package com.liujixue.redis.util;


import com.liujixue.redis.exception.ShareLockException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuJixue
 * @Date 2023/9/13 14:49
 * @ClassName: RedisShareLockUtil
 * @Description: redis 分布式锁 util
 */
@Component
public class RedisShareLockUtil {
    @Resource
    private RedisUtil redisUtil;

    private Long TIME_OUT = 10000L;

    /**
     * 加锁
     *
     * @return
     */
    public boolean lock(String lockKey, String requestId, Long time) {
        // 1. 参数校验
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-加锁-参数异常");
        }
        long currentTime = System.currentTimeMillis();
        long outTime = currentTime + TIME_OUT;
        Boolean result = false;
        // 2. 加锁可以有自旋
        while (currentTime < outTime) {
            // 3. 借助 setnx 进行锁的设置
            result = redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            if (result) {
                return result;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTime = System.currentTimeMillis();
        }
        return result;
    }

    /**
     * 解锁
     *
     * @return
     */
    public boolean unlock(String key, String requestId) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId)) {
            throw new ShareLockException("分布式锁-解锁-参数异常");
        }
        try {
            String value = redisUtil.get(key);
            if (requestId.equals(value)) {
                redisUtil.del(key);
                return true;
            }
        } catch (Exception e) {
            // TODO 日志系统
        }
        return false;
    }

    /**
     * 尝试加锁
     *
     * @return
     */
    public boolean tryLock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-尝试加锁-参数异常");
        }
        return redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
    }
}
