package programmers;

import java.util.Stack;

public class Solution_비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int num1 = arr1[i];
            int num2 = arr2[i];

            for (int j = 0; j < n; j++) {       // 주어진 수 2진수로 변환
                stack1.push(num1 % 2);
                stack2.push(num2 % 2);
                num1 = num1 / 2;
                num2 = num2 / 2;
            }

            for (int j = 0; j < n; j++) {       // 앞의 자리 수부터 하나씩 비교
                int temp1 = stack1.pop();
                int temp2 = stack2.pop();

                if (temp1 == 1 || temp2 == 1) {
                    sb.append("#");
                }
                else
                    sb.append(" ");
            }

            answer[i] = sb.toString();
        }


        return answer;
    }

    public static void main(String[] args) {

        int n = 5;
        int arr1[] = {9, 20, 28, 18, 11};
        int arr2[] = {30, 1, 21, 17, 28};

        solution(n, arr1, arr2);

    }
}
