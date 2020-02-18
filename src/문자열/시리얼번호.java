package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 시리얼번호 {

    static int givenNumber;
    static List<Sorting> list = new ArrayList<Sorting>();

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        printGo();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            list.add(new Sorting(buffer.readLine()));

        Collections.sort(list);
    }

    private static void printGo() {
        for (int i=0; i<list.size(); ++i) {
            System.out.println(list.get(i).x);
        }
    }
}

class Sorting implements Comparable<Sorting> {

    int size;
    String x;
    int number;

    public Sorting(String x) {
        this.x = x;
        this.size = x.length();
        this.number = checkNumber(x);
    }

    private int checkNumber(String x) {
        int sum = 0;

        for (int i = 0; i < x.length(); ++i) {
            if ('0' <= x.charAt(i) && x.charAt(i) <= '9')
                sum += x.charAt(i) - '0';
        }

        return sum;
    }

    @Override
    public int compareTo(Sorting a) {
        int temp =  this.size - a.size;
        if (temp != 0) return temp;

        temp = this.number - a.number;
        if (temp != 0) return temp;

        return this.x.compareTo(a.x);
    }
}
