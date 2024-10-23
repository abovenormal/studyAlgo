import java.io.*;
import java.util.*;

public class Main {
    static Character[] alpha = new Character[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Character temp = 'A';
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char) (temp + i);
        }

        long inputL = Long.parseLong(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Character> list = new ArrayList<>();

        while (inputL != 0) {
            int rest = (int) inputL % x;
            inputL /= x;
            if (rest < 10) list.add((char) (rest+'0'));
            else list.add(alpha[rest - 10]);
        }

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i));
        }

    }
}