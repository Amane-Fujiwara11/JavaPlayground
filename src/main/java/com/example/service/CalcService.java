package com.example.service;

import org.springframework.stereotype.Service;

/**
 * 数学計算を行うサービスクラス
 */
@Service
public class CalcService {

    /**
     * 正の整数の階乗を計算します。
     * 
     * @param number 正の整数
     * @return aの階乗
     */
    public int fact(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("正の整数は1以上でなければなりません。");
        }
        int result = 1;
        for (int i = number; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    /**
     * フィボナッチ数列のn番目の値を計算します。
     * 
     * @param number n番目の値
     * @return フィボナッチ数列のn番目の値
     */
    public int fibo(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("フィボナッチ数列は非負整数に対して定義されています。");
        }

        switch (number) {
            case 0:
                // F(0) = 0
                return 0;
            case 1:
                // F(1) = 1
                return 1;
            default:
                // F(n) = F(n-1) + F(n-2) （n ≥ 2）
                int prev = 0;
                int curr = 1;
                for (int i = 2; i <= number; i++) {
                    int next = prev + curr;
                    prev = curr;
                    curr = next;
                }
                return curr;
        }

    }
}
