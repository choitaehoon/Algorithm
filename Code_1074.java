import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1074 {
    static int N;
    static int R,C,cnt = 0;
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        z((int)Math.pow(2,N), 0, 0);
        System.out.println(builder);
    }

    public static void z(int n, int r, int c) {
        if (n == 2) { //정사각형 2x2될때 이 조건문에 들어온다.
            if (r == R && c == C) { //주어진 행과 열이 같다면 멈추기 , 1사분면인지
                builder.append(cnt++);
                return;
            }
            cnt++;
            if (r == R && c+1 == C) { //주어진 행과 열이 같다면 멈추기 , 2사분면인지
                builder.append(cnt++);
                return;
            }
            cnt++;
            if (r+1 == R && c == C) { //주어진 행과 열이 같다면 멈추기 , 3사분면인지
                builder.append(cnt++);
                return;
            }
            cnt++;
            if (r+1 == R && c+1 == C) { //주어진 행과 열이 같다면 멈추기 , 4사분면인지
                builder.append(cnt++);
                return;
            }
            cnt++;
            return;
        }

        /* 행과 열이 2가 될때 까지 나누는 재귀함수*/
        z(n/2, r, c);
        z(n/2, r, c + n/2);
        z(n/2, r + n/2, c);
        z(n/2, r + n/2, c + n/2);

    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Code_1074
//{
//    static int[][] arr;
//    static int count;
//
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(buffer.readLine());
//
//        int n = Integer.parseInt(token.nextToken());
//        int r = Integer.parseInt(token.nextToken());
//        int c = Integer.parseInt(token.nextToken());
//        int pow = (int)Math.pow(2,n); //제곱근
//        arr = new int[pow][pow];
//
//        search(pow,r,c);
//        System.out.println(count);
////        int store = temp(pow,r,c);
////        if (store == 1)
////            z(0,0,r,c);
////        else if (store == 2)
////            z(0,pow/2,r,c);
////        else if (store == 3)
////            z(pow/2,0,r,c);
////        else
////            z(pow/2,pow/2,r,c);
//    }
//
//    public static int search(int n,int r, int c) //행렬이 위치하는 그면을 찾아서 그 미만은 카운트 안하고 바로 계산 적용
//    {
//        if (n/2 > r && n/2  > c) //1사분면
//            return 0;
//        else if (n/2 > r && n/2 <= c) //2사분면
//            return 1*((n/2)*(n/2)-1);
//        else if (n/2 <= r && n/2 > c) //3사분면
//            return 2*((n/2)*(n/2))-1;
//        else   //4사분면
//            return 3*((n/2)*(n/2))-1;
//    }
//
//    public static int temp(int n,int r, int c) // 몇사분면에 시작할지 알려주는 메소드
//    {
//        if (n/2 > r && n/2  > c) //1사분면
//            return 1;
//        else if (n/2 > r && n/2 <= c) //2사분면
//            return 2;
//        else if (n/2 <= r && n/2 > c) //3사분면
//            return 3;
//        else   //4사분면
//            return 4;
//    }
//
////    public static int z(int startR,int startC,int r, int c)
////    {
////
////    }
//}
