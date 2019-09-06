package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 화살표그리기2 {

    static Pointer[] pointers;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        pointers = new Pointer[givenNumber];
        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            pointers[i] = new Pointer(x,y);
        }

        Arrays.parallelSort(pointers);
        System.out.println(sumDistancePoints());
    }

    private static int sumDistancePoints(){
        int sum = 0;

        for (int i=0; i<pointers.length; ++i){
            int pre = 0;
            int post = 0;

            //맨앞일때
            if (i == 0) {
                sum += Math.abs(pointers[i+1].x - pointers[i].x);
                continue;
            }
            //맨 뒤일때
            if (i == pointers.length-1){
                sum += Math.abs(pointers[i-1].x - pointers[i].x);
                continue;
            }
            //전 색깔과 같을때
            if (pointers[i-1].y == pointers[i].y) {
                pre = Math.abs(pointers[i-1].x - pointers[i].x);
            }
            //후 색깔과 같을때
            if (pointers[i].y == pointers[i+1].y) {
                post = Math.abs(pointers[i].x - pointers[i+1].x);
            }
            if (pre == 0)
                sum += post;
            else if (post == 0)
                sum += pre;
            else sum += Math.min(pre,post);
        }

        return sum;
    }

}
class Pointer implements Comparable<Pointer>{
    int x;
    int y;

    Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Pointer o) {
        int r  = this.y - o.y;
        if (r != 0) return r;
        return this.x - o.x;
    }
}