// 백준 9506, 약수들의 합

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            LinkedList<Integer> list = new LinkedList<>();

            if (n == -1) break;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n + " = ");
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        sb.append(list.get(i));
                    } else {
                        sb.append(list.get(i) + " + ");
                    }
                }
            } else {
                sb.append(n + " is NOT perfect.");
            }

            System.out.println(sb);

        }
    }
}