package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간 초과.. 다시 풀어보기 시간복잡도가 O(M*N) 인데 모든 수를 다돌라고 하기 때문..
@SuppressWarnings("Duplicates")
public class 카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int m = Integer.parseInt(token.nextToken());
            int n = Integer.parseInt(token.nextToken());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            int yMove = y%m;
            int count = x;
            int length = lcm(m,n);

            for (; ;) {
                if (count > length) {
                    System.out.println(-1);
                    break;
                }

                else if (yMove == y) {
                    System.out.println(count);
                    break;
                }

                yMove = (yMove+m)%n;
                count += m;
            }
        }

    }

    static int lcm (int m, int n) {
        int mMove = m;
        int nMove = n;

        while (nMove != 0) {
            if (mMove < nMove) {
                mMove ^= nMove;
                nMove ^= mMove;
                mMove ^= nMove;
            }

            int r = mMove%nMove;
            mMove = nMove;
            nMove = r;
        }

        return (m*n)/mMove;
    }
}
