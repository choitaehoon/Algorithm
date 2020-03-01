package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진수변환 {

    static String[] givenOctalNumber;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        inputGivenOctalNumber();
        essenceChange();
    }

    private static void inputGivenOctalNumber() throws IOException{
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenOctalNumber = buffer.readLine().split("");
    }

    private static void essenceChange() {
        int index = 0;

        for (String store : givenOctalNumber) {
            StringBuilder changeStore = new StringBuilder(Integer.toBinaryString(Integer.parseInt(store)));
            int len = 3 - changeStore.length();

            if (index++ != 0)
                for (int i=0; i<len; ++i)
                    changeStore.insert(0, '0');

            builder.append(changeStore);
        }

        System.out.println(builder);
    }

}
