package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭팔 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String store = buffer.readLine();
        String compare = buffer.readLine();
        boolean [] check = new boolean[store.length()];
        Stack<Pair> stack = new Stack<>();
        int storeLength = store.length();
        int compareLength = compare.length();

        //없애는 문자의 길이가 1 일때
        if (compare.length() == 1) {
            for (int i=0; i<storeLength; ++i)
                if (store.charAt(i) == compare.charAt(0))
                    check[i] = true;
        }

        else {
            for (int i=0; i<storeLength; ++i) {
                if (store.charAt(i) == compare.charAt(0))
                    stack.push(new Pair(i,0));
                else {
                    if (!stack.isEmpty()) {
                        Pair p = stack.peek();
                        if (store.charAt(i) == compare.charAt(p.compareIndex+1)) {
                            stack.push(new Pair(i,p.compareIndex+1));
                            if (p.compareIndex +1 == compareLength-1) {
                                int index = 0;
                                while (index != compareLength) {
                                    check[stack.pop().storeIndex] = true;
                                    ++index;
                                }
                            }
                        }
                        //store.charAt(i) == compare.charAt(p.compareIndex+1) 같지 않으면
                        else {
                            while (!stack.isEmpty())
                                stack.pop();
                        }

                    }
                }

            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<storeLength; ++i) {
            if (check[i])
                continue;

            builder.append(store.charAt(i));
        }

        if (builder.length() == 0) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(builder);
    }
}

class Pair {
    int storeIndex;
    int compareIndex;

    public Pair(int storeIndex, int compareIndex) {
        this.storeIndex = storeIndex;
        this.compareIndex = compareIndex;
    }

}