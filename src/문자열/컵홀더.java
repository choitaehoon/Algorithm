package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다시 풀기
public class 컵홀더 {

    public static void main(String[] args) throws IOException {
        inputGivenNumberAndKeyword();
    }

    private static void inputGivenNumberAndKeyword() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        String keyWord = buffer.readLine();

        if (givenNumber == 1) {
            System.out.println(1);
            return;
        }

        int sumL = 0;
        int sumS = 0;

        for (int i=0; i<keyWord.length(); ++i) {
            if (keyWord.charAt(i) == 'L')
                sumL++;
            else if (keyWord.charAt(i) == 'S')
                sumS++;
        }

        System.out.println(sumS + (sumL/2) + 1);
    }

}
