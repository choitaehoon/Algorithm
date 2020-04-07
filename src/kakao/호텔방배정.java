package kakao;

import java.util.*;

public class 호텔방배정 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(10,
                        new long[]{1, 3, 4, 1, 3, 1}
        )));
    }

    public static long[] solution(long k, long[] room_number) {
        Map<Long, Long> map = new HashMap<>();
        List<Long> result = new ArrayList<>();

        for (int i=0; i<room_number.length; ++i) {
            if (!map.containsKey(room_number[i])) {
                map.put(room_number[i], room_number[i] + 1);
                result.add(room_number[i]);
            } else {
                List<Long> list = new ArrayList<>();
                long value = map.get(room_number[i]);
                list.add(room_number[i]);

                while (true) {
                    if (!map.containsKey(value)) {
                        result.add(value);
                        map.put(value, value + 1);
                        for (int z=0; z<list.size(); ++z) {
                            map.put(list.get(z), value + 1);
                        }
                        break;
                    } else {
                        list.add(value);
                        value = map.get(value);
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
/*
* 빈 방이라면 즉시 주고 부모노드 생성
* 빈 방이 아니라면 부모노드 탐색
*   빈 방이라면 즉시 방 배정 하고 다음 방을 부모노드 생성
* */
