package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 후보추천하기 {

    /*
3
14
2 1 4 3 5 6 2 7 2 100 100 54 54 50
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int pictureAllow = Integer.parseInt(buffer.readLine());
        int person = Integer.parseInt(buffer.readLine());
        int[] array = new int[person];
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i = 0; i < person; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        List<Recommendation> list = new ArrayList<>();
        for (int i = 0; i < person; ++i) {
            recommendPlus(array[i], list, pictureAllow);
            timePlus(list);

            list.sort((a1, a2) -> {
                int r = a1.count - a2.count;
                if (r != 0) return r;
                return a2.time - a1.time;
            });
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i)
            result.add(list.get(i).nowPerson);
        Collections.sort(result);
        for (int i = 0; i < result.size(); ++i)
            System.out.print(result.get(i)+" ");
    }

    private static void recommendPlus(int value, List<Recommendation> list, int pictureAllow) {
        boolean visit = false;
        for (Recommendation reco : list)
            if (reco.nowPerson == value) {
                reco.count++;
                visit = true;
            }

        if (!visit) {
            if (isListSizeOver(list, pictureAllow))
                list.remove(0);
            list.add(new Recommendation(value, 1, 0));
        }
    }

    private static void timePlus(List<Recommendation> list) {
        for (Recommendation reco : list)
            reco.time++;
    }

    private static boolean isListSizeOver(List<Recommendation> list, int pictureAllow) {
        return list.size() >= pictureAllow;
    }

}

class Recommendation {

    int nowPerson;
    int count;
    int time;

    public Recommendation(int nowPerson, int count, int time) {
        this.nowPerson = nowPerson;
        this.count = count;
        this.time = time;
    }

    @Override
    public String toString() {
        return nowPerson +" " + count +" "+time;
    }

}