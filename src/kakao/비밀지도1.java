package kakao;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

public class 비밀지도1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{0, 0, 0, 0, 0}, new int[]{30, 1, 21, 17, 28})));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        AtomicInteger index = new AtomicInteger();

         List<String> list = Arrays.stream(arr1)
                            .mapToObj(a -> {
                                StringBuilder builder = new StringBuilder(Integer.toBinaryString(a | arr2[index.getAndIncrement()]));
                                StringBuilder result = new StringBuilder();

                                int len = n - builder.length();
                                for (int i=0; i<len; ++i) {
                                    builder.insert(0, "0");
                                }

                                for (int i=0; i<builder.length(); ++i) {
                                    if (builder.charAt(i) == '1')
                                        result.append("#");
                                    else
                                        result.append(" ");
                                }

                                return result.toString();
                            })
                            .collect(toList());

         String[] answer = new String[n];
         for (int i=0; i<list.size(); ++i) {
             answer[i] = list.get(i);
         }

        return answer;
    }
}
