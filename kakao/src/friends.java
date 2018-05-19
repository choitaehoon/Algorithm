import java.util.Arrays;

public class friends
{
    public static int removeBlock(String[] answer)
    {
        int count =0; //없어진 갯수 세기.
        boolean check=true; //없어지는게 있는지 검사하는 변수 (만일 없어지는게 있으면 false로 지정)
        int count123 = 0;
        String[][] temp = new String[answer.length][answer[0].length()];//저장 변수
        boolean[][] search = new boolean[answer.length][answer[0].length()]; //탐색 변수

        for(int i=0; i<answer.length; ++i)//temp에 대입함
            for(int j=0; j<answer[0].length(); ++j)
                temp[i][j] = answer[i].substring(j,j+1);

        while(check)
        {

            for(int i=0; i<answer.length/2; ++i)
                for (int j=0; j<answer[0].length()-1; ++j)
                    if(answer[i].substring(j,j+1).equalsIgnoreCase(answer[i].substring(j+1,j+2)) && (answer[i+1].substring(j,j+1).equalsIgnoreCase(answer[i].substring(j,j+1)) &&
                            answer[i+1].substring(j+1,j+2).equalsIgnoreCase(answer[i].substring(j,j+1))))
                    {
                        //같으면 탐색변수에 true로 저장
                        //중복된거 체크해야 하므로 false껏만 검사

                        if(!search[i][j]){search[i][j] = true; count++;} if(!search[i][j+1]){search[i][j+1] = true; count++;}//위
                        if(!search[i+1][j]) {search[i+1][j] =true; count++;} if (!search[i+1][j+1]){search[i+1][j+1] = true; count++;} //아래
                    }

            for(int i=0; i<answer.length; ++i)
                for(int j=0; j<answer[0].length(); ++j)
                    if(search[i][j])
                        temp[i][j] = ""; //2x2 원소 없애기


            for(int i=0; i<answer.length-1; ++i) //원소 이동
                for(int j=0; j<answer[0].length(); ++j)
                    if(search[i+1][j])
                    {
                        temp[i+1][j] = temp[i][j];
                        temp[i][j]="";
                    }

            //없어 졌는지 검사(안 없어 졌다면 없어질거 없다는 이야기)
            loop:for(int i=0; i<answer.length; ++i)
            {
                for(int j=0; j<answer[0].length(); ++j)
                    if(search[i][j])
                    {
                        check = false; //맨마지막에 오면 없어진게 없으니까 false로 지정하여 반복 실행 x
                        break loop;
                    }
            }

            for(int i=0; i<answer.length; ++i) //다시 블록 없어진거 확인해야 하니까 초기화
                for(int j=0; j<answer[0].length(); ++j)
                    search[i][j] = false;
        }

        return count;
    }

    public static void main(String[] args)
    {
        String[] temp = {"CCBDE","AAADE","AAABF","CCBBF"};
        System.out.println(removeBlock(temp));
    }
}
