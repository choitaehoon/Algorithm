package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 다트게임다시풀기 {
    public static void main(String[] args) {
        System.out.println(solution("10S2D*3T"));
    }

    public static int solution(String dartResult) {
        int dartResultLength = dartResult.length();
        List<Integer> list = new ArrayList<>();
        int index = 0;

        StringBuilder builder = new StringBuilder();
        int value = 0;
        for (int i=0; i<dartResultLength; ++i) {
            //숫자인지 확인
            if (numberCheck(dartResult.charAt(i))){
                builder.append(dartResult.charAt(i));
                //그 뒤에것도 숫자인지
                if (numberCheck(dartResult.charAt(i+1))) {
                    builder.append(dartResult.charAt(i+1));
                    ++i;
                }
                value = Integer.parseInt(builder.toString());
                continue;
            }
            //보너스인지 체크
            else if (bonusCheck(dartResult.charAt(i))){
                value = bonusCalculation(dartResult.charAt(i), value);
            }
            //옵션인지 체크
            else if (optionCheck(dartResult.charAt(i))){
                value = optionCalculation(dartResult.charAt(i), list, index, value);
            }
            list.add(value);
            ++index;

        }
        return 1;
    }

    private static boolean numberCheck(char dartResult){
        return 48 <= dartResult && dartResult <= 57;
    }

    private static boolean bonusCheck(char dartResult){
        return dartResult == 'S' || dartResult == 'D' || dartResult == 'T';
    }

    private static int bonusCalculation(char dartResult, int value){
        if (dartResult == 'D')
            return (int)(Math.pow(value,2));
        else
            return (int)(Math.pow(value,3));
    }

    private static boolean optionCheck(char dartResult) {
        return dartResult == '*' || dartResult == '#';
    }

    private static int optionCalculation(char dartResult, List<Integer> list, int index, int value) {
        if (dartResult == '*' && list.size() > 0){
            list.add(index-2, list.remove(index-1)*2);
            return value * 2;
        }
        else
            return value * -1;
    }

}
