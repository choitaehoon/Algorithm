package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 올림픽 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        List<Olympics> store = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            int one = Integer.parseInt(tokenizer.nextToken());
            int two = Integer.parseInt(tokenizer.nextToken());
            int three = Integer.parseInt(tokenizer.nextToken());
            int four = Integer.parseInt(tokenizer.nextToken());

            store.add(new Olympics(one, two, three, four));
        }

        store.sort((a1, a2) -> {
            int r = a2.gold - a1.gold;
            if (r != 0) return r;

            r = a2.silver - a1.silver;
            if (r != 0) return r;

            return a2.bronze - a1.bronze;
        });

        sortOlympicsGrade(store, k);
    }

    private static void sortOlympicsGrade(List<Olympics> store, int k) {
        int storeLen = store.size();
        int[] result = new int[storeLen];
        int gold = store.get(0).gold;
        int silver = store.get(0).silver;
        int bronze = store.get(0).bronze;
        result[store.get(0).id - 1] = 1;

        for (int i = 1, grade = 1, nowGrade = 2; i < storeLen; ++i, ++nowGrade) {
            Olympics nowOlympic = store.get(i);
            int id = nowOlympic.id;
            int nowGold = nowOlympic.gold;
            int nowSilver = nowOlympic.silver;
            int nowBronze = nowOlympic.bronze;

            if (gold == nowGold && silver == nowSilver && bronze == nowBronze) {
                result[id - 1] = grade;
            } else {
                result[id - 1] = nowGrade;
                grade = nowGrade;
            }

            gold = nowGold;
            silver = nowSilver;
            bronze = nowBronze;
        }

        System.out.println(result[k - 1]);
    }

}

class Olympics {

    int id;
    int gold;
    int silver;
    int bronze;

    public Olympics(int id, int gold, int silver, int bronze) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public String toString() {
        return id + " " + gold + " " + silver + " " + bronze;
    }

}