package 깊이너비우선탐색;

public class 타겟넘버 {

    static int targetNumber;
    static int sumTarget;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int targets = 3;
        System.out.println(solution(numbers,targets));
    }

    public static int solution(int[] numbers, int target) {

        targetNumber = target;
        checkSum(numbers,0,0);
        return sumTarget;
    }

    public static void checkSum (int[] numbers, int index , int sum) {
        if (sum == targetNumber && numbers.length <= index) {
            ++sumTarget;
            return ;
        }
        else if (sum != targetNumber &&numbers.length <= index)
            return;
        else {
            checkSum(numbers, index+1,  sum + numbers[index]);
            checkSum(numbers,index+1, sum - numbers[index] );
        }

    }
}
