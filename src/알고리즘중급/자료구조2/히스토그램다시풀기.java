package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
*  시간복잡도 O(n)으로 처리 -> n이 10만 이므로 / 변수 타입 long -> 높이가 10억까지 허용
*  n만큼 반복 -> 0
*  스택이 비어 있지 않고 스택 맨 위에 있는 수가 지금 현재 위치에 있는 높이 보다 크면 -> 처리 /  그 이후 스택에 현재 위치 저장 -> 0
*  너비는 스택이 비어 있으면 현재 위치로 설정 != 스택이 비어 있지 않으면 i - stack.peek - 1 -> 0
*  result 결과가 지금 현재 계산한 넓이보다 작으면 초기화 -> 0
*  남아 있는 스택을 아까 이전과 같이 처리
*/

@SuppressWarnings("Duplicates")
public class 히스토그램다시풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int givenNumber;

        do {
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            givenNumber = Integer.parseInt(token.nextToken());
            int[] array = new int[givenNumber];
            Stack<Integer> stack = new Stack<>();

            for (int i=0; i<givenNumber; ++i)
                array[i] = Integer.parseInt(token.nextToken());

            long result = 0;
            for (int i=0; i<givenNumber; ++i) {
                while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                    long height = array[stack.pop()];
                    long width = i;
                    if (!stack.isEmpty())
                        width = i - stack.peek() - 1;
                    if (result < height * width)
                        result = height * width;
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = array[stack.pop()];
                long width = givenNumber;

                if (!stack.isEmpty())
                    width = givenNumber - stack.peek() - 1;
                if (result < height * width)
                    result = height * width;
            }

            if (givenNumber != 0)
                System.out.println(result);
        }while (givenNumber != 0);
    }

}
