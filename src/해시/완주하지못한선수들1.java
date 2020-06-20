package 해시;

import java.util.*;

public class 완주하지못한선수들1 {

    public static void main(String[] args) {
        String[] participant = {"stanko", "stanko", "ana","mislav"};
        String[] completion = {"stanko", "ana", "mislav"};
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant,completion));
    }

    //예외 케이스 -> completionMap에 없거나 하나 이상이면
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int len = Math.min(participant.length, completion.length);

        for (int i = 0; i < len; ++i)
            if (!participant[i].equals(completion[i]))
                return participant[i];

        return participant[participant.length - 1];
    }

}
