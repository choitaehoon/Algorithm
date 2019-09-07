import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        System.out.println(calculate(givenNumber));
    }


    private static long calculate(int givenNumber) {
        long value = 0;
        StringBuilder builder = new StringBuilder();

        for (int i=1; i<=givenNumber; ++i) {
            builder.append(i);

            if (i % 10000 == 0 || i == givenNumber) {
                value += builder.length();
                builder.setLength(0);
            }
        }

        return value;
    }

}
