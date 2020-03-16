package kakao;

import java.util.Arrays;

public class 외벽점검 {

    private static int nInput, num = 0;
    private static boolean finish = false;
    private static int[] weakInput, distInput, choice;
    private static int[][] rotateWeak;

    public static void main(String[] args) {
        System.out.println(solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
    }

    public static int solution(int n, int[] weak, int[] dist) {
        nInput = n;
        weakInput = weak;
        distInput = dist;
        setWeak();

        for (int i = 1; i <= dist.length; i++) {
            num = i;
            choice = new int[num];
            permutation(0, new boolean[dist.length]);
            if (finish) break;
        }
        return (finish) ? num : -1;
    }

    public static void setWeak() { // weak를 0 ~ n-1번 회전하여 rotateWeak에 저장
        int len = weakInput.length;
        rotateWeak = new int[len][len];

        for (int i = 0; i < len; i++) {
            rotateWeak[i] = rotate(weakInput, i);
        }
    }

    //배열을 순열
    public static int[] rotate(int[] weak, int idx) {
        int len = weak.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (i + idx < len) result[i] = weak[i + idx];
            else result[i] = weak[i + idx - len] + nInput;
        }

        return result;
    }

    public static void permutation(int depth, boolean[] visit) {
        if (finish) return;
        if (depth == num) {
            check();
            return;
        }

        for (int i = 0; i < distInput.length; i++) {
            if (!visit[i]) {
                choice[depth] = distInput[i];
                visit[i] = true;
                permutation(depth + 1, visit);
                visit[i] = false;
            }
        }
    }

    public static void check() {
        for (int[] weak : rotateWeak) {
            int idx = 0, start = 0;
            boolean[] visit = new boolean[weak.length];

            while (idx != num) {
                int i = start;
                int value = choice[idx++];

                for (int j = start; j < weak.length; j++) {
                    if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value)) break;
                    visit[j] = true;
                    start++;
                }
            }

            if (isFinish(visit)) {
                finish = true;
                return;
            }
        }
    }

    //다 체크 되어 있는지 확인
    public static boolean isFinish(boolean[] visit) {
        for (boolean bool : visit) {
            if (!bool) return false;
        }
        return true;
    }

}
