package com.lu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
public class SimpleLogAspect {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(getClass());;
    @Before("@annotation(simpleLog)")
    public void before(JoinPoint joinPoint, SimpleLog simpleLog) throws Throwable {
        logger.info("方法开始时间是:"+new Date());
        logger.info(simpleLog.message()+"{}",joinPoint.getArgs());


    }

}
