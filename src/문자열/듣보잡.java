package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 듣보잡 {

    static Map<String, Integer> map = new TreeMap<>();
    static int givenNumber;

    public static void main(String[] args) throws IOException {
        inputGivenNumberAndMap();
        printMap();
    }

    private static void inputGivenNumberAndMap() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        givenNumber = Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken());

        for (int i=0; i<givenNumber; ++i) {
            String temp = buffer.readLine();
            map.put(temp, map.get(temp) == null ? 1 : map.get(temp) + 1);
        }
    }

    private static void printMap() {
        int sum = 0;
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            if (maps.getValue() > 1) {
                sum++;
                builder.append(maps.getKey()).append("\n");
            }
        }

        System.out.println(sum);
        System.out.print(builder);
    }

}
