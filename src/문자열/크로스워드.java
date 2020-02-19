package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 크로스워드 {

    static String n;
    static String m;
    static int width;
    static int vertical;

    public static void main(String[] args) throws IOException {
        inputWord();
        actionWidthAndVerticalCrossWord();
        printGo();
    }

    private static void inputWord() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        n = token.nextToken();
        m = token.nextToken();
    }

    private static void actionWidthAndVerticalCrossWord() {
        int sum = 0;

        for (int i=0; i<m.length(); ++i) {
            for (int z=0; z<n.length(); ++z) {
                if (m.charAt(i) == n.charAt(z)) {
                    width = i;
                    vertical = z;
                    ++sum;
                }
            }
        }

        if (2 <= sum)
            actionWidthAndVerticalCrossWordAgain();
    }

    private static void actionWidthAndVerticalCrossWordAgain() {
        loop : for (int i=0; i<n.length(); ++i) {
            for (int z=0; z<m.length(); ++z) {
                if (n.charAt(i) == m.charAt(z)) {
                    width = z;
                    vertical = i;
                    break loop;
                }
            }
        }
    }

    private static void printGo() {

        for (int i=0; i<m.length(); ++i) {
            for (int z=0; z<n.length(); ++z) {
                if (vertical == z)
                    System.out.print(m.charAt(i));
                else if (width == i)
                    System.out.print(n.charAt(z));
                else
                    System.out.print(".");
            }
            System.out.println();
        }

    }

}