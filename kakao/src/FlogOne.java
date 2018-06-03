import java.util.Arrays;

public class FlogOne
{
    public static int jump(int x,int[] a)
    {
        int[] temp = new int[x+1];
        int count =0;

        for(int i=0; i<a.length; ++i)
        {
        if(temp[a[i]] == 0)
        {
            temp[a[i]] = a[i];
            count ++;
        }
        if(count == temp.length-1)
            return i;
    }
        return -1; //절대로 도달할 수 없을때
    }

    public static void main(String[] args)
    {
//        int[] a = {1,3,1,4,2,3,5,4};
        int[] a = {2,2,2,2,2,2};
        System.out.println(jump(2,a));
    }
}
