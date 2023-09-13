package com.liujixue.redis.init;

import com.liujixue.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2023/9/13 13:56
 * @ClassName: InitCache
 * implements CommandLineRunner 项目启动后执行
 */
@Component
public class InitCache implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // 哪些缓存需要进行预热
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        // 调用 init
        if(beanMap.isEmpty()){
            return;
        }
        for (Map.Entry<String,AbstractCache> entry:beanMap.entrySet()){
            AbstractCache abstractCache = (AbstractCache)SpringContextUtil.getBean(entry.getValue().getClass());
            abstractCache.initCache();
        }
    }
}
