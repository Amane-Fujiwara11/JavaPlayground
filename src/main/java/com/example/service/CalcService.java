package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int fanc(int a) {
        if (a < 1) {
            throw new IllegalArgumentException("正の整数は1以上でなければなりません。");
        }
        int result = 1;
        for (int i = a; i > 1; i--) {
            result *= i;
        }
        return result;
    }
}
