package com.example.player_springboot.aop;

import org.aspectj.lang.annotation.After;

public class PlayerCounter {
    private static int addCount = 0;
    @After("execution(* com.example.demo.service.impl.PlayerService.add(..))")
    public void countAddPlayer() {
        addCount++;
        System.out.println("Tổng số lần thêm cầu thủ: " + addCount);
    }
}
