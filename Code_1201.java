import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_1201 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        StringBuilder builder = new StringBuilder();

        if (m+k-1 <= n && n <= m*k) {
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = i+1;
            }
            ArrayList<Integer> group = new ArrayList<>(); //그룹별로 나뉠 변수
            group.add(0);//첫번째
            group.add(k);//그룹 첫번째
            n -= k;
            m -= 1;
            int group_size = m == 0 ? 1 : n/m; //그룹 나누기
            int r = m == 0 ? 0 : n%m; //나눈 나머지(남은거 처리)
            //r이 0이라는건 딱 맞게 그룹이 나눠진다는 의미
            for (int i=0; i<m; i++) {
                group.add(group.get(group.size()-1)+group_size + (r > 0 ? 1 : 0));
                if (r > 0) {
                    r -= 1;
                }
            }
            for (int i=0; i<group.size()-1; i++) {
                int begin = group.get(i);
                int end = group.get(i+1)-1;
                while (begin < end) { //자리 바꿈
                    int temp = a[begin];
                    a[begin] = a[end];
                    a[end] = temp;
                    begin += 1; //시작 카운트 증가
                    end -= 1; //끝카운드 감소
                }
            }
            /*
             * 10만개 데이터 측정
             * System.out.print() //시간 0.525
             * StringBuilder //0.075
             * 출력할때 StringBuilder 이용하자~
             */
            for (int i=0; i<a.length; i++) {
                builder.append(a[i]).append(" ");
            }
            System.out.println(builder);
        } else {
            System.out.println(-1); //정답이 없을 경우에 -1
        }
    }
}