package 프로그래머스;

public class 피보나치수 {
    public static void main(String[] args) {
        System.out.println(solution(100000));
    }

    public static int solution(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;

        for (int i=2 ; i<=n; ++i)
            array[i] = (array[i-1] % 1234567) + (array[i-2] % 1234567);

        return array[n] % 1234567;
    }
}
