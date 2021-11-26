package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ATM2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(buffer.readLine());
        List<Person> person = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i = 0, index = 1; i < len; ++i, ++index) {
            person.add(new Person(Integer.parseInt(token.nextToken()), index));
        }

        person.sort(Comparator.comparingInt(a -> a.time));
        int result = 0;
        int sum = 0;

        for (int i = 0; i < person.size(); ++i) {
            result += sum += person.get(i).time;
        }

        System.out.println(result);
    }

}

class Person {

    int time;
    int index;

    public Person(int time, int index) {
        this.time = time;
        this.index = index;
    }

}
