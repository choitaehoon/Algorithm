public class Sum
{
    public static int solution(int a, int b)
    {
        int sum=0;
        if(a<=b)
            for(int i=a; i<=b; ++i)
                sum +=i;
        else
            for(int j=a; j>=b; --j)
                sum +=j;
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(solution(3,5));
        System.out.println(solution(3,3));
        System.out.println(solution(5,3));
    }
}
