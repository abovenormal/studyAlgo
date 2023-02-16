package boj;

import java.io.*;
import java.util.*;

public class Main_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h, w, water = 0;

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        String[] blocks = br.readLine().split(" ");
        int[] bottle = new int[blocks.length];

        int idx = 0;
        for (String s : blocks) {
            bottle[idx] = Integer.parseInt(s);
            idx++;
        }

        for (int i = 1; i < w; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, bottle[j]);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, bottle[j]);
            }

            if (bottle[i] < left && bottle[i] < right) {
                water += Math.min(left, right) - bottle[i];
            }
        }

        System.out.println(water);
    }
}
