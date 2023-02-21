package boj;

import java.util.Scanner;

public class Main_10870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = fibo(N);
        System.out.println(ans);
    }
    public static int fibo(int n){
        if(n == 0){
            return 0;
        }
        if(n==1 || n==2 ){
            return 1;
        }

        return fibo(n-1)+fibo(n-2);
    }
}
