package kakao;

import java.util.*;

public class 오픈채팅방1 {

    static Map<String, String> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }

    public static String[] solution(String[] record) {

        String[] answer;

        for (String temp : record) {
            String [] word = temp.split(" ");
            inputMap(word);
        }

        for (String temp : record) {
            String [] word = temp.split(" ");
            inputList(word);
        }

        answer = new String[list.size()];
        for (int i=0; i<list.size(); ++i)
            answer[i] = list.get(i);

        return answer;
    }

    private static void inputMap(String[] word) {
        if (word[0].equals("Enter") || word[0].equals("Change"))
            map.put(word[1], word[2]);
    }

    private static void inputList(String[] word) {
        String temp = "";

        if (word[0].equals("Enter")) {
            temp = map.get(word[1])+"님이 들어왔습니다.";
            list.add(temp);
        }
        else if (word[0].equals("Leave")) {
            temp = map.get(word[1])+"님이 나갔습니다.";
            list.add(temp);
        }

    }
}
