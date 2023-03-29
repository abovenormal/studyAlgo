package programmers;

import java.util.*;
/*
* 제목 : 프로그래머스, 더 맵게
* 풀이 :
* 조건은 scoville의 길이는 2 이상 1,000,000 이하입니다.
*       K는 0 이상 1,000,000,000 이하입니다.
*       scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
*  다음과 같으므로 반복문과 배열을 통해 해결하는 것 보단 힙구조를 활용하여 해결하는 것이
*  최적화에 도움이 될 것으로 판단되어 우선순위 큐를 활용하여 문제를 해결하였다.
*
*
* */

public class Solution_더맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.peek() < K && pq.size() >= 2) {

            int first = pq.poll();
            int second = pq.poll();
            int temp = first + (second * 2);

            pq.add(temp);
            answer++;
        }

        if (pq.size() == 1 && pq.peek() < K) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
