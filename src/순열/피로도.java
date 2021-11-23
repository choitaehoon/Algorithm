package 순열;

public class 피로도 {

    int result;

    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        Pointer[] pointer = new Pointer[len];

        for (int i = 0; i < len; ++i) {
            pointer[i] = new Pointer(dungeons[i][0], dungeons[i][1]);
        }

        permutation(pointer, 0, len, len, k);

        return result;
    }

    public void permutation(Pointer[] pointer, int depth, int n, int r, int k) {
        if (depth == r) {
            int nowK = k;
            int count = 0;

            for (int i = 0; i < pointer.length; ++i) {
                Pointer point = pointer[i];
                if (nowK >= point.minFatigability) {
                    ++count;
                    nowK -= point.minValue;
                }
            }

            result = Math.max(result, count);
            return;
        }

        for (int i = 0; i < n; ++i) {
            swap(pointer, depth, i);
            permutation(pointer, depth + 1, n, r, k);
            swap(pointer, depth, i);
        }

    }

    public void swap(Pointer[] pointer, int depth, int i) {
        Pointer point = pointer[depth];
        pointer[depth] = pointer[i];
        pointer[i] = point;
    }
}

class Pointer {

    int minFatigability;
    int minValue;

    public Pointer(int minFatigability, int minValue) {
        this.minFatigability = minFatigability;
        this.minValue = minValue;
    }

}