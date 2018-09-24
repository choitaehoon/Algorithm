import java.util.Arrays;

public class PermMissingElem
{
    public static int solution(int[] a)
    {
        long total = 0;//총 합
        long sum = 0; //원소에 들어있는 수

        for(int i=0; i<a.length+1; ++i)
            total += i+1;
        for(int i=0; i<a.length; ++i)
            sum += a[i];

        return (int)(total - sum);
    }

    public static void main(String[] args)
    {
        int[] temp = {2,3,1,5};
        System.out.println(solution(temp));
    }
}
