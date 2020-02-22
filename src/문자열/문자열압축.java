package 문자열;

public class 문자열압축 {

    static StringBuilder builder = new StringBuilder();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution("aaaaaa"));
    }

    public static int solution(String s) {
        for (int i=2; i<=s.length()/2; ++i) {
            String word = s.substring(0, i);
            actionWord(i, s, word);
            min = Math.min(min, builder.toString().length());
            System.out.println(builder);
            builder.setLength(0);
        }

        return 0;
    }

    private static void actionWord(int index, String s, String word) {
        int sum = 1;

        for (int i=index; i<s.length(); ) {
            String compare;
            if (i + index > s.length())
                compare = s.substring(i);
            else
                compare = s.substring(i, i + index);

            //problem
            if (!word.equals(compare)) {
                if (sum == 1)
                    builder.append(word);
                else if (sum > 1){
                    builder.append(sum).append(word);
                    sum = 1;
                }

                word = compare;

            } else {
                ++sum;

            }

            boundaryCheck(i, sum ,compare, word, s, index);

            i += index;
        }
    }

    private static void boundaryCheck(int index, int sum ,String compare, String word, String s, int divideWord) {
        if (index >= s.length() - 1) {
            if (compare.equals(word)) {
                builder.append(sum).append(word);
            } else {
                if (sum == 1)
                    builder.append(word).append(compare);
                else
                    builder.append(sum).append(word).append(compare);
            }
        }
    }

}
