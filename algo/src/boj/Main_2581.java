// 백준 2581 소수

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> prime = new LinkedList<>();

        for (int i = n; i <= m; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (i!= 1 && isPrime) prime.add(i);
        }

        if (prime.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int i : prime) {
                sum += i;
                //System.out.print(i + " ");
            }
            System.out.println(sum);
            System.out.println(prime.get(0));
        }
    }
}
