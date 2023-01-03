import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1965 {

    public static int input;
    public static String[] sarr;
    public static int[] arr;

    public static int[] boxTot;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = Integer.parseInt(br.readLine());

        sarr = new String[input];
        arr = new int[input];

        boxTot = new int[input];
        Arrays.fill(boxTot, 1);

        int ans = 0;
        sarr = br.readLine().split(" ");

        for(int i=0;i<input;i++){
            arr[i] = Integer.parseInt(sarr[i]);
        }


        for(int i=1; i<input; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    boxTot[i] = Math.max(boxTot[i], boxTot[j]+1);
                }
            }
            ans = Math.max(boxTot[i], ans);
        }

        System.out.println(ans);
    }
}
