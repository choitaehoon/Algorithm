package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//스택으로 다시 풀기
public class Calculator2 {

    public static void main(String[] args) {
        System.out.println(calculate(
                "3+2*2"
        ));
    }

    public static int calculate(String s) {
        List<Integer> numberS = divideNumber(s);
        List<String> arithmetic = divideArithmetic(s);

            //* / 먼저 처리 하기
            for (int i = 0; i < arithmetic.size(); ++i) {
                String nowArithmetic = arithmetic.get(i);

                if (nowArithmetic.equals("*")) {
                    int nowNumber = numberS.remove(i);
                    int nextNumber = numberS.remove(i);

                    arithmetic.remove(i);
                    numberS.add(i--, nowNumber * nextNumber);
                } else if (nowArithmetic.equals("/")) {
                    int nowNumber = numberS.remove(i);
                    int nextNumber = numberS.remove(i);

                    arithmetic.remove(i);
                    numberS.add(i--, nowNumber / nextNumber);
                }

            }

            for (int i = 0; i < arithmetic.size(); ++i) {
                String nowArithmetic = arithmetic.get(i);

                if (nowArithmetic.equals("+")) {
                    int nowNumber = numberS.remove(i);
                    int nextNumber = numberS.remove(i);

                    arithmetic.remove(i);
                    numberS.add(i--, nowNumber + nextNumber);
                } else if (nowArithmetic.equals("-")) {
                    int nowNumber = numberS.remove(i);
                    int nextNumber = numberS.remove(i);

                    arithmetic.remove(i);
                    numberS.add(i--, nowNumber - nextNumber);
                }

            }

        return numberS.get(0);
    }

    private static List<Integer> divideNumber(String s) {
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s.replaceAll(" ", ""));

        while (matcher.find())
            numbers.add(Integer.parseInt(matcher.group()));

        return numbers;
    }

    private static List<String> divideArithmetic(String s) {
        List<String> arithmetic = new ArrayList<>();
        Pattern pattern = Pattern.compile("[*/+-]+");
        Matcher matcher = pattern.matcher(s.replaceAll(" ", ""));

        while (matcher.find())
            arithmetic.add(matcher.group());

        return arithmetic;
    }
}
