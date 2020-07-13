package kakao;

import java.util.*;

@SuppressWarnings("all")
public class 수식최대화 {

    static boolean[] isCheck;
    static char[] modification;
    static int modificationLen;

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
//        System.out.println(solution("50*6-3*2"));
    }

    public static long solution(String expression) {
        int len = expression.length();
        List<Integer> numberExpression = new ArrayList<>();
        List<Character> totalModification = new ArrayList<>();
        Set<Character> duplicateModification = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            char nowExpress = expression.charAt(i);
            if ('0' <= nowExpress && nowExpress <= '9') {
                builder.append(nowExpress);
            } else {
                totalModification.add(nowExpress);
                duplicateModification.add(nowExpress);
                numberExpression.add(Integer.parseInt(builder.toString()));
                builder.setLength(0);
            }

            if (i == len - 1) {
                numberExpression.add(Integer.parseInt(builder.toString()));
                builder.setLength(0);
            }

        }

        modificationLen = duplicateModification.size();
        isCheck = new boolean[modificationLen];
        modification = new char[modificationLen];
        modificationInsert(duplicateModification);

        changeModification(0, "");

        long answer = 0;
        return answer;
    }

    private static void modificationInsert(Set<Character> duplicateModification) {
        Iterator<Character> storeModification = duplicateModification.iterator();
        int index = 0;
        while (storeModification.hasNext()) {
            modification[index++] = storeModification.next();
        }
    }

    private static void changeModification(int index, String text) {
        if (index == modificationLen) {
            calculateNumber(text);
            return;
        }

        for (int i = 0; i < modificationLen; ++i) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                changeModification(index + 1, text+modification[i]);
                isCheck[i] = false;
            }
        }

    }

    private static void calculateNumber(String text) {

    }

}
