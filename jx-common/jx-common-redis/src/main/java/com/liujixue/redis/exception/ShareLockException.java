package com.liujixue.redis.exception;

/**
 * @Author LiuJixue
 * @Date 2023/9/13 14:57
 * @ClassName: ShareLockException
 */
public class ShareLockException extends RuntimeException{
    public ShareLockException(String message) {
        super(message);
    }
}
