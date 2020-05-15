package com.luoyan.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class NotVeryUsefulAspect {


    //    @Pointcut("this(com.luoyan.bean.A)")
    @Pointcut("within(com.luoyan.bean.Caculate)")
    public void pointCut() {

    }

//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("----around begin ----");
//        Object proceed = pjp.proceed();
//        System.out.println("-----around end-----");
//        return proceed;
//    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("方法【" + joinPoint.getSignature().getName() + "】的<前置通知>，入参" + Arrays.asList(args));
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("方法【" + joinPoint.getSignature().getName() + "】的<后置通知>，入参" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("方法【" + joinPoint.getSignature().getName() + "】的<返回通知>，返回 ： " + result);
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("方法【" + joinPoint.getSignature().getName() + "】的<异常通知>");
    }
}
