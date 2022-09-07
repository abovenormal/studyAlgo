package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 코딩테스트 연습 >> 스택/큐
/*
채점 결과
정확성: 71.9
효율성: 28.1
합계: 100.0 / 100.0
* */

public class Solution_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            if (i != arr.length - 1) {
                if (arr[i] != arr[i + 1])
                    queue.add(i);
            } else {// 마지막 순번
                queue.add(i);
            }

        }

        answer = new int[queue.size()];

        for(int i=0; !queue.isEmpty();i++){
            answer[i] = arr[queue.poll()];
        }

        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 3, 0, 1, 1};
        //int arr[] = {4,4,4,3,3};
        solution(arr);
    }

}