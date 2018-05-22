public class PermCheck
{
    public static int check(int a[])
    {
        long total = 0; //총합
        long sum =0; //원소안에 들어있는 수의 합

        for(int i=1; i<a.length+1; ++i)
            total += i;

        for(int i=0; i<a.length; ++i)
            sum += a[i];

        if(total == sum)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args)
    {
        int[] temp ={1,4,1};
        System.out.println(check(temp));
    }
}
