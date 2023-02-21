package boj;

import java.io.*;
import java.util.*;

public class Main_10872 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ans = fact(n);

        System.out.println(ans);
    }
    public static int fact(int n){
        if(n == 0)
            return 1;

        return n * fact(n-1);
    }
}
