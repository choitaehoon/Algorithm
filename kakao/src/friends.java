import java.util.Arrays;

public class friends
{
    public static int removeBlock(String[] answer)
    {
        String[][] temp = new String[answer.length][answer[0].length()];//저장 변수
        boolean[][] search = new boolean[answer.length][answer[0].length()]; //탐색 변수

        for(int i=0; i<answer.length/2; ++i)
            for (int j=0; j<answer[0].length()-1; ++j)
                if(answer[i].substring(j,j+1).equalsIgnoreCase(answer[i].substring(j+1,j+2)) && (answer[i+1].substring(j,j+1).equalsIgnoreCase(answer[i].substring(j,j+1)) &&
                answer[i+1].substring(j+1,j+2).equalsIgnoreCase(answer[i].substring(j,j+1))))
                {
                    System.out.println(i+" "+j);
                    //같으면 탐색변수에 true로 저장
                    search[i][j] = true; search[i][j+1] = true; //위
                    search[i+1][j] =true; search[i+1][j+1] = true; //아래
                }

        for(int i=0; i<answer.length; ++i)
            for(int j=0; j<answer[0].length(); ++j)
                if(search[i][j])
                {
                    System.out.println(i+" "+j);
                    temp[i][j] = ""; //2x2 원소 없애기
                }
        return 0;
    }

    public static void main(String[] args)
    {
        String[] temp = {"CCBDE","AAADE","AAABF","CCBBF"};
        System.out.println(removeBlock(temp));
    }
}
