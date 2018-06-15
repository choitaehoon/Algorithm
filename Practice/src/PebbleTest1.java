public class PebbleTest1
{
    static int[][] a = {
            {6,7,12,-5,5,3,11,3},
            {-8,10,14,9,7,13,8,5},
            {11,12,7,4,8,-2,9,4}
    };

    static int[][] patternStore = { // 안되는 패턴들
            {1,4}, {4,1},
            {3,4}, {4,3}
    };

    public static boolean pattern(int pattern1, int pattern2) //패턴 확인
    {
        if(pattern1 == pattern2) return false; //패턴이 같으면 false 반환
        for(int i=0; i<patternStore.length; ++i)
            if(pattern1 == patternStore[i][0] && pattern2 == patternStore[i][1])
                return false;
        return true;
    }

    public static int totalSum(int c, int p)
    {
        System.out.printf("전체점수:%d %d\n",c, p);
        if(c == 0) return a[c][p]; //c가 0이라면 다 돈더니까 return하기
        int sum =0; //총점
        int preSore = 0; //이전 단계 점수
        for(int i=1; i<=4; ++i)
            if(pattern(p,i)) //가능한 패턴이라면
            {
                preSore =totalSum(c-1,i);
                sum += preSore;
            }

        return sum;//임시 리턴
    }

    public static int totalSum(int c)
    {
        int score = 0;
        int preScore = 0;
        for(int i=1; i<=4; ++i)
        {
            score = totalSum(c,i);
            if(preScore > score)
                score = preScore;
        }
        return score; //임시 리턴
    }

    public static void main(String[] args)
    {
        System.out.println(totalSum(7));
    }
}
