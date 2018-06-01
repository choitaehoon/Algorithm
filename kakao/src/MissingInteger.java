import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MissingInteger
{
    public static int search(int...a)
    {
        int[] temp = new int[a.length]; //임시 저장 배열
        for(int i=0; i<a.length; ++i)
            if(a[i] <= 0) //음수인 수가 올때
                continue;
            else //양수인 수가 올때
                temp[a[i]-1] = a[i];

        if(temp[0] == 0) //맨처음이 0이라면 음수만 나온 경우
             return 1;

        for(int i=0; i<temp.length; ++i)
            if(temp[i] != i+1)
                return i+1;
        return temp.length+1; //배열이 알맞게 들어가고 모든 수가 알맞게 다들어간 경우
    }

    public static void main(String[] args)
    {
        int [] a = {15,88,33,2};
        System.out.println(search(a));
    }
}
