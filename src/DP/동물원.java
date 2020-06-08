package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        int[][] animal = new int[givenNumber+1][3];
        animal[1][0] = 1;
        animal[1][1] = 1;
        animal[1][2] = 1;

        for (int i = 2; i <= givenNumber; ++i) {
            animal[i][0] = (animal[i-1][0] + animal[i-1][1] + animal[i-1][2]) % 9901;
            animal[i][1] = (animal[i-1][0] + animal[i-1][2]) % 9901;
            animal[i][2] = (animal[i-1][0] + animal[i-1][1]) % 9901;
        }

        System.out.println(
                (animal[givenNumber][0] + animal[givenNumber][1] + animal[givenNumber][2]) % 9901
        );
    }

}
