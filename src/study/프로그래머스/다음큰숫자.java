package study.프로그래머스;

public class 다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int standardOneCount = count(n);
        int changeOneCount = 0;

        while (true) {
            changeOneCount = count(++n);
            if (standardOneCount == changeOneCount)
                break;
        }

        return n;
    }

    private static int count(int n) {
        int count = 1;
        while (n != 1 && n != 0) {
            if (n % 2 == 1)
                ++count;

            n /= 2;
        }

        return count;
    }
}
