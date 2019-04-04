package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기이진탐색 {

    static int[] nArray;
    static int[] mArray;
    static int number;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer nToken = new StringTokenizer(buffer.readLine());
        nArray = new int[n];

        int m = Integer.parseInt(buffer.readLine());
        StringTokenizer mToken = new StringTokenizer(buffer.readLine());
        mArray = new int[m];

        for (int i=0; i<n; ++i)
            nArray[i] = Integer.parseInt(nToken.nextToken());

        for (int i=0; i<m; ++i)
            mArray[i] = Integer.parseInt(mToken.nextToken());

        Arrays.parallelSort(nArray);

        for (int i=0; i<m; ++i) {
            number = mArray[i];
            System.out.println(binarySearch(0,nArray.length-1) ? 1 : 0);
        }
    }

    public static boolean binarySearch(int start, int end) {
        if (start > end)
            return false;

        else {
            int middle = (start+end)/2;
            if (lookForMatch(middle))
                return true;
            else {
                if (number < nArray[middle])
                    return binarySearch(start,middle-1);
                else
                    return binarySearch(middle+1,end);
            }
        }

    }

    public static boolean lookForMatch(int index) {
        if (number == nArray[index])
            return true;
        return false;
    }

}
