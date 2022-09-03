package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {

    static int N, M, V;
    static int arr[][];

    static boolean check1[];
    static boolean check2[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        check1 = new boolean[N];
        check2 = new boolean[N];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int startNode, endNode;
            startNode = Integer.parseInt(st.nextToken()) - 1;
            endNode = Integer.parseInt(st.nextToken()) - 1;

            arr[startNode][endNode] = 1;
            arr[endNode][startNode] = 1;
        }

        dfs(V);
        System.out.println();
        System.out.println(bfs());

    }

    public static void dfs(int start) {

        if (check1[start - 1] == true)
            return;


        check1[start - 1] = true;
        System.out.print(start + " ");

        for (int i = 0; i < N; i++) {
            if (arr[start - 1][i] == 1 && check1[i] == false) {
                dfs(i + 1);
            }
        }


    }

    public static String bfs() {
        String ans = "";

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(V - 1);
        check2[V - 1] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            sb.append(currentNode + 1 + " ");

            for (int i = 0; i < N; i++) {
                if (arr[currentNode][i] == 1 && check2[i] == false) {
                    queue.add(i);
                    check2[i] = true;
                }
            }

        }

        ans = sb.toString();
        return ans;
    }
}
