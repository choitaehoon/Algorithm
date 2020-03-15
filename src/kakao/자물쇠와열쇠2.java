package kakao;

import java.util.Arrays;

public class 자물쇠와열쇠2 {

    public static void main(String[] args) {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int extN = n+2*m-2; // 상하좌우에 m-1을 두번 더해줍니다.

        int[][] extLock = new int[extN][extN]; // 확장버전의 자물쇠 배열

        for(int row = 0 ; row < n ; row++) {
            for(int col = 0 ; col < n ; col++ ) {
                extLock[row + m-1][col + m-1] = lock[row][col]; // 중앙에만 lock을 복사해줌
            }
        }

        // key는 총 네 방향으로 로테이션 가능합니다
        for(int fig = 0 ; fig < 4 ; fig++ ) {

            // key의 맨 첫번째 원소가 들어갈 자리를 row, col로 정해주는 겁니다
            for(int row = 0 ; row < n+m-1 ; row++) {
                for(int col = 0 ; col < n+m-1 ; col++) {
                    // 그 자리에 key를 두고 lock과 합쳤을때의 결과를 merged에 담습니다
                    int[][] merged = merge(key, extLock, row, col);

                    // 자물쇠가 열렸는지 여부를 판단하고, 열렸다면 참을 반환합니다
                    if(isSolved(merged, n, m)) {
                        return true;
                    }
                }
            }
            // 열리지 않았다면 키를 90도 회전시킵니다
            rotate(key);
        }
        // 이 모든 시도에서 성공하지 못했다면 이 자물쇠는 열 수 없습니다!
        return false;

    }

    // 키와 자물쇠를 맞춰본 결과를 반환해줄 메서드
    static int[][] merge(int[][] key, int[][] extLock, int row, int col){
        int n = extLock.length;
        int m = key.length;
        int[][] res = new int[n][n]; // 빈 배열을 하나 만들어서

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++ ) {
                res[i][j] = extLock[i][j]; // extLock을 복사해온 뒤
            }
        }

        for(int i = 0, r = row ; i < m ; i++, r++) {
            for(int j = 0, c = col ; j < m ; j++, c++) {
                res[r][c] += key[i][j]; // 키와 합쳐줍니다
            }
        }

        return res;

    }

    // 자물쇠가 풀렸는지 여부를 반환해줄 매서드
    static boolean isSolved(int[][] merged, int n, int m) {

        for(int row = 0 ; row < n ; row++) {
            for(int col = 0 ; col < n ; col++) {
                // 1이 아니라면(0이거나 2라면) 풀린게 아님
                if(merged[row+m-1][col+m-1] != 1)
                    return false;
            }
        }

        return true;
    }

    // 키를 90도 회전시켜줄 메서드
    static void rotate(int[][] key) {
        int m = key.length;
        int[][] rotated = new int[m][m];

        for(int kCol = 0, rRow = 0 ; kCol < m ; kCol++, rRow++) {
            for(int kRow = m-1 , rCol = 0 ; kRow >= 0 ; kRow--, rCol++) {
                rotated[rRow][rCol] = key[kRow][kCol];
            }
        }

        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < m ; col++) {
                key[row][col] = rotated[row][col];
            }
        }
    }

}
