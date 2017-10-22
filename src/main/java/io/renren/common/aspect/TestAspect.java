package io.renren.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(io.renren.common.annotation.TestAnnotation)")
    public void testAnnotationPointCut() {
    }

    @Before("testAnnotationPointCut()")
    public void beforeAnnotation() {
        System.out.println("===========自定义注解====beforeAnnotation=========================");
    }

    @Around("testAnnotationPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();

        System.out.println("===========自定义注解====around=========================");
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        return result;
    }
    @After("testAnnotationPointCut()")
    public void afterAnnotation() {
        System.out.println("===========自定义注解====afterAnnotation=========================");
    }
}
