package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 화살표그리기1 {

    static List<Point> storeDot = new ArrayList<>();
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int location = Integer.parseInt(token.nextToken());
            int color = Integer.parseInt(token.nextToken());

            storeDot.add(new Point(location, color));
        }

        System.out.println(solution());
    }

    private static int solution() {
        storeDot.sort((a1, a2) -> {
            int r = a1.color - a2.color;
            if (r != 0) return r;

            return a1.location - a2.location;
        });

        int len = storeDot.size();

        for (int i = 0; i < len; ++i) {
            Point nowPoint = storeDot.get(i);
            if (i == 0) {
                Point nextPoint = storeDot.get(i + 1);
                if (nowPoint.color == nextPoint.color)
                    calculateSum(nextPoint.location, nowPoint.location);
            } else if (i == len - 1){
                Point prePoint = storeDot.get(i - 1);
                if (prePoint.color == nowPoint.color)
                    calculateSum(nowPoint.location, prePoint.location);
            } else {
                Point nextPoint = storeDot.get(i + 1);
                Point prePoint = storeDot.get(i - 1);

                boolean isPreColorCheck = false;
                boolean isNextColorCheck = false;

                if (nowPoint.color == prePoint.color)
                    isPreColorCheck = true;
                if (nowPoint.color == nextPoint.color)
                    isNextColorCheck = true;

                if (isPreColorCheck && isNextColorCheck) {
                    int compareOne = nowPoint.location - prePoint.location;
                    int compareTwo = nextPoint.location - nowPoint.location;
                    sum += Math.min(compareOne, compareTwo);
                } else if (isPreColorCheck) {
                    calculateSum(nowPoint.location, prePoint.location);
                } else if (isNextColorCheck) {
                    calculateSum(nextPoint.location, nowPoint.location);
                }

            }
        }

        return sum;
    }

    private static void calculateSum(int nextLocation, int preLocation) {
        sum += nextLocation - preLocation;
    }

}

class Point {

    int location;
    int color;

    public Point(int location, int color) {
        this.location = location;
        this.color = color;
    }

}
