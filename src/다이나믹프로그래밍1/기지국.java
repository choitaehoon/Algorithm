package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 기지국 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(buffer.readLine());
        ArrayList<Coordinate> list = new ArrayList<>();
        long[] d = new long[line+1];


        //값 넣으면서 y가 음수 이면 양수로 변환
        for (int i=1; i<=line; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            if (y < 0) y *= -1;
            list.add(new Coordinate(x,y));
        }

        //오름차순 정렬
        Collections.sort(list);
        list.add(0,new Coordinate(0,0));

        for (int i=1; i<=line; ++i) {

            //절대값이 백만 이하니까
            d[i] = Long.MAX_VALUE;
            int up = 0;

            for (int j=i; j>=1; --j) {
                up = Math.max(up , list.get(j).y);
                int square = Math.max(list.get(i).x - list.get(j).x , up*2);
                if (d[j-1] + square < d[i])
                    d[i] = d[j-1]+square;
            }
        }

        System.out.println(d[line]);
    }
}

class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate o) {
        int k = this.x - o.x;
        if (k != 0) return k;
        return this.y - this.y;
    }
}