package 정렬;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Set<Integer> duplicateNumberCheck = new HashSet<>();

        for (int value : A)
            duplicateNumberCheck.add(value);

        return duplicateNumberCheck.size();
    }
}
