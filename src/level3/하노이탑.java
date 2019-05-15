package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이탑 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3)));
    }

    public static int[][] solution(int n) {
        List<Pair> list = new ArrayList<>();
        hanoi(n,1,2,3, list);

        int length = (int)Math.pow(2,n) - 1;
        int[][] array = new int[length][2];

        for (int i=0; i<length; ++i) {
            array[i][0] = list.get(i).x;
            array[i][1] = list.get(i).y;
        }

        return array;
    }

    static void hanoi(int sum,int start, int to , int end, List<Pair> list) {
        if (sum == 1) {
            list.add(new Pair(start,end));
        }
        else {
            hanoi(sum-1,start,end,to,list);
            list.add(new Pair(start,end));
            hanoi(sum-1,to,start,end,list);
        }

    }
}
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
