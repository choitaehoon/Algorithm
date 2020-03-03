package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map;

public class 다트게임1 {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
//        System.out.println(solution("1D2S#10S"));
//        System.out.println(solution("1D2S0T"));
//        System.out.println(solution("1D#2S*3S"));
//        System.out.println(solution("1S*2T*3S"));
//        System.out.println(solution("1T2D3D#"));
        }

    public static int solution(String dartResult) {

        String[] dartResultNumber = dartResult.split("[SDT*#]");
        String[] dartResultSDT = dartResult.split("[0-9]");

        List<Integer> dartNumber = new ArrayList<>();
        List<String> dartBonusWithOption = new ArrayList<>();

        for (String value : dartResultNumber) {
            if (!value.equals("")) {
                dartNumber.add(Integer.parseInt(value));
            }
        }

        for (String s : dartResultSDT) {
            if (!s.equals("")) {
                dartBonusWithOption.add(s);
            }
        }

        int[] sumArray = new int[3];
        for (int i=0; i<3; ++i) {
            int sum = 0;

            int num = dartNumber.get(i);
            String bounceWithOption = dartBonusWithOption.get(i);

            for (int j=0; j<bounceWithOption.length(); ++j) {
                if (j == 0) {
                    if (bounceWithOption.charAt(j) == 'S'){
                        sum = num;
                    }
                    else if (bounceWithOption.charAt(j) == 'D'){
                        sum = (int)Math.pow(num, 2);
                    } else if (bounceWithOption.charAt(j) == 'T'){
                        sum = (int)Math.pow(num, 3);
                    }
                }

                else {
                    if (bounceWithOption.charAt(j) == '*') {
                        if (i > 0) {
                            sumArray[i-1] *= 2;
                        }
                        sum *= 2;
                    } else {
                        sum *= -1;
                    }
                }
            }

            sumArray[i] = sum;
        }


       int answer = 0;
       for (int i=0; i<3; ++i)
           answer += sumArray[i];

        return answer;
    }

}
