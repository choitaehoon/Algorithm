package kakao;

import java.util.*;

public class 오픈채팅방2 {
    static Map<String, String> kakaoId = new HashMap<>();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{
                        "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
                })));
    }

    public static String[] solution(String[] record) {

        for (int i=0; i<record.length; ++i) {
            String[] recordSplit = record[i].split(" ");

            if (recordSplit[0].equals("Enter") || recordSplit[0].equals("Change")) {
                kakaoId.put(recordSplit[1], recordSplit[2]);
            }
        }

        for (int i=0; i<record.length; ++i) {
            String[] recordSplit = record[i].split(" ");

            if (recordSplit[0].equals("Enter")) {
                result.add(kakaoId.get(recordSplit[1])+"님이 들어왔습니다.");
            } else if (recordSplit[0].equals("Leave")) {
                result.add(kakaoId.get(recordSplit[1])+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[result.size()];
        for (int i=0; i<result.size(); ++i)
            answer[i] = result.get(i);

        return answer;
    }
}
