package kakao;

public class 문자열압축1 {

    public static void main(String[] args) {
        System.out.println(solution(
                "aabbaccc"
        ));
    }

    public static int solution(String s) {

        if (s.length() == 1)
            return 1;

        int result = 1000;

        for (int i=1; i<=s.length()/2; ++i) {
            String nowS = "";
            String nextS = "";
            StringBuilder builder = new StringBuilder();
            int correctS = 1;

            for (int z = 0; z <= s.length() / i; ++z) {
                int start = i * z;
                int end = Math.min(start + i, s.length());
                nowS = nextS;
                nextS = s.substring(start, end);

                if (nowS.equals(nextS)) {
                    ++correctS;
                } else {
                    builder.append(correctS == 1 ? "" : correctS).append(nowS);
                    correctS = 1;
                }
            }

            builder.append(correctS == 1 ? "" : correctS).append(nextS);

            result = Math.min(result, builder.length());
        }

        return result;
    }


}
