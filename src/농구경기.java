import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("all")
public class 농구경기 {

    static int givenNumber;
    static Map<Character,Integer> map = new HashMap<>();
    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        givenNumber = Integer.parseInt(buffer.readLine());

        //성 map에 담기
        for (int i=0; i<givenNumber; ++i)
            storeLastName(buffer.readLine());

        //같은 성 5개 인지 확인
        checkListName();

        //성 정렬
        if (list.size() == 0)
            System.out.println("PREDAJA");
        else{
            Collections.sort(list);
            for (int i=0; i<list.size(); ++i)
                System.out.print(list.get(i));
        }
    }

    //같은 성 5개 인지 확인
    private static void checkListName() {
        for (Map.Entry<Character, Integer> maps : map.entrySet())
            if (maps.getValue() >= 5)
                list.add(maps.getKey());
    }

    //성 map에 담기
    private static void storeLastName(String text) {
        map.put(text.charAt(0), map.get(text.charAt(0)) == null ? 1 : map.get(text.charAt(0)) + 1);
    }

}
