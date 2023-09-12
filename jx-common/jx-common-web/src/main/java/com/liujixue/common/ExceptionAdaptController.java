package com.liujixue.common;

import com.liujixue.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author LiuJixue
 * @Date 2023/9/12 09:40
 * @ClassName: ExceptionAdaptController
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class ExceptionAdaptController {
    @ExceptionHandler(RuntimeException.class)
    public Result runTimeException(RuntimeException exception){
        exception.printStackTrace();
        return Result.fail();
    }
    @ExceptionHandler(Exception.class)
    public Result exception(Exception exception){
        exception.printStackTrace();
        return Result.fail();
    }
}
