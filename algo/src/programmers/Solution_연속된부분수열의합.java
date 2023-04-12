package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_연속된부분수열의합 {

    public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int partitionSum = sequence[0];

        int n = sequence.length;

        List<SubSequence> subs = new ArrayList<>();
        while (true){
            if(partitionSum == k){
                subs.add(new SubSequence(left, right));
            }
            if(left == n && right == n) break;

            if(partitionSum <= k && right < n){
                right++;
                if(right < n) partitionSum += sequence[right];
            } else {
                if(left < n) partitionSum -= sequence[left];
                left++;
            }
        }

        subs.sort(Comparator.comparingInt(subsequence -> subsequence.size));

        return new int[]{subs.get(0).left, subs.get(0).right};

    }

    private static class SubSequence{
        int left, right, size;

        public SubSequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }
    }


    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5}, 7);
        solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        solution(new int[]{2, 2, 2, 2, 2}, 6);
    }
}
