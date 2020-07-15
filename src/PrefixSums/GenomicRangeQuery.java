package PrefixSums;

import java.util.HashMap;
import java.util.Map;


public class GenomicRangeQuery {

    public static void main(String[] args) {

    }

    public static int[] solution(String S, int[] P, int[] Q) {
        Map<Character, Integer> dnaSequence = new HashMap<>();
        dnaSequence = dnaSequenceInsert();
        int len = Math.min(P.length, Q.length);
        int[] result = new int[len];

        for (int i = 0; i < len; ++i) {
            int start = P[i];
            int end = Q[i];
            int min = Integer.MAX_VALUE;

            for ( ; start <= end ; ++start) {
                min = Math.min(dnaSequence.get(S.charAt(start)), min);
            }

            result[i] = min;
        }

        return result;
    }

    private static Map<Character, Integer> dnaSequenceInsert() {
        Map<Character, Integer> dnaSequence = new HashMap<>();

        dnaSequence.put('A', 1);
        dnaSequence.put('C', 2);
        dnaSequence.put('G', 3);
        dnaSequence.put('T', 4);

        return dnaSequence;
    }

}
