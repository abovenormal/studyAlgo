package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int testcase = sc.nextInt();
        int cnt=0;

        int[][] map = new int[n][n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<testcase;i++){

            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            map[n1-1][n2-1] = map[n2-1][n1-1] = 1;

        }

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){

            int curPoint = queue.remove();

            for(int i =0;i<n;i++){

                if(map[curPoint][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }

        for(int i=1;i<n;i++){
            if(visited[i]){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
