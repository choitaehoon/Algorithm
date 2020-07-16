package kakao;

import java.util.*;

@SuppressWarnings("all")
public class 수식최대화 {

    static boolean[] isCheck;
    static char[] modification;
    static int modificationLen;
    static List<Long> numberExpressionOriginal;
    static List<String> totalModificationOriginal;
    static List<Long> numberExpressionReproduction;
    static List<String> totalModificationReproduction;
    static Set<Character> duplicateModification;
    static long result = 0;

    public static void main(String[] args) {
//        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }

    public static long solution(String expression) {
        int len = expression.length();
        numberExpressionOriginal = new ArrayList<>();
        totalModificationOriginal = new ArrayList<>();
        duplicateModification = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            char nowExpress = expression.charAt(i);
            if ('0' <= nowExpress && nowExpress <= '9') {
                builder.append(nowExpress);
            } else {
                totalModificationOriginal.add(String.valueOf(nowExpress));
                duplicateModification.add(nowExpress);
                numberExpressionOriginal.add(Long.parseLong(builder.toString()));
                builder.setLength(0);
            }

            if (i == len - 1) {
                numberExpressionOriginal.add(Long.parseLong(builder.toString()));
                builder.setLength(0);
            }

        }

        modificationLen = duplicateModification.size();
        isCheck = new boolean[modificationLen];
        modification = new char[modificationLen];
        modificationInsert(duplicateModification);

        changeModification(0, "");

        return result;
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
            numberExpressionReproduction = originalCopy();
            totalModificationReproduction = originalCopyModificate();
            calculateNumber(text);

            numberExpressionReproduction.clear();
            totalModificationReproduction.clear();
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

    private static List<String> originalCopyModificate() {
        List<String> storeReproduction = new ArrayList<>();

        for (int i = 0; i < totalModificationOriginal.size(); ++i)
            storeReproduction.add(totalModificationOriginal.get(i));

        return storeReproduction;
    }

    private static List<Long> originalCopy() {
        List<Long> storeReproduction = new ArrayList<>();

        for (int i = 0; i < numberExpressionOriginal.size(); ++i)
            storeReproduction.add(numberExpressionOriginal.get(i));

        return storeReproduction;
    }

    private static void calculateNumber(String text) {

        String[] arithmeticArray = text.split("");
        int len = arithmeticArray.length;

        for (int i = 0; i < len; ++i) {
            String nowArithmetic = arithmeticArray[i];

            for (int k = 0; k < totalModificationReproduction.size(); ++k) {
                if (totalModificationReproduction.get(k).equals(nowArithmetic)) {
                    long nowNumber = numberExpressionReproduction.get(k);
                    long nextNumber = numberExpressionReproduction.get(k + 1);

                    if (nowArithmetic.equals("*")) {
                        numberMultiple(nowNumber, nextNumber, k);
                        k--;
                    } else if (nowArithmetic.equals("+")) {
                        numberPlus(nowNumber, nextNumber, k);
                        k--;
                    } else if (nowArithmetic.equals("-")) {
                        numberMinus(nowNumber, nextNumber, k);
                        k--;
                    }
                }

            }

            if (numberExpressionReproduction.size() == 1) {
                result = Math.max(Math.abs(numberExpressionReproduction.get(0)), result);
                return;
            }
        }

    }

    private static void numberMinus(long nowNumber, long nextNumber, int k) {
        long minusNumber = nowNumber - nextNumber;
        numberAndModificateInsertAndDelete(k, minusNumber);
    }

    private static void numberPlus(long nowNumber, long nextNumber, int k) {
        long plusNumer = nowNumber + nextNumber;
        numberAndModificateInsertAndDelete(k, plusNumer);
    }

    private static void numberMultiple(long nowNumber, long nextNumber, int k) {
        long multipleNumber = nowNumber * nextNumber;
        numberAndModificateInsertAndDelete(k, multipleNumber);
    }

    private static void numberAndModificateInsertAndDelete(int k, long number) {
        numberExpressionReproduction.remove(k);
        numberExpressionReproduction.remove(k);
        numberExpressionReproduction.add(k, number);
        totalModificationReproduction.remove(k);
    }

}
