package study.프로그래머스;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{70, 50, 80, 50},100));
//        System.out.println(solution(new int[]{50,50,50,50},100));
//        System.out.println(solution(new int[]{70, 80, 50},100));
        System.out.println(solution(new int[]{20,30,40},40));
    }

    public static int solution(int[] people, int limit) {
        Arrays.parallelSort(people);
        int count = 0;

        int i = 0;
        int j = people.length-1;

        while (i <= j) {
            count++;

            if (people[i] + people[j] <= limit) i++;

            j--;
        }

        if (i == j) count++;
//        for (int i=0; i<=people.length-1; ) {
//            count++;
//
//            if (i == people.length -1)
//                break;
//
//            if (people[i] + people[i+1] <= limit){
//                i += 2;
//                continue;
//            }
//
//            i++;
//        }

        return count;
    }
}
