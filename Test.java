import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{
    public static void main(String[] args) {
        for (int i=0; i<4; ++i)
            for (int j=1; j<4; ++j)
            {
                if (j == 1)
                    continue;
                else
                    System.out.println("gg");
            }
    }
}