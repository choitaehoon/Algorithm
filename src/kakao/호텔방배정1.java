package kakao;

import java.util.*;

public class 호텔방배정1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(10,
                        new long[]{1, 3, 4, 1, 3, 1}
                )));
    }

    public static long[] solution(long k, long[] room_number) {
        Map<Long, Long> map = new HashMap<>();
        List<Long> listResult = new ArrayList<>();

        for (int i = 0; i < room_number.length; ++i) {
            if (!map.containsKey(room_number[i]))
                isVacancyRoom(map, listResult, room_number, i);
            else
                isNotVacancyRoom(map, listResult, room_number, i);
        }

        long[] answer = new long[listResult.size()];

        for (int i = 0; i < listResult.size(); ++i)
            answer[i] = listResult.get(i);

        return answer;
    }

    public static void isNotVacancyRoom(Map<Long, Long> map, List<Long> listResult, long[] room_number, int i) {
        List<Long> childNode = new ArrayList<>();
        long value = map.get(room_number[i]);
        childNode.add(room_number[i]);

        while (true) {
            if (!map.containsKey(value)) {
                map.put(value, value + 1);
                listResult.add(value);

                for (int z = 0; z < childNode.size(); ++z)
                    map.put(childNode.get(z), value + 1);

                break;
            } else {
                childNode.add(value);
                value = map.get(value);
            }
        }
    }

    public static void isVacancyRoom(Map<Long, Long> map, List<Long> listResult, long[] room_number, int i) {
        map.put(room_number[i], room_number[i] + 1);
        listResult.add(room_number[i]);
    }

}
