package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class 극장좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        int line = Integer.parseInt(buffer.readLine());

        int[] seat = new int[100];
        Vector<Integer> vector = new Vector<>();
        long sum = 1;

        seat[0] = 1; seat[1] = 1;

        //seat 저장
        for (int i=2; i<=44; ++i)
            seat[i] = seat[i-1] + seat[i-2];

        //vip 좌석 위치 저장
        vector.add(0);
        for (int i=1; i<=line; ++i)
            vector.add(Integer.parseInt(buffer.readLine()));
        vector.add(number+1);

        for (int i=1; i<vector.size(); ++i)
            sum *= seat[vector.get(i) - vector.get(i-1) -1];

        System.out.println(sum);
    }
}
