package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토너먼트 {

    static int totalPerson;
    static int a;
    static int b;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean check;

    public static void main(String[] args) throws IOException {
        inputTotalPersonAndAB();
        actionFight();
    }

    private static void inputTotalPersonAndAB() throws IOException{
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        totalPerson = Integer.parseInt(token.nextToken());
        a = Integer.parseInt(token.nextToken());
        b = Integer.parseInt(token.nextToken());

    }

    private static void actionFight() {
        int round = 0;

        while (a != b) {
            a = a/2 + a%2;
            b = b/2 + b%2;
            round++;
        }

        System.out.println(round);
    }

}
