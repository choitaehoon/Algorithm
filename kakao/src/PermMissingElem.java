import java.util.Arrays;

public class PermMissingElem
{
    public static int solution(int[] a)
    {
        Arrays.sort(a);
        int count=1;
        for(int i=0; i<a.length; ++i)
            if(a[i] != count)
                return count;
            else
                ++count;
            return 0;
    }

    public static void main(String[] args)
    {
        int[] temp = {2,3,1,5};
        System.out.println(solution(temp));
    }
}
