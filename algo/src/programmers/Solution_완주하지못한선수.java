package programmers;


/* 프로그래머스 : 완주하지 못한 선수

풀이 : 스트림 활용해서 문제를 풀어보려고 하였습니다. 해당 문제에선 스트림을 비중있게 쓴 편은 아니지만, 일단 공부하는 느낌으로 사용을 하였음.
해당 문제는 해시맵으로 사용해서 하는 것이 훨씬 나은것 같기도 함.
*
*
*
* 정확성  테스트
테스트 1 〉	통과 (1.04ms, 73.3MB)
테스트 2 〉	통과 (1.18ms, 74.1MB)
테스트 3 〉	통과 (4.36ms, 85.6MB)
테스트 4 〉	통과 (5.32ms, 80.3MB)
테스트 5 〉	통과 (4.54ms, 78.1MB)
테스트 6 〉	통과 (1.23ms, 73MB)
테스트 7 〉	통과 (1.03ms, 75.7MB)
효율성  테스트
테스트 1 〉	통과 (148.42ms, 82.7MB)
테스트 2 〉	통과 (192.33ms, 89.7MB)
테스트 3 〉	통과 (244.42ms, 94.2MB)
테스트 4 〉	통과 (197.35ms, 95.9MB)
테스트 5 〉	통과 (282.40ms, 95.1MB)
*
*
* */

import java.util.*;

public class Solution_완주하지못한선수 {

    public static List<String> playerList = new ArrayList<>();
    public static List<String> completedList = new ArrayList<>();

    public static String solution(String[] participant, String[] completion) {
        String answer="";
        playerInfo(participant, completion);

        Collections.sort(playerList);
        Collections.sort(completedList);

        for(int i=0;i<completedList.size();i++){
            if(!completedList.get(i).equals(playerList.get(i))){
                answer = playerList.get(i);
                break;
            }
        }

        if(answer.equals("")){
            answer = playerList.get(playerList.size()-1);
        }

        return answer;
    }

    public static void playerInfo(String[] participant, String[] completion) {
        Arrays.stream(participant).forEach(player -> {
            playerList.add(player);
        });

        Arrays.stream(completion).forEach(completed -> {
            completedList.add(completed);
        });
    }

    public static void main(String[] args) {

        String temp = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        //2 String temp = solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"});
        //3 String temp = solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"});


    }
}
