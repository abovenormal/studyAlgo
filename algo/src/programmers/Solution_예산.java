package programmers;

import java.util.*;

public class Solution_예산 {

    public static int solution(int[] d, int budget) {
        int answer = 0;

        List<Integer> list = new LinkedList<>();

        for (int i : d) {
            list.add(i);
        }

        Collections.sort(list);

        int sum = 0;
        for (int i : list) {
            sum +=i;
            if(sum<=budget){
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1,3,2,5,4},9);
    }
}
