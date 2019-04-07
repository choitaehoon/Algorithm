package 해시;

import java.util.Arrays;

public class 완주하지못한선수들 {
    public static void main(String[] args) {
        String[] participant = {"stanko", "mislav", "ana","mislav"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.parallelSort(participant);
        Arrays.parallelSort(completion);

        for (int i=0; i<participant.length; ++i)
            if (!participant[i].equals(completion[i]))
                return participant[i];

        return participant[participant.length-1];

    }
}
