import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3{

    static int testCase, goal;
    static int cnt_0, cnt_1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        for(int i =0; i< testCase;i++) {
            cnt_0 = 0;
            cnt_1 = 0;
            goal = Integer.parseInt(br.readLine());

            dp(goal);

            System.out.println(cnt_0+" "+ cnt_1);

        }
    }

    public static int dp(int n){

        if(n==0){
            cnt_0++;
            return 0;
        }
        else if(n==1) {
            cnt_1++;
            return 1;
        }

        return dp(n-1)+ dp(n-2);
    }
}