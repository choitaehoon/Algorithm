//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Code_2110
//{
//    static int [] arr;
//
//    /*
//     * 이 문제는 이진 탐색이 필요하다. -> 집의 좌표가 10억개 이기 때문에 이중 for문 사용시 O(N^2) 시간 초과
//     *
//     */
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(buffer.readLine());
//        int house = Integer.parseInt(token.nextToken());
//        int share = Integer.parseInt(token.nextToken());
//        arr = new int[house];
//
//        for (int i=0; i<house; ++i)
//            arr[i] = Integer.parseInt(buffer.readLine());
//
//        Arrays.parallelSort(arr); //이진 탐색 하기 위해선 정렬 필요
//
//        int left = 1; // 가능한 최소 거리
//        int right = arr[house - 1] - arr[0]; // 가능한 최대 거리
//        int d = 0;
//        int ans = 0;
//
//        while (left <= right) {
//            int mid = (left + right) / 2; // 기준
//            int start = arr[0];
//            int cnt = 1;
//
//            // 간격(d) 를 기준으로 공유기 설치
//            for (int i = 1; i < house; i++) {
//                d = arr[i] - start;
//                if (mid <= d) {
//                    ++cnt;
//                    start = arr[i];
//                }
//            }
//
//            if (cnt >= share) {
//                // 공유기의 수를 줄이자 => 간격 넓히기
//                ans = mid;
//                left = mid + 1;
//            } else {
//                // 공유기가 더 설치되어야한다. => 간격 좁히기
//                right = mid - 1;
//            }
//        }
//        System.out.println(ans);
//
//    }
//}
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Code_2110
{
    static int [] arr;

    /*
     * 이 문제는 이진 탐색이 필요하다. -> 집의 좌표가 10억개 이기 때문에 이중 for문 사용시 O(N^2) 시간 초과
     *
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(buffer.readLine());
//        int house = Integer.parseInt(token.nextToken());
        int house = 5;
//        int share = Integer.parseInt(token.nextToken());
        int share = 3;
//        arr = new int[house];

        arr = new int[]{1,2,8,4,9};
//        for (int i=0; i<house; ++i)
//            arr[i] = Integer.parseInt(buffer.readLine());

        Arrays.parallelSort(arr); //이진 탐색 하기 위해선 정렬 필요

        int left = 1; // 가능한 최소 거리
        int right = arr[house - 1] - arr[0]; // 가능한 최대 거리
        int d = 0;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 기준
            int start = arr[0];
            int cnt = 1;

            // 간격(d) 를 기준으로 공유기 설치
            for (int i = 1; i < house; i++) {
                d = arr[i] - start;
                if (mid <= d) {
                    ++cnt;
                    start = arr[i];
                }
            }

            if (cnt >= share) {
                // 공유기의 수를 줄이자 => 간격 넓히기
                ans = mid;
                left = mid + 1;
            } else {
                // 공유기가 더 설치되어야한다. => 간격 좁히기
                right = mid - 1;
            }
        }
        System.out.println(ans);

    }
}
