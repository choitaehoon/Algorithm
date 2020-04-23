package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동아리회장선거 {

    static int n;

    public static void main(String[] args) throws IOException {
        inputN();
        recursiveGo(0, "");
    }

    private static void recursiveGo(int index, String temp) {
        if (index == n) {
            System.out.println(temp);
            return;
        }

        if (index >= n)
            return;

        recursiveGo(index + 1, temp+"O");
        recursiveGo(index + 1, temp+"X");

    }

    private static void inputN() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
    }


}
