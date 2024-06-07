/*
*
테스트 1 〉	통과 (0.02ms, 83.9MB)
테스트 2 〉	통과 (0.02ms, 74.7MB)
테스트 3 〉	통과 (8.11ms, 74.2MB)
테스트 4 〉	통과 (0.07ms, 85.9MB)
테스트 5 〉	통과 (0.13ms, 72MB)
테스트 6 〉	통과 (2.15ms, 70.9MB)
테스트 7 〉	통과 (5.76ms, 78MB)
테스트 8 〉	통과 (4.34ms, 72.6MB)
테스트 9 〉	통과 (4.21ms, 82.8MB)
테스트 10 〉	통과 (5.87ms, 78.9MB)
테스트 11 〉	통과 (0.03ms, 76.6MB)
테스트 12 〉	통과 (0.02ms, 75.6MB)
테스트 13 〉	통과 (0.03ms, 82.7MB)
*
* 완전 탐색(브루트포스)
* */

import java.util.HashMap;

public class Main {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        HashMap<Integer, Integer> numList = new HashMap<>();

        int tot = brown + yellow;
        int temp;

        for (int i = 1; i < tot / 2; i++) {
            if (tot % i == 0) {
                temp = tot / i;

                if (yellow == (temp - 2) * (i - 2) && temp >= i) {
                    answer[0] = temp;
                    answer[1] = i;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static void main(String[] args) {

        // int[] answer1 = solution(10, 2);
        int[] answer2 = solution(8, 1);
        // int[] answer3 = solution(24, 24);


    }
}