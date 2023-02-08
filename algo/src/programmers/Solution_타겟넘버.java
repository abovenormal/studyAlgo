package programmers;

/*
프로그래머스 : 타겟 넘버
풀이 : Bfs방식을 이용하여 각 숫자의 양,음의 값과 현재까지의 합을 한 세트로 넘겨서 전체 가능한 값을 모두 구하였다.
      그 후 타겟 넘버와 비교하여 모든 가지수 중 같은 값을 확인하여 개수를 구하였다.

실행 결과
테스트 1 〉	통과 (209.38ms, 162MB)
테스트 2 〉	통과 (215.98ms, 158MB)
테스트 3 〉	통과 (1.84ms, 79.4MB)
테스트 4 〉	통과 (3.47ms, 72.1MB)
테스트 5 〉	통과 (20.91ms, 76.5MB)
테스트 6 〉	통과 (1.63ms, 76.2MB)
테스트 7 〉	통과 (1.27ms, 76MB)
테스트 8 〉	통과 (4.68ms, 79.4MB)
*/

import java.util.LinkedList;
import java.util.Queue;

class Nums{
    int num;
    int index;
    int sum;

    Nums(int num,int index, int sum){
        this.num = num;
        this.index = index;
        this.sum = sum;
    }

}
public class Solution_타겟넘버 {

    public static Queue<Nums> queue = new LinkedList<>();
    public static int cnt =0;

    public static int solution(int[] numbers, int target) {

        int sum = 0;
        cnt = 0;

        queue.add(new Nums(numbers[0],0,sum));
        queue.add(new Nums(numbers[0]*-1,0,sum));

        bfs(numbers,target);

        return cnt;
    }

    public static void bfs(int[] numbers,int target){

        while(!queue.isEmpty()){
            Nums curPoint = queue.remove();
            curPoint.sum += curPoint.num;

            if(curPoint.index+1 == numbers.length){
                if(curPoint.sum == target){
                    cnt++;
                }
                continue;
            }
            queue.add(new Nums(numbers[curPoint.index+1],curPoint.index+1,curPoint.sum));
            queue.add(new Nums(numbers[curPoint.index+1]*-1,curPoint.index+1,curPoint.sum));
        }
    }



    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,1,1,1}, 3));
        System.out.println(solution(new int[] {4,1,2,1}, 4));
    }
}
