package programmers;

import java.util.Stack;

public class Solution_비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            StringBuilder sb = new StringBuilder();
            int temp = arr1[i] | arr2[i];

            for(int j = 0; j<n;j++){
                if(temp%2==1)
                    stack.push("#");
                else
                    stack.push(" ");
                temp /=2;
            }

            for(int j=0;j<n;j++){
                sb.append(stack.pop());
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
