import java.util.ArrayList;
import java.util.HashMap;

public class Compress
{
    static HashMap<String,Integer> hash = new HashMap<>(); //key-value 저장
    static ArrayList<Integer> array = new ArrayList<>(); //출력 저장
    static int count =0; //수 세기

    public static int[] compress(String temp)
    {
        //합친게 값이 있다면 그 값 사용하고, 없다면 그 한 글자만 사용하고 두 수를 더해 HashMap에 저장 한다.
        for(int i=0; i<temp.length()-2; ++i)
        {
            
        }
    }

    public static void main(String[] args)
    {
        for(int i=0; i<26; ++i)
            hash.put(String.valueOf((char)(i+65)),++count); //해쉬 함수에 1~26저장
        compress("kakao");
    }
}
