package euler.dbehnke.github.com;

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

    static boolean checkprime(long n) {
        for (long i = 2; i < n; i++) {
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
              if (checkprime(a) && a > largest) largest = a;
              if (checkprime(b) && b > largest) largest = b;
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
                if (s.length() % 2 == 0) {
                    //even numbers canidate for palindrome
                    boolean palindrome = true;
                    for (int k = 0; k < s.length() / 2; k++) {
                        char[] ss = s.toCharArray();
                        if (ss[0] != ss[s.length()-k-1]) {
                            palindrome = false;
                            break;
                        }
                    }
                    if (palindrome) {
                     System.out.println(product);
                     if (product > largest) largest = product;
                    }
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {

        //System.out.println("problem 2 - " + problem2());
        //System.out.println("problem 3 - " + problem3(600851475143L));
        System.out.println("problem 4 - " + problem4());

    }
}
