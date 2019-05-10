package study.중급;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    시간 복잡도 O(n) -> n번만 돌면 되니까 / 변수 int -> 천만 까지 니까
 */

@SuppressWarnings("Duplicates")
public class 숫자카드HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer,Integer> compare = new HashMap<>();

        StringTokenizer token1 = new StringTokenizer(buffer.readLine());
        for (int i=0; i<givenNumber; ++i) {
            int number = Integer.parseInt(token1.nextToken());
            map.putIfAbsent(number, 1);
        }

        int compareCard = Integer.parseInt(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());
        for (int i=0; i<compareCard; ++i) {
            int number = Integer.parseInt(token2.nextToken());
            writer.write(map.get(number) == null ? "0"+" " : "1"+" ");
        }

        writer.close();
    }
}
