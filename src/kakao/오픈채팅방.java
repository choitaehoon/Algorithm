package kakao;

import java.io.IOException;
import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) throws IOException {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        Map<String, String> maps = new HashMap<>();

        for (int i=0; i<record.length; ++i) {
            StringTokenizer token = new StringTokenizer(record[i]);
            String temp1 = token.nextToken();

            //들어오거나 바꿀 때 닉네임 변경
            if (temp1.equals("Enter") || temp1.equals("Change")) {
                changeName(token.nextToken(), token.nextToken(), maps);
            }
        }

        return print(maps, record);
    }

    private static void changeName(String key, String value, Map<String, String> maps) {
        maps.put(key, value);
    }

    private static String[] print(Map<String, String> maps, String[] record){
        List<String> list = new ArrayList<>();

        for (int i=0; i<record.length; ++i){
            StringTokenizer token = new StringTokenizer(record[i]);
            String temp1 = token.nextToken();
            if (temp1.equals("Enter"))
                list.add(maps.get(token.nextToken())+"님이 들어왔습니다.");
            else if (temp1.equals("Leave"))
                list.add(maps.get(token.nextToken())+"님이 나갔습니다.");
        }

        String[] store = new String[list.size()];
        for (int i=0; i<list.size(); ++i)
            store[i] = list.get(i);
        return store;
    }

}
