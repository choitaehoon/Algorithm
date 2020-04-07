package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
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
        if (n == 2) {
            if (r == R && c == C) { //주어진 행과 열이 같다면 멈추기
                builder.append(cnt++);
                return;
            }
            cnt++;
            if (r == R && c+1 == C) { //주어진 행과 열이 같다면 멈추기
                builder.append(cnt++);
                return;
            }
            cnt++;
            if (r+1 == R && c == C) { //주어진 행과 열이 같다면 멈추기
                builder.append(cnt++);
                return;
            }
            cnt++;
            if (r+1 == R && c+1 == C) { //주어진 행과 열이 같다면 멈추기
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
