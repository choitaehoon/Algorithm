package kakao.blind2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    static Map<String, String> userId = new HashMap<>();
    static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static String[] solution(String[] record) {

        for (String s : record) {
            String[] recordNow = s.split(" ");

            switch (recordNow[0]) {
                case "Change":
                case "Enter":
                    recordChange(recordNow[1], recordNow[2]);
                    break;
            }
        }

        for (String s : record) {
            String[] recordNow = s.split(" ");

            switch (recordNow[0]) {
                case "Enter" :
                    resultList.add(userId.get(recordNow[1])+"님이 들어왔습니다.");
                    break;
                case "Leave" :
                    resultList.add(userId.get(recordNow[1])+"님이 나갔습니다.");
                    break;
            }
        }

        String[] answer = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); ++i)
            answer[i] = resultList.get(i);
        return answer;
    }

    private static void recordChange(String id, String nickName) {
        userId.put(id, nickName);
    }

}
