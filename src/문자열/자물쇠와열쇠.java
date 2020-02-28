package 문자열;


public class 자물쇠와열쇠 {

    static int[][] map;

    public static void main(String[] args) {

        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};

        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        for (int i=0; i<4; ++i) {

            if (checkLock(key, lock)) {
                return true;
            }

            rotationKey(key);
        }

        return false;
    }

    public static boolean checkLock(int[][] key, int[][] lock) {
        boolean isLock;

        for (int i=0; i<lock.length; ++i) {
            for (int j=0; j<lock.length; ++j) {
                isLock = compareKeyAndLock(i, j, key, lock);

                if (isLock)
                    return true;
            }
        }

        return false;
    }

    public static boolean compareKeyAndLock(int width, int vertical, int[][] key, int[][] lock) {
        int[][] lockCopy = new int[lock.length][lock.length];

        int lenVertical = vertical;

        lockCopyInsert(lock, lockCopy);

        for (int i = 0; i< key.length; ++i) {
            for (int j = 0; j < key.length; ++j) {

                if (width < lock.length && vertical < lock.length) {

                    if ((key[i][j] == 1 && lock[width][vertical] == 1) ||
                            (key[i][j] == 0 && lock[width][vertical] == 0))
                        return false;

                    if (key[i][j] == 1 && lock[width][vertical] == 0)
                        lockCopy[width][vertical] = 1;
                }

                vertical++;
            }

            vertical = lenVertical;
            width++;
        }

        return checkLockCopy(lockCopy);
    }

    public static boolean checkLockCopy(int[][] lockCopy) {
        for (int i=0; i<lockCopy.length; ++i)
            for (int j=0; j<lockCopy.length; ++j)
                if (lockCopy[i][j] == 0)
                    return false;

        return true;
    }

    public static void lockCopyInsert(int[][] lock, int[][] lockCopy) {
        for (int i=0; i<lock.length; ++i)
            for (int j=0; j<lock.length; ++j)
                lockCopy[i][j] = lock[i][j];
    }

    public static void rotationKey(int[][] key) {
        map = new int[key.length][key.length];

        for (int i=0; i<key.length; ++i)
            for (int j=0; j<key.length; ++j) {

                if (key[i][j] == 1) {
                    changeKey(i, j, key);
                }
            }

        moveKey(key);
    }

    public static void changeKey(int width, int vertical, int[][] key) {
        map[vertical][key.length-1 - width] = key[width][vertical];
    }

    public static void moveKey(int[][] key) {
        for (int i=0; i<key.length; ++i)
            System.arraycopy(map[i], 0, key[i], 0, key.length);
    }

}
