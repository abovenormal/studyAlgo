package boj;

import java.io.*;
import java.util.*;

public class Main_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int lastPoint = Integer.MIN_VALUE;            // 종료점을 파악하기 위해서 가장 큰 값을 따로 선별해두어 양수,음수 리스트에서 마지막 포인트를 찾기 위한 변수
        int ans = 0;

        String[] input = br.readLine().split(" ");

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int temp = Integer.parseInt(input[i]);

            if (temp > 0)
                pos.add(Math.abs(temp));
            else
                neg.add(Math.abs(temp));

            if(Math.abs(temp)>lastPoint){
                lastPoint = Math.abs(temp);
            }
        }

        Collections.sort(pos, Collections.reverseOrder());          //
        Collections.sort(neg, Collections.reverseOrder());

        ans = listLength(pos,m,lastPoint) + listLength(neg,m,lastPoint);

        System.out.println("ans:" + ans);
    }

    public static int listLength(List<Integer> list,int books,int lastPoint) {
        
        int tot = 0;
        int len = list.size();

        for (int i = 0; i < len; i += books) {
            if (i == 0 && lastPoint==list.get(i)) {
                tot += Math.abs(list.get(i));
            } else {
                tot += Math.abs(list.get(i))*2;
            }
        }
        return tot;
    }
}
