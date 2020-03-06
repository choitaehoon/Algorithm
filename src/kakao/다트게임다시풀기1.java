package kakao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 다트게임다시풀기1 {

    public static void main(String[] args) {
        System.out.println(solution("10S2D*3T"));
    }

    public static int solution(String dartResult) {

        List<Integer> numberStore = Stream.of(dartResult)
                .flatMap(word -> Arrays.stream(word.split("[#*a-zA-Z]")))
                .filter(word -> !word.equals(""))
                .map(Integer::new)
                .collect(Collectors.toList());

         List<String> alphabetStore = Stream.of(dartResult)
                .flatMap(word -> Arrays.stream(word.split("[0-9]")))
                .filter(word -> !word.equals(""))
                .collect(Collectors.toList());

        int index = 0;
        int[] array = new int[3];

        for (int i=0; i<3; ++i) {
            int number = numberStore.get(i);
            String alphabetAnd = alphabetStore.get(i);

            for (int j=0; j<alphabetAnd.length(); ++j) {
                if (alphabetAnd.charAt(j) == 'D')
                    number = (int)Math.pow(number, 2);
                else if (alphabetAnd.charAt(j) == 'T')
                    number = (int)Math.pow(number, 3);

                if (j == 1) {
                    if (alphabetAnd.charAt(j) == '*' && index == 0)
                        number *= 2;
                    else if (alphabetAnd.charAt(j) == '*' && index > 0) {
                        array[index - 1] *= 2;
                        number *= 2;
                    } else
                        number *= -1;
                }
            }

            array[index++] = number;
        }

        return Arrays.stream(array).sum();
    }

}
