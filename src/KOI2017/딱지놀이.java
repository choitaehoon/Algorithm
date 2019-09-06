package KOI2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token1 = new StringTokenizer(buffer.readLine());
            StringTokenizer token2 = new StringTokenizer(buffer.readLine());

            int [] array1 = new int[4];
            int [] array2 = new int[4];

            int num1 = Integer.parseInt(token1.nextToken());
            int num2 = Integer.parseInt(token2.nextToken());

            for (int j = 0; j<num1; ++j) {
                int store1 = Integer.parseInt(token1.nextToken());
                array1[store1 - 1]++;
            }

            for (int j = 0; j<num2; ++j) {
                int store2 = Integer.parseInt(token2.nextToken());
                array2[store2 - 1]++;
            }

            for (int j = 3; j >= -1; --j){
                if (j == -1) {
                    System.out.println("D");
                    break;
                }
                else if (array2[j] < array1[j]){
                    System.out.println("A");
                    break;
                }
                else if (array1[j] < array2[j]) {
                    System.out.println("B");
                    break;
                }
            }
        }

    }

}
