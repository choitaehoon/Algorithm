package study.중급;

import java.io.*;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class 문자열폭팔 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String keyword = buffer.readLine();
        String compare = buffer.readLine();
        Stack<Pair> stack = new Stack<>();

        int keywordLength = keyword.length();
        int compareLength = compare.length();
        boolean[] check = new boolean[keywordLength];

        //비교 문자열이 하나라면
        if (compareLength == 1) {
            StringBuilder builder = new StringBuilder();
            for (int i=0; i<keywordLength; ++i) {
                if (keyword.charAt(i) == compare.charAt(0))
                    continue;
                builder.append(keyword.charAt(i));
            }

            if (builder.length() == 0)
                System.out.println("FRULA");
            else
                System.out.println(builder);
            return;
        }

        //키워드가 두개 이상 이면
        else {
            for (int i=0; i<keywordLength; ++i) {

                //맨 처음과 같으면
                if (keyword.charAt(i) == compare.charAt(0))
                    stack.push(new Pair(i,0));

                //다르 다면
                else if (!stack.isEmpty()){
                    if (keyword.charAt(i) == compare.charAt(stack.peek().compareIndex + 1)) {
                        stack.push(new Pair(i,stack.peek().compareIndex + 1));
                        if (stack.peek().compareIndex + 1  == compareLength ) {
                            int index = 0;
                            while (index != compareLength) {
                                check[stack.pop().keywordIndex] = true;
                                ++index;
                        }
                    }
                }
                    else {
                        while (!stack.isEmpty())
                            stack.pop();
                    }
            }

            }
        }

        StringBuilder builder = new StringBuilder();
            for (int i=0; i<keywordLength; ++i) {
                if (!check[i])
                    builder.append(keyword.charAt(i));
            }

            if (builder.length() == 0)
                System.out.println("FRULA");
            else
                System.out.println(builder);
    }
}

class Pair {
    int keywordIndex;
    int compareIndex;

    public Pair(int keywordIndex, int compareIndex) {
        this.keywordIndex = keywordIndex;
        this.compareIndex = compareIndex;
    }
}