package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 롤케이크 {

    static boolean[] cakeArray;
    static List<PersonCake> list = new ArrayList<>();
    static List<ExpectedEat> expect = new ArrayList<>();
    static int[] expectPerson;

    public static void main(String[] args) throws IOException {
        inputCake();
        printGo();
    }

    private static void inputCake() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        cakeArray = new boolean[Integer.parseInt(buffer.readLine())];

        int person = Integer.parseInt(buffer.readLine());

        for (int i=0; i<person; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());


            int cake = cakeEat(x, y);
            list.add(new PersonCake(i, cake));
            expect.add(new ExpectedEat(i, y - x + 1));

        }

        Collections.sort(expect);
        Collections.sort(list);
    }

    private static int cakeEat(int x, int y) {
        int sum = 0;

        for (int i=x-1; i<y; ++i) {
            if (!cakeArray[i]) {
                ++sum;
                cakeArray[i] = true;
            }
        }

        return sum;
    }

    private static void printGo() {
        System.out.println(expect.get(0).personExpected + 1);
        System.out.println(list.get(0).person + 1);
    }

}

class PersonCake implements Comparable<PersonCake>{

    int person;
    int cake;

    public PersonCake(int person, int cake) {
        this.person = person;
        this.cake = cake;
    }

    @Override
    public int compareTo(PersonCake o) {
        int r = o.cake - this.cake;
        if (r == 0)
            return this.person - o.person;
        return r;
    }
}

class ExpectedEat implements Comparable<ExpectedEat> {

    int personExpected;
    int cake;

    public ExpectedEat(int personExpected, int cake) {
        this.personExpected = personExpected;
        this.cake = cake;
    }

    @Override
    public int compareTo(ExpectedEat o) {
        int r = o.cake - this.cake;
        if (r == 0)
            return this.personExpected - o.personExpected;
        return r;
    }
}