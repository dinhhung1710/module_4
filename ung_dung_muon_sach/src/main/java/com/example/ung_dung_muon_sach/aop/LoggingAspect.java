package com.example.ung_dung_muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private int visitCount = 0;

    @Before("execution(* com.example.ung_dung_muon_sach.controller.*.*(..))")
    public void logVisit(JoinPoint joinPoint) {
        visitCount++;
        System.out.println(" Lượt truy cập " + visitCount + ": " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.service.BookService.borrowBook(..)) || execution(* com.example.ung_dung_muon_sach.service.BookService.returnBook(..))")
    public void logBookChange(JoinPoint joinPoint) {
        System.out.println(" Đã thay đổi trạng thái sách: " + joinPoint.getSignature().getName());
    }
}
