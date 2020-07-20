package kakao.blind2020;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution(
                "aabbaccc"
        ));
    }

    public static int solution(String s) {

        if (s.length() == 1)
            return 1;

        int len = s.length() / 2;
        int answer = s.length();

        for (int i = 1; i <= len; ++i) {
            int number = 1;
            StringBuilder word = new StringBuilder();
            String now = "";
            String next = "";

            for (int k = 0; k <= s.length() / i; ++k) {
                int start  = i * k;
                int end = Math.min(start + i, s.length());

                now = next;
                next = s.substring(start, end);

                if (now.equals(next)) {
                    ++number;
                } else {
                    word.append(number == 1 ? "" : number).append(now);
                    number = 1;
                }

            }

            word.append(number == 1 ? "" : number).append(next);
            answer = Math.min(answer, word.length());
        }

        return answer;
    }
}
