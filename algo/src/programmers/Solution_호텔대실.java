package programmers;

import java.util.*;

/*
프로그래머스 : 호텔 대실
풀이 : 우선순위 큐를 활용하여 시간을 순차적으로 정렬한 후 값을 구함.
실행 결과 :
테스트 1 〉	통과 (0.81ms, 71.8MB)
테스트 2 〉	통과 (3.52ms, 84.3MB)
테스트 3 〉	통과 (6.27ms, 95.4MB)
테스트 4 〉	통과 (6.28ms, 78.3MB)
테스트 5 〉	통과 (0.52ms, 79.5MB)
테스트 6 〉	통과 (7.36ms, 81.4MB)
테스트 7 〉	통과 (6.35ms, 83.6MB)
테스트 8 〉	통과 (4.50ms, 72.9MB)
테스트 9 〉	통과 (2.96ms, 78.8MB)
테스트 10 〉	통과 (8.81ms, 84.8MB)
테스트 11 〉	통과 (6.03ms, 84.7MB)
테스트 12 〉	통과 (5.66ms, 75.6MB)
테스트 13 〉	통과 (4.57ms, 83.9MB)
테스트 14 〉	통과 (6.18ms, 83MB)
테스트 15 〉	통과 (6.28ms, 93MB)
테스트 16 〉	통과 (3.88ms, 88.4MB)
테스트 17 〉	통과 (5.44ms, 78MB)
테스트 18 〉	통과 (7.02ms, 81.4MB)
테스트 19 〉	통과 (10.47ms, 82.3MB)
* */
public class Solution_호텔대실 {
    public static int solution(String[][] book_time) {

        PriorityQueue<Integer> in = new PriorityQueue<>();
        PriorityQueue<Integer> out = new PriorityQueue<>();

        int max=0, cnt=1;

        for(String[] s : book_time){
            in.offer(time(s[0]));
            out.offer(time(s[1])+10);
        }

        while(!out.isEmpty() && !in.isEmpty()){
            int o = out.poll();
            cnt--;
            while(!in.isEmpty() && in.peek()<o){
                in.poll();
                cnt++;
            }
            max = Math.max(max,cnt);
        }

        return max;
    }

    public static int time(String s){
        String[] str = s.split(":");
        return  Integer.valueOf(str[0])*60 + Integer.valueOf(str[1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }
}
