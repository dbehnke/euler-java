package com.github.dbehnke.euler;

import java.util.ArrayList;
import java.math.*;

public class Main {

    static long problem2() {
        long a = 1, b = 1, sum = 0;
        while (b < 4000000) {
            long c = b + a;
            a = b;
            b = c;
            if (c % 2 == 0) {
                sum = sum + c;
            }
        }
        return sum;
    }

    static boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i*i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static long problem3(long n) {
        double nsqrt = Math.sqrt(n);
        long largest = 0;
        for (long i = 2; i < nsqrt; i++) {
          if (n % i == 0) {
              long a = i;
              long b = n/i;
              if (isPrime(a) && a > largest) largest = a;
              if (isPrime(b) && b > largest) largest = b;
          }
            //System.out.println(i);
        }
        return largest;
    }

    static long problem4() {
        long largest = 0;
        for (int i = 100; i < 999; i++) {
            for (int j = 100; j < 999; j++) {
                long product = i * j;
                String s = Long.toString(product);
                if (isPalindrome(s)) {
                    //System.out.println(String.format("%d %d %s", i, j, s));
                    if (product > largest) largest = product;
                }
            }
        }
        return largest;
    }

    public static long problem5() {
        //brute force approach.
        long v = 0;
        boolean found = false;
        while (!found) {
            v++;
            found = true;
            for (long i = 1; i < 21; i++) {
                if (v % i != 0) {
                    found = false;
                    break;
                }
            }
        }
        return v;
    }

    public static long problem6() {
        long first = 0;
        long second = 0;
        for (long i = 1; i <= 100; i++) {
            first += (i*i);
            second += i;
        }
        second = second * second;
        System.out.println("" + first + " " + second);
        return second - first;
    }

    public static long problem7() {
        long primesfound = 1;
        long lastprime = 2;
        long i = 2;
        while (primesfound < 10001) {
            i++;
            if (isPrime(i)) {
                lastprime = i;
                primesfound++;
            }
        }
        return lastprime;
    }


    public static boolean isBinaryPalindrome(int x) {
        String xs = Integer.toBinaryString(x);
        return isPalindrome(xs);
    }


    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        if (s.length() <= 1) return true;
        char first = s.charAt(0);
        char last = s.charAt(s.length()-1);
        if (first == last) {
            if (s.length() == 2) return true;
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        return false;

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //System.out.println("problem 2 - " + problem2());
        //System.out.println("problem 3 - " + problem3(600851475143L));
        System.out.println("problem 4 - " + problem4());
        //System.out.println("problem 5 - " + problem5());
        //System.out.println("problem 6 - " + problem6());
        // System.out.println("problem 7 - " + problem7());
        //System.out.println(isPalindrome("101"));
        long finish = System.currentTimeMillis();
        System.out.println("Time: " + (finish - start) + "ms");
    }
}
