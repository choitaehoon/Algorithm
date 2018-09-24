<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test
{
    public static void main(String[] args) throws IOException
    {

    }
}

=======
package 카카오;

import java.util.Arrays;

public class Test
{
    public static String cluster(String str1, String str2)
    {
        String regex1 = str1.replaceAll("[ =+^*0-9]","");//str1의 특수 문자, 숫자를 공백으로 변환
        String regex2 = str2.replaceAll("[ =+^*0-9]","");//str2의 특수 문자, 숫자를 공백으로 변환

        String[] temp1 = new String[regex1.length()-1];
        String[] temp2 = new String[regex2.length()-1];

        for(int i=0; i<regex1.length()-1; ++i)
            temp1[i] = regex1.substring(i,i+2);

        for(int i=0; i<regex2.length()-1; ++i)
            temp2[i] = regex2.substring(i,i+2);

        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));

        int count =0; //같은거 수세기
        boolean[] search = new boolean[temp2.length];//탐색 원소

        for(int i=0; i<temp1.length; ++i)
            for(int j=0; j<temp2.length; ++j)
                if(temp1[i].equalsIgnoreCase(temp2[j]) && !search[j])
                {
                    count++;
                    search[j] = true;
                    break;
                }
        return String.format("%.0f",(double)count/(temp1.length+temp2.length-count)*65536);
    }

    public static void main(String[] args)
    {
//        System.out.println(cluster("E=M*C^2","e=m*c^2"));
        System.out.println(cluster("handshake","shake hands"));
    }
}
>>>>>>> 378f4c8f1557ce47a77aa4108a74930964ede4e8
