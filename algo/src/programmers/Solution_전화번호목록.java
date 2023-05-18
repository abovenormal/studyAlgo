package programmers;

/* 프로그래머스 전화번호 목록
*
* 풀이: 처음 나온 번호를 통해 서칭하는 줄 알고 헤맸지만 이후 문제 이해를 다시 해서 해시맵을 통해 검색 시간을 줄여 해결하였음.
*
*정확성  테스트
테스트 1 〉	통과 (0.12ms, 73.5MB)
테스트 2 〉	통과 (0.06ms, 79.4MB)
테스트 3 〉	통과 (0.06ms, 71.7MB)
테스트 4 〉	통과 (0.09ms, 66.7MB)
테스트 5 〉	통과 (0.07ms, 84.7MB)
테스트 6 〉	통과 (0.06ms, 79.5MB)
테스트 7 〉	통과 (0.06ms, 75.9MB)
테스트 8 〉	통과 (0.08ms, 68.8MB)
테스트 9 〉	통과 (0.07ms, 78.5MB)
테스트 10 〉	통과 (0.11ms, 72.2MB)
테스트 11 〉	통과 (0.07ms, 76MB)
테스트 12 〉	통과 (0.10ms, 74.6MB)
테스트 13 〉	통과 (0.07ms, 86MB)
테스트 14 〉	통과 (3.01ms, 74.2MB)
테스트 15 〉	통과 (2.87ms, 79.2MB)
테스트 16 〉	통과 (5.32ms, 79.4MB)
테스트 17 〉	통과 (7.95ms, 81.4MB)
테스트 18 〉	통과 (11.99ms, 85.4MB)
테스트 19 〉	통과 (4.28ms, 76.9MB)
테스트 20 〉	통과 (5.42ms, 81.5MB)
효율성  테스트
테스트 1 〉	통과 (4.50ms, 57.1MB)
테스트 2 〉	통과 (3.76ms, 57.4MB)
테스트 3 〉	통과 (304.44ms, 183MB)
테스트 4 〉	통과 (223.00ms, 142MB)
*
*
*
* */

import java.util.HashMap;


public class Solution_전화번호목록 {

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> phoneList = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            phoneList.put(phone_book[i],i);
        }

        for(int i=0;i<phone_book.length;i++){
            for(int j=0; j<phone_book[i].length();j++){
                if(phoneList.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        boolean res = solution(new String[]{"123", "456", "789"});

        if (res) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
