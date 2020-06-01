package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호 {

    static int[] numberSet = new int[10];
    static int countNeedSet;
    static int SIX_CHECK = 6;
    static int NINE_CHECK = 9;
    static int ZERO_CHECK = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String givenNumber = buffer.readLine();
        int givenNumberLength = givenNumber.length();

        for (int i = 0; i < givenNumberLength; ++i) {
            int spaceNumber = Character.getNumericValue(givenNumber.charAt(i));

            if (spaceNumber == SIX_CHECK && numberSet[SIX_CHECK] == ZERO_CHECK) {
                spaceNumberSixCheck(spaceNumber);
            } else if (spaceNumber == NINE_CHECK && numberSet[NINE_CHECK] == ZERO_CHECK) {
                spaceNumberNineCheck(spaceNumber);
            } else {
                spaceNumberRemainder(spaceNumber);
            }
        }

        System.out.println(countNeedSet);
    }

    public static void chargeNumberSet() {
        for (int i = 0; i < 10; ++i) {
            numberSet[i]++;
        }
    }

    public static void spaceNumberSixCheck(int spaceNumber) {
        if (numberSet[NINE_CHECK] > ZERO_CHECK)
            numberSet[NINE_CHECK]--;
        else {
            countNeedSet++;
            chargeNumberSet();
            numberSet[SIX_CHECK]--;
        }
    }

    public static void spaceNumberNineCheck(int spaceNumber) {
        if (numberSet[SIX_CHECK] > ZERO_CHECK)
            numberSet[SIX_CHECK]--;
        else {
            countNeedSet++;
            chargeNumberSet();
            numberSet[NINE_CHECK]--;
        }

    }

    public static void spaceNumberRemainder(int spaceNumber) {
        if (numberSet[spaceNumber] > ZERO_CHECK)
            numberSet[spaceNumber]--;
        else {
            countNeedSet++;
            chargeNumberSet();
            numberSet[spaceNumber]--;
        }
    }
}

