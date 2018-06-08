import java.util.HashSet;
import java.util.Set;

public class Distinct
{
    public static int solution(int[] A)
    {
        Set<Integer> nums = new HashSet<>();
        for(int i=0; i<A.length; ++i)
            nums.add(A[i]);
        return nums.size();
    }

    public static void main(String[] args)
    {
        int[] a = {1,1,1,1,2,3,3,4,4};
        System.out.println(solution(a));
    }
}
