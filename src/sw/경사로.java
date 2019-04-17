package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

    static int[][] givenArray;
    static int[][] getGivenArray;
    static int n;
    static int l;
    static int sum;
    static boolean[] check;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        l = Integer.parseInt(token.nextToken());
        givenArray = new int[n][n];
        getGivenArray = new int[n][n];

        for (int i=0; i<n; ++i) {
            StringTokenizer arrayToken = new StringTokenizer(buffer.readLine());
            for (int j=0; j<n; ++j)
                getGivenArray[j][i] = givenArray[i][j] = Integer.parseInt(arrayToken.nextToken());
        }

        for (int i=0; i<n; ++i) {
          searchSlope(i,givenArray);
          searchSlope(i,getGivenArray);
        }

        System.out.println(sum);
    }

    static void searchSlope(int index, int[][] arr) {
        check = new boolean[n];

        for (int i=0; i<n-1; ++i) {
            if (checkNumberEqual(index, i,arr)) {
                int compareNumber = arr[index][i] - arr[index][i+1];
                if (!makeSureDifferenceOne(compareNumber)) return;

                //왼쪽 경사로
                if (compareNumber == -1) {
                    for (int j=0; j<l; ++j) {
                        if (i-j < 0 || check[i-j])
                            return;

                        if (arr[index][i] == arr[index][i-j])
                            check[i-j] = true;
                        else
                            return;
                    }
                }

                //오른쪽 경사로
                else {
                    for (int j=1; j<=l; ++j) {
                        if (i+j >= n || check[i+j]) return;

                        if (arr[index][i] -1 == arr[index][i+j])
                            check[i+j] = true;
                        else
                            return;
                    }
                }
           }
        }

        sum++;
    }

    static boolean checkNumberEqual (int index, int i, int[][] arr) {
        if (arr[index][i] != arr[index][i+1])
            return true;
        return false;
    }

    static boolean makeSureDifferenceOne(int compareNumber) {
        if (Math.abs(compareNumber) == 1)
            return true;
        return false;
    }
}
