package study.프로그래머스;

public class 타켓넘버 {

    static int targetCount;
    static int targetNumber;
    static int arrayLength;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        targetNumber = target;
        arrayLength = numbers.length;

        recursive(numbers,0,0);

        return targetCount;
    }

    private static void recursive(int[] numbers, int index, int sum) {
        if (index == arrayLength && sum == targetNumber) {
            ++targetCount;
            return;
        }

        if (index >= arrayLength)
            return;

        recursive(numbers,index+1,sum+numbers[index]);
        recursive(numbers,index+1,sum-numbers[index]);
    }
}
