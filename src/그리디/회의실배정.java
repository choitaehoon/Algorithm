package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 회의실배정 {

    static Pointer[] pointers;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        pointers = new Pointer[givenNumber];

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            pointers[i] = new Pointer(start,end);
        }

        //pointer 배열 정렬 시키기
        Arrays.sort(pointers);

        System.out.println(maxConference());
    }

    private static int maxConference() {
        int length = pointers.length;
        int value = 1;
        int endConference = pointers[0].y;

        for (int i=1; i<length; ++i){
            //회의 끝나는 시간보다 시작시간이 크거나 같으면
            if (endConference <= pointers[i].x){
                ++value;
                endConference = pointers[i].y;
            }
        }

        return value;
    }


}

class Pointer implements Comparable<Pointer>{
    int x;
    int y;

    public Pointer(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pointer o) {
        int r = this.y - o.y;
        if (r != 0) return r;
        return this.x - o.x;
    }
}