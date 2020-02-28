package kakao;

@SuppressWarnings("all")
public class 자물쇠와열쇠다시풀기 {

    public static void main(String[] args) {
//        key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
//        lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//
//        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {

        for (int i=0; i<4; ++i) {
            if(checkLock(key, lock)) {
                return true;
            }

            rotationKey(key);
        }

        boolean answer = true;
        return answer;
    }

    private static boolean checkLock(int[][] key, int[][] lock) {

        for (int i=0; i<lock.length; ++i) {
            for (int j=0; j<lock.length; ++j) {
                boolean isKey = checkKey(i, j, key, lock);

                if (isKey)
                    return true;
            }
        }

        return false;
    }

    private static boolean checkKey(int width, int vertical, int[][] key, int[][] lock) {
        int lenWidth = width;
        int lenVertical = vertical;

        int[][] lockCopy = lockCopyAdd(lock);

        for (int i=0; i<key.length; ++i) {
            for (int j=0; j<key.length; ++j) {
                if (width < lock.length && vertical < lock.length) {
                    if (key[i][j] == 1 && lock[width][vertical] == 1)
                        return false;
                    if (lock[width][vertical] == 0 && key[i][j] == 1)
                        lockCopy[width][vertical] = 1;
                }
                vertical++;
            }

            vertical = lenVertical;
            width++;
        }

        return lockCopyCheck(lockCopy);
    }

    private static boolean lockCopyCheck(int[][] lockCopy) {
        for (int i=0; i<lockCopy.length; ++i) {
            for (int j=0; j<lockCopy.length; ++j)
                if (lockCopy[i][j] == 0)
                    return false;
        }

        return true;
    }

    private static int[][] lockCopyAdd(int[][] lock) {

        int[][] lockCopy = new int[lock.length][lock.length];

        for (int i=0; i<lock.length; ++i) {
            for (int j=0; j<lock.length; ++j)
                lockCopy[i][j] = lock[i][j];
        }

        return lockCopy;
    }

    private static void rotationKey(int[][] key) {
        int[][] map = new int[key.length][key.length];

        for (int i=0; i<key.length; ++i) {
            for (int j=0; j<key.length; ++j) {
                if (key[i][j] == 1) {
                    map[j][key.length-i-1] = key[i][j];
                    key[i][j] = 0;
                }
            }
        }

        mapToKey(map, key);
    }

    private static void mapToKey(int[][] map, int[][] key) {
        for(int i=0; i<map.length; ++i)
            for (int j=0; j<map.length; ++j)
                key[i][j] = map[i][j];
    }

}
