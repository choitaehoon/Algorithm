package 알고리즘중급.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        Pointer[] array = new Pointer[givenNumber];

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int s = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());
            array[i] = new Pointer(s,e);
        }

        Arrays.sort(array);

        int value = 0;
        int count = 0;
        for (int i=0; i<givenNumber; ++i)
            if (value <= array[i].start) {
                value = array[i].end;
                count++;
            }
        System.out.println(count);
    }
}

class Pointer implements Comparable<Pointer> {
    int start;
    int end;

    public Pointer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pointer o) {
        int r = this.end - o.end;
        if (r != 0) return r;
        return this.start - o.start;
    }
}