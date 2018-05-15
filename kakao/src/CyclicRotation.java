import java.util.Arrays;

public class CyclicRotation
{
    public static void rotattion(int[] temp, int k)
    {
        int put = 0;//임시저장변수
        for(int j=0; j<k; ++j)
        {
            put = temp[temp.length-1];
            for(int i=temp.length-1; i>0; --i)
                temp[i] = temp[i-1];
            temp[0] = put;
            System.out.println(Arrays.toString(temp));
        }
    }

    public static void main(String[] args)
    {
        //    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
        //    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
        //    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
        int[] a = {3,8,9,7,6};
        rotattion(a,3);
    }
}
