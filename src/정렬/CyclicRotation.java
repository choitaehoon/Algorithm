package 정렬;

import java.util.*;

public class CyclicRotation {

    public static void main(String[] args) {
        System.out.println(new int[]{}.length);
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0)
            return new int[]{};

        Deque<Integer> storeA = new ArrayDeque<>();
        int aLen = A.length;

        for (int value : A)
            storeA.add(value);

        for (int i = 0; i < K; ++i) {
            storeA.addFirst(storeA.removeLast());
        }

        int[] resultArray = new int[aLen];
        int index = 0;
        while (!storeA.isEmpty()) {
            resultArray[index++] = storeA.removeFirst();
        }
        // write your code in Java SE 8
        return resultArray;
    }

}
