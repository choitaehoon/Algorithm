public class Flog
{
    public static int jump(int x, int y, int d)
    {
        //시간 복잡도 O(1)
        if((y-x)%d == 0)
            return (y-x)/d;
        else
            return (y-x)/d+1;
    }

    public static void main(String[] args)
    {
        System.out.println(jump(10,85,30));
    }
}
