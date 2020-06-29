package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 모의고사 {

    public static int[] onePerson = {1, 2, 3, 4, 5};
    public static int[] twoPerson = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] threePerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {

    }

    /*
    * 가장 높은 점수를 받는 사람 Return -> 여럿일 경우 오름차순으로 정
    * */
    public int[] solution(int[] answers) {

        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == onePerson[i % 5]) {
                resultMap.put(1, resultMap.get(1) == null ? 1 : resultMap.get(1) + 1);
            }

            if (answers[i] == twoPerson[i % 8]) {
                resultMap.put(2, resultMap.get(2) == null ? 1 : resultMap.get(2) + 1);
            }

            if (answers[i] == threePerson[i % 10]) {
                resultMap.put(3, resultMap.get(3) == null ? 1 : resultMap.get(3) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> resultList = new ArrayList<>(resultMap.entrySet());
        resultList.sort((a1, a2) -> {
            int r = a2.getValue() - a1.getValue();
            if (r != 0) return r;

            return a1.getKey() - a2.getKey();
        });

        if (!resultList.isEmpty() && resultList.get(0).getValue() == 0)
            return new int[]{};

        int resultValue = resultList.get(0).getValue();
        int count = 1;

        for (int i = 1; i < resultList.size(); ++i) {
            if (resultValue == resultList.get(i).getValue())
                ++count;
            else
                break;
        }

        int[] resultInt = new int[count];
        for (int i = 0; i < count; ++i)
            resultInt[i] = resultList.get(i).getKey();

        return resultInt;
    }

//    public static int[] onePerson = {1, 2, 3, 4, 5};
//    public static int[] twoPerson = {2, 1, 2, 3, 2, 4, 2, 5};
//    public static int[] threePerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//    public static Vector<Integer> vector = new Vector<>();
//    public int[] solution(int[] answers) {
//        int[] sum = new int[3];
//
//        for (int i=0; i<answers.length; ++i) {
//            if (answers[i] == onePerson[i%5])
//                sum[0]++;
//            if (answers[i] == twoPerson[i%8])
//                sum[1]++;
//            if (answers[i] == threePerson[i%10])
//                sum[2]++;
//        }
//
//        int max = sum[0];
//        vector.add(1);
//
//        for (int i=1; i<3; ++i) {
//            if (max < sum[i]) {
//                max = sum[i];
//                vector.remove(0);
//                vector.add(i+1);
//            }
//            else if (max == sum[i])
//                vector.add(i+1);
//        }
//
//        int[] temp = new int[vector.size()];
//
//        for (int i=0; i<vector.size(); ++i)
//            temp[i] = vector.get(i);
//        return temp;
//    }
}
