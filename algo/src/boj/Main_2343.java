package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2343 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lecN = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lecArr = new int[lecN];

        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;

        for(int i=0;i<lecN;i++){
            lecArr[i] = Integer.parseInt(st.nextToken());
            right += lecArr[i];
            left = Math.max(left,lecArr[i]);
        }

        while(left<=right){
            int mid = (left+right)/2;

            int cnt = getCnt(lecN, lecArr, mid);

            if(cnt>M){
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left);


    }

    public static int getCnt(int n , int[] arr , int mid){
        int sum = 0;
        int cnt = 0;

        for(int i=0; i<n; i++){
            if(sum + arr[i]>mid){
                sum = 0;
                cnt++;
            }
            sum+=arr[i];
        }

        if(sum!=0){
            cnt++;
        }
        return cnt;

    }

}
