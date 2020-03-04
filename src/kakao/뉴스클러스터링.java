package kakao;

import java.util.ArrayList;
import java.util.*;

public class 뉴스클러스터링 {

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "FRENCH"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2\t", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        List<String> str1List;
        List<String> str2List; //교집합

        str1List = strAdd(str1);
        str2List = strAdd(str2);

        if (str1List.size() == 0 && str2List.size() == 0)
            return 65536;

        int part = 0;
        for (String s : str1List) {
            if (str2List.contains(s)) {
                str2List.remove(s);
                ++part;
            }
        }

        int lenAll = str1List.size() + str2List.size();
        int lenPart = part;

        int answer = (int)Math.floor(
                ((double)lenPart / lenAll) * 65536
        );

        return answer;
    }

    private static List<String> strAdd(String str) {
        List<String> list = new ArrayList<>();

        for (int i=0; i<str.length()-1; ++i) {
            String temp = str.substring(i, i+2).toUpperCase();

            if (temp.length() == 1) {
                continue;
            }

            for (int j=0; j<2; ++j) {
                if (!(65 <= temp.charAt(j) && temp.charAt(j) <= 90))
                    break;
                else if (j == 1)
                    list.add(temp);
            }
        }

        return list;
    }


}
