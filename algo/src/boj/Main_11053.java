package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11053 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int maxVal = Integer.MIN_VALUE;

        String[] sarr = new String[len];
        int[] ans = new int[len];

        sarr = br.readLine().split(" ");
        Arrays.fill(ans,1);

        for(int i=1;i<len;i++){
            int curVal = Integer.parseInt(sarr[i]);
            for(int j=0;j<i;j++){
                int Val = Integer.parseInt(sarr[j]);

                if(curVal>Val)
                    ans[i] = Math.max(ans[i],ans[j]+1);
            }
        }

        for(int i=0;i<len;i++){
            maxVal = Math.max(maxVal,ans[i]);
        }

        System.out.println(maxVal);
    }
}
