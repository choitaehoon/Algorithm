package kakao;

import java.util.Arrays;

public class 다트게임다시풀기 {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }

    public static int solution(String dartResult) {
        StringBuilder builder = new StringBuilder();
        int[] array = new int[3];
        int index = 0;

        for (int i=0; i<dartResult.length(); ++i) {
            if (Character.isDigit(dartResult.charAt(i))) {
                builder.append(dartResult.charAt(i));
            }
            else if (dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T'){
                int temp = Integer.parseInt(builder.toString());

                if (dartResult.charAt(i) == 'S')
                    array[index] = temp;
                else if (dartResult.charAt(i) == 'D')
                    array[index] = (int)Math.pow(temp, 2);
                else
                    array[index] = (int)Math.pow(temp, 3);

                if (i + 1 < dartResult.length() && !(dartResult.charAt(i+1) == '*' || dartResult.charAt(i+1) == '#'))
                    ++index;

                builder.setLength(0);
            } else {
                if (dartResult.charAt(i) == '*' && index == 0)
                    array[index] *= 2;
                else if (dartResult.charAt(i) == '*' && index > 0) {
                    array[index-1] *= 2;
                    array[index] *= 2;
                } else if (dartResult.charAt(i) == '#')
                    array[index] *= -1;
                ++index;
            }

        }

        return Arrays.stream(array).sum();
    }

}
