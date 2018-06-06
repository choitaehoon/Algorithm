
public class Pebble
{
    static int[][] a = {
            {  6,  7, 12, -5, 5,  3, 11, 3 },
            { -8, 10, 14,  9, 7, 13,  8, 5 },
            { 11, 12,  7,  4, 8, -2,  9, 4 }};

    static boolean 인접가능패턴(int 패턴1, int 패턴2) { //패턴이 되는지 안되는지 검사
        if (패턴1 == 패턴2) return false; //패턴이 같으면 false반환
        int[][] patterns = { {1, 4}, {3, 4}, {4, 1}, {4, 3} }; //불가능한 패턴들
        // ???
        for (int i = 0; i < patterns.length; ++i)
            if (패턴1 == patterns[i][0] && 패턴2 == patterns[i][1])
                return false;
        return true;
    }

    static int 열_점수(int c, int p) throws Exception {
        switch (p) {
            case 1: return a[0][c];
            case 2: return a[1][c];
            case 3: return a[2][c];
            case 4: return a[0][c] + a[2][c];
        }
        throw new Exception("invalid p:" + p);
    }

    static int 전체_점수(int c, int p) throws Exception {
        if (c == 0) return 열_점수(c, p);
        int 이전열_최고점수 = 0;

        for (int q = 1; q <= 4; ++q)
            if (인접가능패턴(p, q)) {
                int 점수 = 전체_점수(c - 1, q);
                if (점수 > 이전열_최고점수) 이전열_최고점수 = 점수;
            }
        return 이전열_최고점수 + 열_점수(c, p);
    }

    static int 전체_점수(int c) throws Exception {
        int 최고점수 = 0;
        for (int p = 1; p <= 4; ++p) {
            int 점수 = 전체_점수(c, p); //(7,1), (7,2), (7,3), (7,4)를 계산한다.
            if (점수 > 최고점수) 최고점수 = 점수;
        }
        return 최고점수;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(전체_점수(7));
    }
}
