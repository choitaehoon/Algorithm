
public class PebbleTest
{
    static int[][] a =
            {
                    {6,7,12,-5,5,3,11,3},
                    {-8,10,14,9,7,13,8,5},
                    {11,12,7,4,8,-2,9,4}
    };

    static boolean 인접가능패턴(int 패턴1, int 패턴2) { //패턴이 되는지 안되는지 검사
        if (패턴1 == 패턴2) return false; //패턴이 같으면 false반환
        int[][] patterns = { {1, 4}, {3, 4}, {4, 1}, {4, 3} }; //불가능한 패턴들
        // 패턴이 같으면 안되니까
        for (int i = 0; i < patterns.length; ++i)
            if (패턴1 == patterns[i][0] && 패턴2 == patterns[i][1])
                return false;
        return true;
    }

    static int 열_점수(int c, int p) throws Exception { //열 반환
        switch (p) {
            case 1: return a[0][c];
            case 2: return a[1][c];
            case 3: return a[2][c];
            case 4: return a[0][c] + a[2][c];
        }
        throw new Exception("invalid p:" + p);
    }

    static int 전체_점수(int c, int p) throws Exception {
        System.out.printf("전체점수:%d %d\n",c, p);
        if (c == 0) return 열_점수(c, p);
        int 이전열_최고점수 = 0;
        for (int q = 1; q <= 4; ++q)
            if (인접가능패턴(p, q)) { //인접가능한지 검사
                int 점수 = 전체_점수(c - 1, q); //재귀 호출
                if (점수 > 이전열_최고점수) 이전열_최고점수 = 점수; //최고점수 대입
            }
        return 이전열_최고점수 + 열_점수(c, p); //한 열의 패턴이 끝나면 반환
    }

    static int 전체_점수(int c) throws Exception {
        int 최고점수 = 0;
        for (int p = 1; p <= 4; ++p) {
            int 점수 = 전체_점수(c, p);
            if (점수 > 최고점수) 최고점수 = 점수;
        }
        return 최고점수;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(전체_점수(2));
    }
}
