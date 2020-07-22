package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 다트 {

    public static void main(String[] args) {
        System.out.println(solution(
                "1D#2S*3S"
        ));
    }

    public static int solution(String dartResult) {
        List<Integer> numberStore = new ArrayList<>();
        List<String> bonusOrOption = new ArrayList<>();

        String[] number = dartResult.split("[SDT*#]");
        for (String s : number) {
            if (!s.equals(""))
                numberStore.add(Integer.parseInt(s));
        }

        String[] bouns = dartResult.split("[0-9]");
        for (String s : bouns) {
            if (!s.equals(""))
                bonusOrOption.add(s);
        }

        return calculateNumber(numberStore, bonusOrOption);
    }

    private static int calculateNumber(List<Integer> numberStore, List<String> bonusOrOption) {
        int[] result = new int[3];

        for (int i = 0; i < 3; ++i) {
            int num = numberStore.get(i);
            String bonusOption = bonusOrOption.get(i);
            int bonusOptionLen = bonusOption.length();

            for (int k = 0; k < bonusOptionLen; ++k) {
                if (bonusOption.charAt(k) == 'D') {
                    num = (int)(Math.pow(num, 2));
                } else if (bonusOption.charAt(k) == 'T') {
                    num = (int)(Math.pow(num, 3));
                } else if (bonusOption.charAt(k) == '*') {
                    num *= 2;

                    if (i >= 1) {
                        result[i - 1] *= 2;
                    }

                } else if (bonusOption.charAt(k) == '#') {
                    num *= -1;
                }
            }

            result[i] = num;
        }

        return Arrays.stream(result).sum();
    }

}
