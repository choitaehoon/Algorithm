package 수학;

public class 멀쩡한사각형 {

    public static void main(String[] args) {
        System.out.println(solution(
                8, 12
        ));
    }

    public static long solution(long w, long h) {
        long result;
        long GCD;
        if (w > h) {
            GCD = gcd(w, h);
        } else {
            GCD = gcd(h, w);
        }
        long emptySquare = w + h - GCD;
        result = w * h - emptySquare;
        return result;
    }

    public static long gcd(long big, long small) {
        if (big % small == 0) {
            return small;
        }
        return gcd(small, big % small);
    }
}
