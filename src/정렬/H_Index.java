package 정렬;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {100,200,300,400,500};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int result = 0;
        Arrays.parallelSort(citations);

        for (int i=0; i<citations.length; ++i) {
            int small = Math.min(citations[i],citations.length-i);
            result = Math.max(result,small);
        }
        return result;
    }

}
