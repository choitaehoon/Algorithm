package 알고리즘중급.분할정복;

import java.io.*;

public class 하노이탑이동순서 {

    static int count;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        hanoi(Integer.parseInt(buffer.readLine()), 1, 2, 3);
        System.out.println(count);
        System.out.println(builder);
    }

    static void hanoi(int num, int start, int middle, int end){
        ++count;

        if (num == 1) {
            builder.append(start).append(" ").append(end).append("\n");
        }

        else {
            //A에서 B로
            hanoi(num-1, start, end, middle);
            builder.append(start).append(" ").append(end).append("\n");
            //B에서 C로
            hanoi(num-1, middle,start,end);
        }
    }

}
