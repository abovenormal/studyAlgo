package programmers;

import java.util.*;

public class Solution_기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain =(int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            // Math.ceil = 그 값보다 크거나 같은 정수.(올림)
            queue.add(remain);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty()) {
                int next = queue.peek();
                if (cur < next) {
                    answer.add(cnt);
                    break;
                } else {
                    queue.poll();
                    cnt++;
                }
            }

            if (queue.isEmpty()) {
                answer.add(cnt);
            }
        }

        List<Integer> ret = new LinkedList<>();

        while (!answer.isEmpty()) {
            ret.add(answer.poll());
        }

        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] solutionStreamVersion (int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }



    public static void main(String[] args) {
        solution(new int[]{95, 95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1, 1});
//        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
//        solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});

    }
}
