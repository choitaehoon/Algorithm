import java.util.Arrays;

public class friends
{
    public static int removeBlock(String[] answer)
    {
        int count =0; //없어진 갯수 세기
        String[][] temp = new String[answer.length][answer[0].length()];//저장 변수
        boolean[][] search = new boolean[answer.length][answer[0].length()]; //탐색 변수

        for(int i=0; i<answer.length/2; ++i)
            for (int j=0; j<answer[0].length()-1; ++j)
                if(answer[i].substring(j,j+1).equalsIgnoreCase(answer[i].substring(j+1,j+2)) && (answer[i+1].substring(j,j+1).equalsIgnoreCase(answer[i].substring(j,j+1)) &&
                answer[i+1].substring(j+1,j+2).equalsIgnoreCase(answer[i].substring(j,j+1))))
                {
                    //같으면 탐색변수에 true로 저장
                    //중복된거 체크해야 하므로 false껏만 검사

                        search[i][j] = true; count++; search[i][j+1] = true; count++;//위
                        search[i+1][j] =true; count++; search[i+1][j+1] = true; count++; //아래
                }
                
        for(int i=0; i<answer.length; ++i)
            for(int j=0; j<answer[0].length(); ++j)
                if(search[i][j])
                {
                    temp[i][j] = ""; //2x2 원소 없애기
                }

        for(int i=0; i<answer.length-1; ++i)
            for(int j=0; j<answer[0].length(); ++j)
                if(search[i+1][j])
                    temp[i+1][j] = temp[i][j];

        return 0;
    }

    public static void main(String[] args)
    {
        String[] temp = {"CCBDE","AAADE","AAABF","CCBBF"};
        System.out.println(removeBlock(temp));
    }
}
