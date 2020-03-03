package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {

    static int index;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})
        ));

        System.out.println(Arrays.toString(
                solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
                                        "F-14 Tomcat"})
        ));

    }

    public static String[] solution(String[] msg) {
        List<Muzi> list = new ArrayList<>();

        for (int i=0; i<msg.length; ++i) {

            String headFirst;
            int numberFist;
            String tailFirst;

            headFirst = headFirstCheck(msg[i]);
            numberFist = numberFistCheck(msg[i]);
            tailFirst = msg[i].substring(index);

            list.add(new Muzi(msg[i], headFirst, numberFist, tailFirst, i));
            index = 0;
        }

        list.sort( (Muzi o1, Muzi o2) -> {
            int r = o1.head.compareToIgnoreCase(o2.head);

            if (r != 0)
                return r;

            r = o1.number - o2.number;
            if (r != 0)
                return r;

            r = o1.index - o2.index;
            return r;
            }
        );

        String[] result = new String[list.size()];
        for (int i=0; i<list.size(); ++i) {
            result[i] = list.get(i).text;
        }

        return result;
    }

    private static String headFirstCheck(String text) {
        StringBuilder builder = new StringBuilder();

        for (; index < text.length(); ++index) {
            if (isHead((text.charAt(index)))) {
                builder.append(text.charAt(index));
            } else
                break;
        }

        return builder.toString();
    }

    private static int numberFistCheck(String text) {
        StringBuilder builder = new StringBuilder();

        for ( ; index < text.length(); ++index) {
            if ('0' <= text.charAt(index) && text.charAt(index) <= '9') {
                builder.append(text.charAt(index));
            } else
                break;
        }

        return Integer.parseInt(builder.toString());
    }

    private static boolean isHead(char check) {
        return ('a' <= check && check <= 'z') ||
                ('A' <= check && check <= 'Z') ||
                (' ' == check) || ('.' == check) || ('-' == check);
    }

}

class Muzi {

    String text;
    String head;
    int number;
    String tail;
    int index;

    public Muzi(String text, String head, int number, String tail, int index) {
        this.text = text;
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.index = index;
    }

}