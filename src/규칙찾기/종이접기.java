package 규칙찾기;

import java.util.Arrays;

public class 종이접기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                6
        )));
    }

    public static int[] solution(int n) {

        int[] newInt = new int[(int)Math.pow(2, 20)];
//        0,0,1,0,0,1,1

        newInt[0] = 0; newInt[1] = 0; newInt[2] = 1;
        newInt[3] = 0; newInt[4] = 0; newInt[5] = 1; newInt[6] = 1;

        int len = (int)(Math.pow(2, n));
        int[] answer = new int[len];

        if (n <= 3) {
            for (int i=0; i<len; ++i) {
                answer[i] = newInt[i];
            }
        } else {

        }

        return answer;
    }

}
