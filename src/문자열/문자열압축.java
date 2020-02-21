package 문자열;

public class 문자열압축 {

    static StringBuilder builder = new StringBuilder();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        for (int i=1; i<=s.length()/2; ++i) {
            checkWord(i, s);
            min = Math.min(min, builder.toString().length());
            System.out.println(builder);
            builder.setLength(0);
        }

        return 0;
    }

    private static void checkWord(int index, String s) {
        String temp =  combinationWord(0, index, s);;
        int sum = 1;

        for (int j=0 ; j<s.length(); ) {
            j += index;
            String compare = combinationWord(j, index, s);

            //같으면
            if (temp.equals(compare)) {
                ++sum;
                if (s.length() -1 <= j)
                    builder.append(sum).append(temp).append(compare);
            } else {

                if (sum == 1) {
                    builder.append(temp).append(compare);
                } else {
                    builder.append(sum).append(temp);
                }

                temp = compare;
                sum = 1;
            }

        }
    }

    private static String combinationWord(int j, int index, String s){
        String temp = "";

        if (j + index > s.length()) {
            temp = s.substring(j);
        }
        else
            temp = s.substring(j, j+index);

        return temp;
    }

}
