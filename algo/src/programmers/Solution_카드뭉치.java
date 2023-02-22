package programmers;

/*
* 프로그래머스 : 카드 뭉치
* 풀이 : 단어의 순서를 두 개의 큐를 이용하였다.
* 실행결과 :
*테스트 1 〉	통과 (0.20ms, 75.5MB)
테스트 2 〉	통과 (0.13ms, 73.4MB)
테스트 3 〉	통과 (0.13ms, 73.5MB)
테스트 4 〉	통과 (0.20ms, 79.1MB)
테스트 5 〉	통과 (0.17ms, 73.8MB)
테스트 6 〉	통과 (0.16ms, 66.7MB)
테스트 7 〉	통과 (0.18ms, 78.8MB)
테스트 8 〉	통과 (0.12ms, 86.9MB)
테스트 9 〉	통과 (0.12ms, 71.7MB)
테스트 10 〉	통과 (0.12ms, 75.6MB)
테스트 11 〉	통과 (0.14ms, 71.7MB)
테스트 12 〉	통과 (0.19ms, 75.9MB)
테스트 13 〉	통과 (0.29ms, 70.5MB)
테스트 14 〉	통과 (0.18ms, 73.5MB)
테스트 15 〉	통과 (0.21ms, 72.2MB)
테스트 16 〉	통과 (0.18ms, 79.1MB)
테스트 17 〉	통과 (0.21ms, 71.8MB)
테스트 18 〉	통과 (0.13ms, 72MB)
테스트 19 〉	통과 (0.13ms, 71.2MB)
테스트 20 〉	통과 (0.17ms, 75MB)
테스트 21 〉	통과 (0.18ms, 73.4MB)
테스트 22 〉	통과 (0.11ms, 66.6MB)
테스트 23 〉	통과 (0.14ms, 74.2MB)
테스트 24 〉	통과 (0.14ms, 64.8MB)
테스트 25 〉	통과 (0.17ms, 75.2MB)
* */

import java.util.*;

public class Solution_카드뭉치 {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        boolean check = true;
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        for (String s : cards1) {
            q1.add(s);
        }
        for (String s : cards2) {
            q2.add(s);
        }

        for (String s : goal) {
            if (Objects.equals(q1.peek(),s) && !q1.isEmpty()) {
                q1.remove();
            } else if (Objects.equals(q2.peek(), s) && !q2.isEmpty()) {
                q2.remove();
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            answer = "Yes";
        } else {
            answer = "No";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }
}
