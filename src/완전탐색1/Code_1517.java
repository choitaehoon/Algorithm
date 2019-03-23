package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//public class Code_1517
//{
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        int number =Integer.parseInt(buffer.readLine());
//        StringTokenizer token = new StringTokenizer(buffer.readLine());
//
//    }
//}
import java.io.*;
import java.util.*;

public class Code_1517 {
    public static long solve(int[] a, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start+end)/2;
        int[] b = new int[end-start+1];
        long ans = solve(a, start, mid) + solve(a, mid+1, end);

        {
            int i = start;
            int j = mid+1;
            int k = 0;
            while (i <= mid || j <= end) {
                if (i <= mid && (j > end || a[i] <= a[j])) {
                    b[k++] = a[i++];
                } else {
                    ans += (long)(mid-i+1);
                    b[k++] = a[j++];
                }
            }
        }

        for (int i=start; i<=end; i++) {
            a[i] = b[i-start];
        }
        return ans;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.valueOf(br.readLine());
        /*
           Integer parseInt ->리턴타입이 기본 자료형 이다.
           Integer valueOf -> 리턴타입이 객체 이다.
        */
//        int[] a = new int[n];
//        String[] line = br.readLine().split(" ");
//        for (int i=0; i<n; i++) {
//            a[i] = Integer.valueOf(line[i]);
//        }
        int [] a = {3,2,1};
        long ans = solve(a, 0, 3-1);
        System.out.println(ans);
    }
}