package 알고리즘기초.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD합 {

    public static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());

        for (int i=0; i<number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int num = Integer.parseInt(token.nextToken());
            int[] array = new int[num];

            //array 값 받아 오기
            for (int j=0; j<num; ++j)
                array[j] = Integer.parseInt(token.nextToken());

            for (int k=0; k<num; ++k)
                for (int j=k+1; j<num; ++j)
                    gcd(array[k],array[j],0);

            System.out.println(sum);
            sum = 0;
        }
    }

    @SuppressWarnings("Duplicates")
    public static void gcd(int nIndex, int mIndex, int r) {
        if (mIndex == 0) {
            sum += nIndex;
            return;
        }

        else {
            if (nIndex < mIndex) {
                int temp = nIndex;
                nIndex = mIndex;
                mIndex = temp;
            }

            gcd(mIndex,nIndex%mIndex,0);
        }

    }

}
