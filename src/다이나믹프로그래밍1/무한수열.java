package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열 {

    public static long givenNumber, divideFirst, divideSecond;
    public static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        givenNumber = Long.parseLong(token.nextToken());
        divideFirst = Long.parseLong(token.nextToken());
        divideSecond = Long.parseLong(token.nextToken());

        System.out.println(divideFisrtAndSecond(givenNumber));
    }

    public static long divideFisrtAndSecond(long givenNumber) {
        if (givenNumber == 0)
            return 1;
        else if (map.containsKey(givenNumber))
            return map.get(givenNumber);
        else {
            map.put(givenNumber, divideFisrtAndSecond(givenNumber/divideFirst) + divideFisrtAndSecond(givenNumber/divideSecond));
            return map.get(givenNumber);
        }
    }

}
