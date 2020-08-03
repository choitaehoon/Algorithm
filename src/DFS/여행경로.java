package DFS;

import java.util.*;

public class 여행경로 {

    static boolean[] isVisit;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
        )));
    }

    public static String[] solution(String[][] tickets) {
        isVisit = new boolean[tickets.length];

        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(result);

        return result.get(0).split(" ");
    }

    private static void dfs(String nowWord, String resultWord, int count, String[][] tickets) {
        if (count == tickets.length) {
            result.add(resultWord);
            return;
        }

        for (int i = 0; i < tickets.length; ++i) {
            if (!isVisit[i] && tickets[i][0].equals(nowWord)) {
                isVisit[i] = true;
                dfs(tickets[i][1], resultWord+" "+tickets[i][1], count + 1, tickets);
                isVisit[i] = false;
            }
        }
    }

}
