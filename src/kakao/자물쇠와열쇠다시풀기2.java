package kakao;

import java.util.Arrays;

public class 자물쇠와열쇠다시풀기2 {

    public static void main(String[] args) {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    private static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;

        for (int i=0; i<4; ++i) {

            for (int row=0; row<len; ++row) {
                for (int col=0; col<len; ++col) {
                    int[][] keyPlusLock = merge(key, lock, row, col);

                    if (isKeyPlusLock(keyPlusLock)) {
                        return true;
                    }
                }
            }

            rotation(key);
        }

        return false;
    }

    private static boolean isKeyPlusLock(int[][] keyPlusLock) {
        int len = keyPlusLock.length;

        for(int i=0; i<len; ++i) {
            for (int z=0; z<len; ++z) {
                if (keyPlusLock[i][z] != 1)
                    return false;
            }
        }

        return true;
    }

    private static int[][] merge(int[][] key, int[][] lock, int row, int col) {
        int lockLen = lock.length;
        int keyLen = key.length;
        int[][] newLock = new int[lockLen][lockLen];

        for (int i=0; i<lockLen; ++i) {
            for (int z=0; z<lockLen; ++z) {
                newLock[i][z] = lock[i][z];
            }
        }

        for (int keyRow=0, newLockRow=row; keyRow<keyLen; ++keyRow, ++newLockRow) {
            for (int keyCol=0, newLockCol=col; keyCol<keyLen; ++keyCol, ++newLockCol) {
                if (newLockRow < lockLen && newLockCol < lockLen)
                    newLock[newLockRow][newLockCol] += key[keyRow][keyCol];
            }
        }

        return newLock;
    }

    private static void rotation(int[][] key) {
        int len = key.length;
        int[][] newKey = new int[len][len];

        for (int i=0, row=0; i<len; ++i, ++row) {
            for (int z=0, col=len-1; z<len; ++z, --col) {
                newKey[i][z] = key[col][row];
            }
        }

        for (int i=0; i<len; ++i)
            System.arraycopy(newKey[i], 0, key[i], 0, len);

    }


}
