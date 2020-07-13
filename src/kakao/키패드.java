package kakao;

import java.util.HashMap;
import java.util.Map;

public class 키패드 {

    public static void main(String[] args) {

    }

    public String solution(int[] numbers, String hand) {
        int len = numbers.length;
        Point leftHand = new Point(3, 0);
        Point rightHand = new Point(3, 2);
        Map<Integer, Point> numberLocation = insertNumberLocation();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                result.append("L");
                leftHand = numberLocation.get(numbers[i]);
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                result.append("R");
                rightHand = numberLocation.get(numbers[i]);
            } else {
                int leftDistance = distanceHand(leftHand, numberLocation.get(numbers[i]));
                int rightDistance = distanceHand(rightHand, numberLocation.get(numbers[i]));

                if (leftDistance < rightDistance) {
                    result.append("L");
                    leftHand = numberLocation.get(numbers[i]);
                } else if (leftDistance > rightDistance) {
                    result.append("R");
                    rightHand = numberLocation.get(numbers[i]);
                } else {
                    if (hand.equals("right")) {
                        result.append("R");
                        rightHand = numberLocation.get(numbers[i]);
                    } else {
                        result.append("L");
                        leftHand = numberLocation.get(numbers[i]);
                    }
                }
            }
        }

        return result.toString();
    }

    private int distanceHand(Point hand, Point point) {
        return Math.abs(hand.x - point.x) + Math.abs(hand.y - point.y);
    }

    private Map<Integer, Point> insertNumberLocation() {
        Map<Integer, Point> numberLocation = new HashMap<>();
        numberLocation.put(0, new Point(3, 1));
        int numberIndex = 1;

        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 3; ++k) {
                numberLocation.put(numberIndex++, new Point(i, k));
            }
        }

        return numberLocation;
    }

}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}