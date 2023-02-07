package programmers;

import java.util.HashSet;

/*

프로그래머스 : 폰켓몬
풀이 : 가져갈 수 있는 폰켓몬의 개수를 구한 후, hashset으로 중복값을 없앤다.
      중복을 제거한 hashset의 크기가 maxsize보다 크면 max를 아니면 setsize를 반환한다.

테스트 1 〉	통과 (0.04ms, 76.7MB)
테스트 2 〉	통과 (0.09ms, 75.5MB)
테스트 3 〉	통과 (0.04ms, 75.5MB)
테스트 4 〉	통과 (0.04ms, 84.5MB)
테스트 5 〉	통과 (0.05ms, 79.4MB)
테스트 6 〉	통과 (0.04ms, 76MB)
테스트 7 〉	통과 (0.36ms, 82.9MB)
테스트 8 〉	통과 (0.35ms, 72.7MB)
테스트 9 〉	통과 (0.33ms, 80.1MB)
테스트 10 〉	통과 (0.32ms, 77.3MB)
테스트 11 〉	통과 (0.27ms, 77.9MB)
테스트 12 〉	통과 (0.52ms, 80.6MB)
테스트 13 〉	통과 (0.76ms, 71.9MB)
테스트 14 〉	통과 (0.94ms, 80.3MB)
테스트 15 〉	통과 (0.64ms, 81MB)
테스트 16 〉	통과 (2.49ms, 80.9MB)
테스트 17 〉	통과 (3.44ms, 84.6MB)
테스트 18 〉	통과 (4.59ms, 83.4MB)
테스트 19 〉	통과 (3.99ms, 78.1MB)
테스트 20 〉	통과 (1.85ms, 80MB)

*/
public class Solution_폰켓몬 {

    public static int solution(int[] nums) {

        int len = nums.length;
        int maxSize = len/2;

        HashSet<Integer> numSet = new HashSet<>();

        for(int i : nums){
            numSet.add(i);
        }

        if(numSet.size()>maxSize){
            return maxSize;
        }else{
            return numSet.size();
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,3}));
    }
}
