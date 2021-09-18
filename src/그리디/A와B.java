package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String start = buffer.readLine();
        String end = buffer.readLine();

        solution(start, new StringBuilder(end));
    }

    private static void solution(String start, StringBuilder end) {
        int sIndex = start.length() - 1;
        int eIndex = end.length() - 1;

        while (sIndex < eIndex) {
            char temp = end.charAt(eIndex);
            end = new StringBuilder(end.substring(0, eIndex));

            if (temp == 'B') {
                end.reverse();
            }

            eIndex--;
        }

        System.out.println(start.equals(end.toString()) ? 1 : 0);
    }

}
