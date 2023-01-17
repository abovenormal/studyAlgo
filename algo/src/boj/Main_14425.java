package boj;

import java.io.*;
import java.util.*;

public class Main_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        String[] checkArr = new String[n];

        for (int i = 0; i < n; i++) {
            checkArr[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {

                if (input.equals(checkArr[j])) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
