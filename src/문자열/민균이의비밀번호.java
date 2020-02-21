package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 민균이의비밀번호 {

    static int givenNumber;
    static Map<String, Integer> map = new HashMap<>();
    static String store;

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        actionGo();
        printGo();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            String temp = buffer.readLine();
            map.put(temp, map.get(temp) == null ? 1 : map.get(temp) + 1);
        }
    }

    private static void actionGo() {
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            StringBuilder builder = new StringBuilder(maps.getKey());
            if (map.get(builder.reverse().toString()) != null) {
                store = maps.getKey();
            }
        }
    }

    private static void printGo() {
        System.out.print(store.length()+" "+store.charAt(store.length()/2));
    }

}
