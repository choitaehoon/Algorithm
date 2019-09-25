import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 올림픽 {

    static int nation;
    static int grade;
    static Pair[] pairs;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        nation = Integer.parseInt(token.nextToken());
        grade = Integer.parseInt(token.nextToken());
        pairs = new Pair[nation];
        rank = new int[nation];

        for (int i=0; i<nation; ++i){
            StringTokenizer ranking = new StringTokenizer(buffer.readLine());
            pairs[i] = new Pair(Integer.parseInt(ranking.nextToken()), Integer.parseInt(ranking.nextToken()), Integer.parseInt(ranking.nextToken()), Integer.parseInt(ranking.nextToken()));
            rank[i] = 1;
        }

        Arrays.sort(pairs);

        System.out.println(calculate());
    }

    private static int calculate() {
        for (int i=1; i<nation; ++i){
            for (int j=i-1; j>=0; --j){
                if (pairs[j].gold > pairs[i].gold || pairs[j].silver > pairs[i].silver || pairs[j].copper > pairs[i].copper)
                    rank[pairs[i].number-1]++;
            }
        }

        return rank[grade-1];
    }

}

class Pair implements Comparable<Pair> {

    int number;
    int gold;
    int silver;
    int copper;

    Pair(int number, int gold, int silver, int copper){
        this.number = number;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
    }

    @Override
    public int compareTo(Pair o) {
        int r = o.gold - this.gold;
        if (r != 0) return r;

        int a = o.silver - this.silver;
        if (a != 0) return a;

        int b = o.copper - this.copper;
        if (b != 0) return b;

        return this.number - o.number;
    }
}