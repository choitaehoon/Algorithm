package 알고리즘기초.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());

        for (int i=0; i<number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            int nIndex = n;
            int mIndex = m;
            int r = 0;

            while (mIndex != 0) {
                if (nIndex < mIndex) {
                    int temp = nIndex;
                    nIndex = mIndex;
                    mIndex = temp;
                }

                r = nIndex % mIndex;
                nIndex = mIndex;
                mIndex = r;
            }

            System.out.println((n*m)/nIndex);
        }

    }
}
