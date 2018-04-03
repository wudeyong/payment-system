package com.davin.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

// 将DoLog类注册为一个切面
@Aspect
public class DoLog {

    @Before("execution(* *(..))")
    public void doBefore(JoinPoint joinPoint){
        System.out.print("Input time: " + LocalDate.now() + "\t" + LocalTime.now());
        System.out.println("\t"+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
    }

    @After(value = "execution(* *(..))")
    public void doAfter(){
        System.out.println("Output time: " + LocalDate.now() + "\t" + LocalTime.now());
    }

}
