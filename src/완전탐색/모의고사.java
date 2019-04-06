package 완전탐색;

import java.util.Vector;

public class 모의고사 {

    public static int[] onePerson = {1, 2, 3, 4, 5};
    public static int[] twoPerson = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] threePerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};
        System.out.println(solution(answer));
    }

    public static int[] solution(int[] answers) {
        int[] sum = new int[3];

        for (int i=0; i<answers.length; ++i) {
            if (answers[i] == onePerson[i%5])
                sum[0]++;
            if (answers[i] == twoPerson[i%8])
                sum[1]++;
            if (answers[i] == threePerson[i%10])
                sum[2]++;
        }

        int max = sum[0];
        vector.add(1);

        for (int i=1; i<3; ++i) {
            if (max < sum[i]) {
                max = sum[i];
                vector.remove(0);
                vector.add(i+1);
            }
            else if (max == sum[i])
                vector.add(i+1);
        }

        int[] temp = new int[vector.size()];

        for (int i=0; i<vector.size(); ++i)
            temp[i] = vector.get(i);
        return temp;
    }
}
