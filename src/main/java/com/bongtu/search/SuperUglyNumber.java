package com.bongtu.search;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] numbers = new int[n];
        int[] pointers = new int[primes.length];

        numbers[0] = 1;

        for (int i = 1; i < n; i++) {

            int currentMin = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                int next = numbers[pointers[j]] * primes[j];

                if (currentMin > next) {
                    currentMin = next;
                }
            }

            numbers[i] = currentMin;

            for (int j = 0; j < primes.length; j++) {
                if (numbers[pointers[j]] * primes[j] == currentMin) {
                    pointers[j]++;
                }
            }
        }

        return numbers[n - 1];
    }
}
