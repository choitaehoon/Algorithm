package study.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 방문길이 {
    public static void main(String[] args) {
//        System.out.println(solution("ULURRDLLU"));
//        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        Map<String,Integer> pre = new HashMap<>();
        Map<String,Integer> next = new HashMap<>();

        int sum = 0;
        int x = 0;
        int y = 0;

        for (int i=0; i<dirs.length(); ++i) {
            char now = dirs.charAt(i);

            int xMove = x;
            int yMove = y;

            if (now == 'U')
                xMove += 1;
            else if (now == 'D')
                xMove -= 1;
            else if (now == 'L')
                yMove -= 1;
            else
                yMove += 1 ;

            //값의 범위 넘어 갈 때
            if (xMove >= 6 || xMove <= -6 || yMove >= 6 || yMove <= -6)
                continue;

            if (pre.get(String.valueOf(x)+y) == null || next.get(String.valueOf(xMove)+yMove) == null){
                pre.put(String.valueOf(x)+ y,1);
                next.put(String.valueOf(xMove)+yMove,1);
                x = xMove;
                y = yMove;
                ++sum;
            }

        }

        return sum;
    }
}
