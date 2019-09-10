package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 대회or인턴_2 {

    static int n,m,k;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        System.out.println(possibleTeamPeople());
    }

    private static int possibleTeamPeople() {
        int value = 0;
        int nPeople = 0;
        int mPeople = 0;

        //nPeople + mPeople >= k+m ??
        while (nPeople+2 <= n && mPeople+1 <= m){
            ++value;
            nPeople +=2;
            mPeople +=1;
        }

        return value;
    }

}
