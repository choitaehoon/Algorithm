package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SnakeBird {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());

        int fruitCount = Integer.parseInt(token1.nextToken());
        int snakeBird = Integer.parseInt(token1.nextToken());

        List<Integer> fruit = new ArrayList<>();
        for (int i = 0; i < fruitCount; ++i) {
            fruit.add(Integer.parseInt(token2.nextToken()));
        }

        System.out.println(getMaxSnakeBirdSize(snakeBird, fruit));
    }

    private static int getMaxSnakeBirdSize(int snakeBird, List<Integer> fruit) {
        int result = snakeBird;
        fruit.sort(Comparator.comparingInt(fruitHeight -> fruitHeight));
        int fruitSize = fruit.size();

        for (int i = 0; i < fruitSize; ++i) {
            if (result >= fruit.get(i))
                ++result;
            else
                break;
        }

        return result;
    }

}
