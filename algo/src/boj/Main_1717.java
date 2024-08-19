/*
* 백준 1717
* Union-Find 알고리즘 + !!경로압축!! -> 경로 압축을 통해 O(n)에서 O(logn)으로 줄일 수 있음.
* */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        // 배열의 초기화

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else if (cmd == 1) {
                if(find(a) == find(b)) {
                    bw.write("YES"+"\n");
                }
                else bw.write("NO"+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else {
            return parent[x]=find(parent[x]);  // 경로압축
        }
//        else return find(parent[x]);
    }


}