package com.bongtu.math;

public class UglyNumber {
    public boolean isUgly(int n) {
        int[] primes = { 2, 3, 5 };

        if (n == 0)
            return false;

        for (int prime : primes) {
            while (n % prime == 0) {
                n /= prime;
            }
        }

        return n == 1;
    }
}
