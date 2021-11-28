package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        Person[] persons = new Person[n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int weight = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());

            persons[i] = new Person(weight, height);
        }

        printGrade(persons, n);
    }

    private static void printGrade(Person[] persons, int n) {
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 0; i < n; ++i) {
            for (int k = 0; k < n; ++k) {
                Person nowPerson = persons[i];
                Person comparePerson = persons[k];

                if (nowPerson.weight > comparePerson.weight && nowPerson.height > comparePerson.height)
                    result[k]++;
            }

        }

        for (int i = 0; i < n; ++i)
            System.out.print(result[i] + " ");
    }

}

class Person {

    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

}
