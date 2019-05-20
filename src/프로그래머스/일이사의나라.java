package 프로그래머스;

public class 일이사의나라 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        int[] array = {4,1,2};
        int rest;
        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            rest = n % 3;
            n = n/ 3;

            if (rest == 0)
                n -= 1;

            builder.append(array[rest]);
        }
        return builder.reverse().toString();
    }
}
