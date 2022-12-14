package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A, B, V, ans;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        ans = (V-B)/(A-B);

        if(((V-B)%(A-B))!=0)
            ans++;

        System.out.println(ans);
    }
}
