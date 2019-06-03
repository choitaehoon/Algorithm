package study.프로그래머스;

public class 점프와순간이동 {
    public static void main(String[] args) {
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int count = 0;

        while (n != 0) {
            if (n == 1) {
                count++;
                n--;
                continue;
            }

            if (n % 2 == 0)
                n /= 2;
            else {
                count++;
                n--;
            }
        }
        return count;
    }
}
