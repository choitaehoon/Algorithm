package kakao;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 불량사용자 {

    static Set<Integer> set;

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "*rodo", "******", "******"}
        ));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        dfs(banned_id, user_id, 0, 0, 0);
        return set.size();
    }

    private static void dfs(String[] banned_id, String[] user_id, int id, int n, int visit) {
        if (n == banned_id.length) {
            set.add(visit);
            return;
        }

        for (int i=0; i<user_id.length; ++i) {
            String temp = banned_id[id].replace("*", ".");
            Pattern pattern = Pattern.compile(temp);
            Matcher matcher = pattern.matcher(user_id[i]);

            if (matcher.find() && user_id[i].length() == banned_id[id].length()) {
                if (((visit >> i) & 1) != 1)
                    dfs(banned_id, user_id, id + 1, n + 1, (visit | 1 << i));
            }
        }

    }

}
