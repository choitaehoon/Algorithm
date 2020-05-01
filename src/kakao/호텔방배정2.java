package kakao;

import java.util.*;

public class 호텔방배정2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                10,
                new long[]{1, 3, 4, 1, 3, 1}
        )));
    }

    public static long[] solution(long k, long[] room_number) {
        Map<Long, Long> node = new HashMap<>();
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < room_number.length; ++i) {
            if (!node.containsKey(room_number[i])) {
                result.add(room_number[i]);
                node.put(room_number[i], room_number[i] + 1);
            } else {
                List<Long> childNode = new ArrayList<>();
                long value = node.get(room_number[i]);
                childNode.add(room_number[i]);

                while (true) {
                    if (!node.containsKey(value)) {
                        result.add(value);
                        node.put(value, value + 1);

                        for (int childNodeIndex = 0 ; childNodeIndex < childNode.size(); ++childNodeIndex) {
                            node.put(childNode.get(childNodeIndex), value + 1);
                        }

                        break;
                    } else {
                        childNode.add(value);
                        value = node.get(value);
                    }
                }
            }
        }

        long[] answer = new long[result.size()];
        for (int i=0; i<result.size(); ++i)
            answer[i] = result.get(i);
        return answer;
    }
}
