package com.cmb.aop;

import com.cmb.annotation.LogInfo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.cmb.annotation.LogInfo)")
    private void pointcut() {}

    @Before("pointcut() && @annotation(logger)")
    public void advice(LogInfo logger) throws Exception {

        if(logger.check()){
            throw new Exception("验证不通过,不能往下执行");
        }

        System.out.println("--- 日志的内容为[" + logger.value() + "] ---");
    }
}
