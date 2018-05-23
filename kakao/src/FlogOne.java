import java.util.Arrays;

public class FlogOne
{
    public static int jump(int x,int[] a)
    {
        int[] temp = new int[a.length];//값을 넣어 체크하기
        int count = 0;
        for(int i=0; i<a.length; ++i) //temp에다가 그자리에 해당하는 값 넣기
            if(temp[a[i]-1] == 0)
            {
                temp[a[i]-1] = a[i];
                ++count;
            }
        for(int i=0; i<a.length; ++i)
            if(count == x && a[i] == x)
                return i;
        return -1;
    }

    public static void main(String[] args)
    {
        int[] a = {1,3,1,4,2,3,5,4};
        System.out.println(jump(5,a));
    }
}
