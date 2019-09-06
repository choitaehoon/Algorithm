package kakao;

import java.util.ArrayList;
import java.util.List;

public class 다트게임 {
    public static void main(String[] args) {
        System.out.println(solution("1S*2T*3S"));
    }

    public static int solution(String dartResult) {
        List<Integer> list = new ArrayList<>();
        int value = 0;
        StringBuilder parse = new StringBuilder();

        for (int i=0; i<dartResult.length(); ++i) {
            //숫자이면
            if (48 <= dartResult.charAt(i) && dartResult.charAt(i) <= 57) {
                //값이 0이 아니면
                if (value != 0) {
                    list.add(value);
                    value = 0;
                }

                //숫자 일때 parse 초기화
                parse.setLength(0);
                parse.append(dartResult.charAt(i));
            }
            else if (dartResult.charAt(i) == 'D')
                value = (int) (Math.pow(Integer.parseInt(parse.toString()), 2));
            else if (dartResult.charAt(i) == 'T')
                value = (int) (Math.pow(Integer.parseInt(parse.toString()), 3));
                //전의 값과 현재 값 2배
            else if (dartResult.charAt(i) == '*') {
                int val = Integer.parseInt(parse.toString());
                //값이 없다면
                if (list.size() != 0)
                    val = list.remove(list.size()-1);
                list.add(val*2);
                value = Integer.parseInt(parse.toString()) * 2;
            }
            else if (dartResult.charAt(i) == '#')
                value = Integer.parseInt(parse.toString()) * -1;
        }

        int max = 0;
        for (Integer integer : list) {
            System.out.println(integer);
            max += integer;
        }
        return max;
    }
}
