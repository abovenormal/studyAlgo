package programmers;

public class Solution_성격유형검사 {

    public String solution(String[] survey, int[] choices) {

        int R=0;
        int T=0;
        int C=0;
        int F=0;
        int J=0;
        int M=0;
        int A=0;
        int N=0;

        String answer = "";

        for (int i = 0; i < survey.length; i++) {
            String check = survey[i];
            int ans = choices[i];
            ans -= 4;

            String word[] = check.split("");

            if (ans > 0) {      // 동의 일때
                switch (word[1]) {
                    case "R":
                        R += ans;
                        break;
                    case "T":
                        T += ans;
                        break;
                    case "C":
                        C += ans;
                        break;
                    case "F":
                        F += ans;
                        break;
                    case "J":
                        J += ans;
                        break;
                    case "M":
                        M += ans;
                        break;
                    case "A":
                        A += ans;
                        break;
                    case "N":
                        N += ans;
                        break;
                }
            } else {           // 비동의 일때
                ans = ans * (-1);
                switch (word[0]) {
                    case "R":
                        R += ans;
                        break;
                    case "T":
                        T += ans;
                        break;
                    case "C":
                        C += ans;
                        break;
                    case "F":
                        F += ans;
                        break;
                    case "J":
                        J += ans;
                        break;
                    case "M":
                        M += ans;
                        break;
                    case "A":
                        A += ans;
                        break;
                    case "N":
                        N += ans;
                        break;
                }
            }
        }

        for(int i=0;i<4;i++){

            switch (i){
                case 0:
                    if(R>=T)
                        answer+="R";
                    else
                        answer+="T";
                    break;
                case 1:
                    if(C>=F)
                        answer+="C";
                    else
                        answer+="F";
                    break;
                case 2:
                    if(J>=M)
                        answer+="J";
                    else
                        answer+="M";
                    break;
                case 3:
                    if(A>=N)
                        answer+="A";
                    else
                        answer+="N";
                    break;

            }
        }

        return answer;
    }
}
