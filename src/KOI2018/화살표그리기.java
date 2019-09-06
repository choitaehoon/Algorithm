package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

@SuppressWarnings("Duplicates")
public class 화살표그리기 {

    private static List<Pointer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int point = Integer.parseInt(token.nextToken());
            int color = Integer.parseInt(token.nextToken());

            list.add(new Pointer(point,color));
        }

        Collections.sort(list);

        int size = list.size();
        int sum = 0;

        for (int i=0; i<size; ++i) {
            int min = Integer.MAX_VALUE;

            for (int j=0; j<size; ++j) {
                int store = Math.abs(list.get(i).x - list.get(j).x);
                if (i != j &&  list.get(i).y == list.get(j).y && min > store ) {
                    min = store;
                }
            }

            if (min == Integer.MAX_VALUE)
                continue;
            sum += min;
        }

        System.out.println(sum);
    }
}