package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 인공지능시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int hour = Integer.parseInt(token.nextToken());
        int minute = Integer.parseInt(token.nextToken());
        int second = Integer.parseInt(token.nextToken());
        int givenSecond = Integer.parseInt(buffer.readLine());

        second += givenSecond;
        minute += second / 60; second %= 60;
        hour += minute / 60; minute %= 60;
        hour %= 24;

        System.out.println(hour+" "+minute+" "+second);
    }

}
