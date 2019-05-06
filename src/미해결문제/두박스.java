package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두박스 {

    static int[] box1 = new int[4];
    static int[] box2 = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());

        for (int i=0; i<4; ++i)
            box1[i] = Integer.parseInt(token.nextToken());

        for (int i=0; i<4; ++i)
            box2[i] = Integer.parseInt(token2.nextToken());

        System.out.println(checkTwoBox());
    }

    private static String checkTwoBox() {
        if ((box1[0] == box2[2] && box1[1] == box2[3]) || (box1[2] == box2[0] && box1[3] == box2[1]) || (box1[2] == box2[0] && box1[1] == box2[4]) || (box1[0] == box2[2] && box1[3] == box2[1]))
            return "POINT";
        else
            return "NULL";
    }

}
