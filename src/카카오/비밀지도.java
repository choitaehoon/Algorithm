package 카카오;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 비밀지도 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> list = new ArrayList<>();

        for (int i=0; i<n; ++i) {

            System.out.println(arr1[i] | arr2[i]);
            StringBuilder compare1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder compare2 = new StringBuilder(Integer.toBinaryString(arr2[i]));

            StringBuilder builder = new StringBuilder();

            while (compare1.length() != n)
                compare1.insert(0,"0");

            while (compare2.length() != n)
                compare2.insert(0,"0");

            for (int j=0; j<n; ++j) {
                if (compare1.toString().charAt(j) == '0' && compare2.toString().charAt(j) == '0') {
                    builder.append(" ");
                    continue;
                }
                builder.append("#");
            }

            list.add(builder.toString());
        }

        String[] answer = new String[list.size()];

        for (int i=0; i<list.size(); ++i)
            answer[i] = list.get(i);

        return answer;
    }

}
