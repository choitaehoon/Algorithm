package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//다시 해보기
public class 검열 {

    static Stack<IndexStore> left = new Stack<>();
    static Stack<IndexStore> right = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String A = buffer.readLine();
        String B = buffer.readLine();
        int aLength = A.length();
        int bLength = B.length();

        StringBuilder builder = new StringBuilder();
        if (aLength == 1) {
            for (int i=0; i<bLength; ++i) {
                if (B.charAt(i) == A.charAt(0))
                    continue;
                builder.append(B.charAt(i));
            }
            System.out.println(builder);
            return;
        }

        int leftStart= 0;
        int rightStart = bLength-1;

        for (;leftStart<=rightStart; ++leftStart ) {
            if (B.charAt(leftStart) == A.charAt(0))
                left.push(new IndexStore(leftStart,0));

            if (B.charAt(leftStart) == left.peek().aIndex+1)
                left.push(new IndexStore(leftStart,left.peek().aIndex+1));


        }

        for (; rightStart >= leftStart; --rightStart) {

        }

    }
}

class IndexStore {

    int bIndex;
    int aIndex;

    public IndexStore(int bIndex, int aIndex) {
        this.bIndex = bIndex;
        this.aIndex = aIndex;
    }
}