package 카카오;

import java.util.Arrays;

public class 뉴스클러스터링
{
    public static String cluster(String str1, String str2)
    {
        str1 = str1.replaceAll("[ =+^*[0-9]]",""); //str1 특수문자 제거하기
        str2 = str2.replaceAll("[ =+^*[0-9]]",""); //str2 특수문자 제거하기

        String[] temp1 = new String[str1.length()-1]; //str1 쪼갠 임시 저장 변수
        for(int i=0; i<str1.length()-1; ++i)
                temp1[i] = str1.substring(i,i+2);

        String[] temp2 = new String[str2.length()-1]; //str2 쪼갠 임시 저장 변수
        for(int i=0; i<str2.length()-1; ++i)
                temp2[i] = str2.substring(i,i+2);

        boolean[] search = new boolean[temp2.length]; //탐색 변수

        int count =0; //같은거 수 세기
        for(int i=0; i<temp1.length; ++i)
            for (int j=0; j<temp2.length; ++j)
                if(temp1[i].equalsIgnoreCase(temp2[j]) && !search[j] ) {
                    count++;
                    search[j] = true;
                }
        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));
        System.out.println((double)count/(temp1.length+temp2.length-count));
        return String.format("%.0f",(double)count/(temp1.length+temp2.length-count)*65536);
    }

    public static void main(String[] args)
    {
        System.out.println(cluster("FRANCE","french"));
        System.out.println(cluster("handshake","shake hands"));
        System.out.println(cluster("aa1+aa2","AAAA12"));
        System.out.println(cluster("E=M*C^2","e=m*c^2"));
    }

}
