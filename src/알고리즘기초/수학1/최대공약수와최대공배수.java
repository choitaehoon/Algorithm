package 알고리즘기초.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최대공배수 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
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

            r = nIndex%mIndex;
            nIndex = mIndex;
            mIndex = r;
        }

        System.out.println(nIndex);
        System.out.println((n*m)/nIndex);
    }

}
