package boj;

/*
*
* 제목 : 백준 17298_오큰수
* 풀이 : 스택을 활용하여 오른쪽에 있는 큰수를 표시하는 문제이다.
        입력된 숫자들의 역순으로 부터 수를 탐색한다.
        탐색하는 현재 값이 스택의 top 값보다 작으면 answer 배열에 넣고, 스택에 넣는다
        현재 값이 스택 top의 값보다 더 크면 스택의 값을 pop하고 만약 스택안에 값이 없으면 answer 배열에 -1을 넣는다.
        다음과 같은 방식으로 해도 배열 값을 그대로 출력하면 시간초과되므로, stringbuilder에 넣어 출력한다.
* 실행결과 :
*   262972kb // 1256ms
* */
import java.io.*;
import java.util.*;

public class Main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.empty())
                answer[i] = -1;
            else answer[i] = arr[stack.peek()];
            stack.add(i);
        }


        for (int i : answer) {
            sb.append(i+" ");
        }

        System.out.println(sb);

    }
}
