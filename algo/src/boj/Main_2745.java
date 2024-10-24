import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        double ans = 0;

        char[] cArr = num.toCharArray();

        int cnt = 0;
        if (n > 10) {
            for (int i = cArr.length - 1; i >= 0; i--) {
                char temp = cArr[i];
                if (((int) temp - '0') > 10) {
                   //System.out.println((temp - 'A') * Math.pow(n, cnt));
                    ans += (temp - 'A'+10) * Math.pow(n, cnt);
                } else {
                    //System.out.println((temp - '0') * Math.pow(n, cnt));
                    ans += (temp - '0') * Math.pow(n, cnt);
                }
                cnt++;
            }
        } else {
            for (int i = cArr.length - 1; i >= 0; i--) {
                char temp = cArr[i];
                //System.out.println((temp - '0') * Math.pow(n, cnt));
                ans += (temp - '0') * Math.pow(n, cnt);
                cnt++;
            }
        }

        System.out.println((int)ans);


    }
}