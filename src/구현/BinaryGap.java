package 구현;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

    public static int solution(int N) {
        int maxZeroCount = 0;
        int zeroCount = 0;
        String binaryNumber = Integer.toBinaryString(N);
        int len = binaryNumber.length();

        for (int i = 1; i < len; ++i) {
            if (binaryNumber.charAt(i) == '0') {
                ++zeroCount;
            } else {
                if (zeroCount != 0) {
                    maxZeroCount = Math.max(maxZeroCount, zeroCount);
                }

                zeroCount = 0;
            }
        }

        return maxZeroCount;

    }

}
