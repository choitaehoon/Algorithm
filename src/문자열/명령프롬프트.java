package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령프롬프트 {

    static int givenNumber;
    static char[][] array;
    static int vertical;

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        printAlphabet();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        inputArray(buffer);
    }

    private static void inputArray(BufferedReader buffer) throws IOException {
        for (int i=0; i<givenNumber; ++i) {
            String example = buffer.readLine();

            if (array == null) {
                vertical = example.length();
                array = new char[givenNumber][vertical];
            }

            for (int j=0; j<example.length(); ++j) {
                array[i][j] = example.charAt(j);
            }
        }
    }

    private static void printAlphabet() {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<vertical; ++i) {
            char temp = array[0][i];
            boolean check = false;

            for (int j=1; j<givenNumber; ++j) {
                if (temp != array[j][i]) {
                    check = true;
                    break;
                }
            }

            if (check) {
                builder.append("?");
            } else {
                builder.append(temp);
            }
        }

        System.out.println(builder);
    }

}
