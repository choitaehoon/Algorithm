package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오븐시계 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer allocateTime = new StringTokenizer(buffer.readLine());
        StringTokenizer givenTime = new StringTokenizer(buffer.readLine());

        int hour = Integer.parseInt(allocateTime.nextToken());
        int minute = Integer.parseInt(allocateTime.nextToken());
        int time = Integer.parseInt(givenTime.nextToken());

        System.out.println((hour+((minute+time)/60))%24+" "+(minute+(time%60))%60);
    }

}
