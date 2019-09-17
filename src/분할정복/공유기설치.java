package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class 공유기설치 {

    static int n;
    static int c;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer houseAndShare = new StringTokenizer(buffer.readLine());
        n = Integer.parseInt(houseAndShare.nextToken());
        c = Integer.parseInt(houseAndShare.nextToken());
        array = new int[n];

        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        Arrays.sort(array);
        System.out.println(calculate());
    }

    private static int calculate() {
        int start = 1;
        int end = array[n-1];
        int maxDistance = 0;

        while (start <= end) {
            int middle = (start+end)/2;
            int startDistance = array[0];
            int d = 0;
            int count = 1;

            for (int i=1; i<n; ++i){
                d = array[i] - startDistance;
                if (middle <= d){
                    ++count;
                    startDistance = array[i];
                }
            }

            if (count < c)
                end = middle - 1;
            else {
                start = middle + 1;
                maxDistance = middle;
            }
        }

        return maxDistance;
    }

}
