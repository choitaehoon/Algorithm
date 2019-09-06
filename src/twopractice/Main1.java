package twopractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Main1 {

    static int m;
    static int n;
    static int k;
    static boolean[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());
        array = new boolean[m][n];

        for (int i=0; i<k; ++i){
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            int leftY = Integer.parseInt(tokenizer.nextToken());
            int leftX = Integer.parseInt(tokenizer.nextToken());
            int rightY = Integer.parseInt(tokenizer.nextToken());
            int rightX = Integer.parseInt(tokenizer.nextToken());

            int absLeft = m - Math.abs(leftY - rightY) - 1 ;
            int absRight = n -  Math.abs(leftX - rightX);
            System.out.println(absLeft+" "+absRight);
            trueMake(absLeft, absRight);
        }

    }

    private static void trueMake(int absLeft, int absRight){

    }

}
