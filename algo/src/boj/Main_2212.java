import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_2212 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;

        int[] arr = new int[n];
        Integer[] diffArr = new Integer[n-1];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0;i<n-1;i++){
            diffArr[i] = arr[i+1]-arr[i];
        }

        Arrays.sort(diffArr, Collections.reverseOrder());

        for(int i=k-1;i<n-1;i++){
            sum += diffArr[i];
        }

        System.out.println(sum);

    }
}

