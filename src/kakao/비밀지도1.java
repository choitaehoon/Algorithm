package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 비밀지도1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{0, 0, 0, 0, 0}, new int[]{30, 1, 21, 17, 28})));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i<n; ++i) {
            int temp = arr1[i] | arr2[i];
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(temp));
            int len = n - binary.length();

            for (int j=0; j < len; ++j) {
                binary.insert(0, "0");
            }

            System.out.println(binary);
            String store = "";
            for (int j=0; j<binary.length(); ++j) {
                if (binary.toString().charAt(j) == '1')
                    store += "#";
                else
                    store += " ";
            }

            answer[i] = store;
        }

        return answer;
    }
}
