package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    static List<Location> one = new ArrayList<>();
    static List<Location> two = new ArrayList<>();
    static int[][] sum;
    static List<Circle> operation = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int chicken = Integer.parseInt(tokenizer.nextToken());
        int[][] array = new int[n][n];
        sum = new int[n][n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int k = 0; k < n; ++k)
                array[i][k] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < n; ++i)
            for (int k = 0; k < n; ++k) {
                if (array[i][k] == 1)
                    one.add(new Location(i, k));
                else if (array[i][k] == 2)
                    two.add(new Location(i, k));
            }

        solution();
        storeChickenOperation(n);
        operation.sort((a1, a2) -> a2.count - a1.count);

        for (int i = 0; i < operation.size(); ++i)
            System.out.println(operation.get(i).x +" "+operation.get(i).y);

        int result = 0;
        for (int i = 0; i < one.size(); ++i) {
            int x = one.get(i).x;
            int y = one.get(i).y;
            int sum = Integer.MAX_VALUE;

            for (int k = 0; k < chicken; ++k) {
                Circle circle = operation.get(k);
                sum = Math.min(sum, Math.abs(circle.x - x) + Math.abs(circle.y - y));
            }

            result += sum;
        }

        System.out.println(result);
    }

    private static void storeChickenOperation(int n) {
        for (int i = 0; i < n; ++i)
            for (int k = 0; k < n; ++k)
                if (sum[i][k] != 0)
                    operation.add(new Circle(i, k, sum[i][k]));

    }

    private static void solution() {
        for (int i = 0; i < one.size(); ++i) {
            int minX = 0;
            int minY = 0;
            int value = Integer.MAX_VALUE;
            Location location = one.get(i);

            for (int k = 0; k < two.size(); ++k) {
                Location twoLocation = two.get(k);
                int twoX = twoLocation.x;
                int twoY = twoLocation.y;
                int nowValue = Math.abs(twoX - location.x) + Math.abs(twoY - location.y);

                if (value > nowValue) {
                    minX = twoX;
                    minY = twoY;
                    value = nowValue;
                }
            }

            sum[minX][minY]++;
        }
    }

}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Circle {
    int x;
    int y;
    int count;

    public Circle(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}
