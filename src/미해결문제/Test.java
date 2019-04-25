package 미해결문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//다시 한번 보기
public class Test {

    static int prime[] = new int[4000010];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j * i <= N; j++) {
                if (prime[i * j] == 1)
                    continue;
                prime[i * j] = 1;
            }
        }

        int prime2[] = new int[N];
        int num = 0;
        for (int i = 2; i <= N; i++) {
            if (prime[i] == 0) {
                num++;
                prime2[num] = i;
            }
        }

        int M = num;
        int s; // 시작점
        int e = 1; // 끝점
        int sum = 0;
        int result = 0;
        for (s = 1; s <= M; s++) {
            for (; e <= M; e++) {
                if (sum + prime2[e] > N)
                    break;
                else {
                    sum += prime2[e];
                    if (sum == N)
                        result++;
                }
            }
            sum -= prime2[s];
        }
        System.out.println(result);
    }
}