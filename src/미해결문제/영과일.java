package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//다시 풀어보기
public class 영과일 {

    static boolean check = false;
    static List<Integer> list = new ArrayList<>();
    static int number;
    static int [] array = new int[200000];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            number = Integer.parseInt(buffer.readLine());
            dfs(0, 0,0);
        }

    }

    static void dfs(int sum, int index, int reverseIndex) {

        if (number < sum || sum < 0)
            return;

        else {
            array[index] = 1;
            dfs(sum+(int)Math.pow(2,index),index+1,reverseIndex);

            if (sum == number)
                for (int i=0; i<index; ++i)
                    System.out.print(array[i]+" ");

            array[index] = 0;
            dfs(sum-(int)Math.pow(2,reverseIndex),index+1,reverseIndex+1);
        }

    }
}
