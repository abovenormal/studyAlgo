package programmers;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_달리기경주 {

    public static HashMap<String, Integer> playerInfo = new HashMap<>();

    public static String[] solution(String[] players, String[] callings) {
        makeInfo(players);

        Arrays.stream(callings).forEach(player -> {
                    int idx = playerInfo.get(player);
                    String frontPlayer = players[idx-1];
                    players[idx] = frontPlayer;
                    players[idx-1] = player;

                    playerInfo.put(frontPlayer,idx);
                    playerInfo.put(player,idx-1);
                }

        );

        return players;
    }

    public static void makeInfo(String[] players) {
        IntStream.range(0, players.length).forEach(index -> {
                    playerInfo.put(players[index], index);
                }
        );
    }


    public static void main(String[] args) {

        solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
    }
}
