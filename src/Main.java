public class Main {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<n; ++i) {
            if (i % 2 == 0) {
                builder.append("수");
                continue;
            }
            builder.append("박");
        }
        return builder.toString();
    }
}