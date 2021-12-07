package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
*   다시 풀기
* */
public class 도서관 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int book = Integer.parseInt(token.nextToken());
        int limitBook = Integer.parseInt(token.nextToken());

        int[] array = new int[book];
        StringTokenizer arrayToken = new StringTokenizer(buffer.readLine());
        for (int i = 0; i < book; ++i)
            array[i] = Integer.parseInt(arrayToken.nextToken());

        minStep(book, limitBook, array);
    }

    private static void minStep(int book, int limitBook, int[] array) {
        Arrays.sort(array);
        boolean[] check = new boolean[book];
        int pivot = 0;
        int sum = 0;

        for (int i = 0; i < book; ++i) {
            if (array[i] > 0) {
                pivot = i;
                break;
            }
        }

        for (int i = 0; i <= pivot; i += limitBook) {
            sum += Math.abs(array[i] * 2);
            check[i] = true;
        }

        for (int i = book - 1; i >= pivot; i -= limitBook)
            if (!check[i])
                sum += array[i] * 2;

        sum -= Math.max(Math.abs(array[0]), Math.abs(array[book - 1]));

        System.out.println(sum);
    }

}
