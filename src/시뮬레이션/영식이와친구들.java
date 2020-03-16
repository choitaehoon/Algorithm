package 시뮬레이션;

import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영식이와친구들 {

    static int n, m, l;

    public static void main(String[] args) throws IOException {
        inputNML();
        actionGo();

    }

    private static void inputNML() throws IOException{
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        l = Integer.parseInt(token.nextToken());
    }

    private static void actionGo() {
        int[] sumArray = new int[n];
        int index = 0;
        int sum = 0;

        while (true) {
            sumArray[index]++;

            if (m == sumArray[index])
                break;

            if (!(sumArray[index] % 2 == 0)) {
                index = (index + l) % n;
            } else {
                if (index - l < 0) {
                    index = n + (index - l);
                } else {
                    index -= l;
                }
            }

            ++sum;
        }

        System.out.println(sum);
    }

}

// 1 2 3 4 5 6 7 8
// 7 - 4
//7 -