package kakao;

import java.util.ArrayList;
import java.util.List;

//solving..
public class 캠핑 {

    static String[] dataTest = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(
                solution(2, new String[]{"N~F=0", "R~T>2"})
        );
    }

    public static int solution(int n, String[] data) {

        int count = 0;
        perm(dataTest, 0, 8, 8);

        for (int i = 0; i < list.size(); ++i) {
            boolean isCheck = true;
            String word = list.get(i);

            for (int z = 0; z < data.length; ++z) {
                char left = data[z].charAt(0);
                char right = data[z].charAt(2);
                int compare = Math.abs(word.indexOf(left) - word.indexOf(right));
                int fourNum = data[z].charAt(4);

                if (data[z].contains("=")) {
                    if (compare != 1) {
                        isCheck = false;
                        break;
                    }
                } else if (data[z].contains(">")) {

                    if (!(compare > fourNum + 1)) {
                        isCheck = false;
                        break;
                    }

                } else {

                    if (compare > fourNum) {
                        isCheck = false;
                        break;
                    }
                }
            }

            if (isCheck) {
                ++count;
            }
        }

        return count;
    }

    public static void print(String[] arr, int n) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            temp.append(arr[i]);
        }

        list.add(temp.toString());
    }

    public static void perm(String[] arr, int depth, int n, int k) {
        if (depth == k) {
            print(arr, k);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }

    }

    public static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
