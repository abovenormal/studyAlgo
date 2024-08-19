import java.util.*;
import java.io.*;
public class Solution {

    static int[][] answer;
    static int depth;

    public static int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];
        hanoi(n,1,2,3);

        return answer;
    }

    public static void hanoi(int n, int start, int mid, int to){
        if(n==1){
            answer[depth][0] = start;
            answer[depth][1] = to;
            depth++;
            return;
        }

        hanoi(n-1, start,to,mid);
        answer[depth][0] = start;
        answer[depth][1] = to;
        depth++;

        hanoi(n-1,mid,start,to);

    }

    public static void main(String[] args) {
        solution(2);
    }
}