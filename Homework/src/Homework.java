import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class Homework
{
    static final String 텍스트파일 = "c:/shakespeare.txt";

    static String getWord(Reader reader) throws IOException {
        int ch;
        StringBuilder builder = new StringBuilder();
        while ((ch = reader.read()) != -1) {
            if (Character.isAlphabetic(ch))
                builder.append((char)ch);
            else
            if (builder.length() > 0) break;
        }
        if (builder.length() > 0) return builder.toString();
        else return null;
    }

    static void sortByCountDesc(ArrayList<WordInfo> a) { //내림차순 정렬
        for (int i = 1; i < a.size(); ++i) {
            WordInfo value = a.get(i);
            int j;
            for (j = i - 1; j >= 0; --j)
                if (a.get(j).count < value.count)
                    a.set(j + 1, a.get(j));
                else break;
            a.set(j + 1, value);
        }
    }

    public static int binarySearch(ArrayList<WordInfo> a,int start, int end, String search) //재귀 호출
    {
        if(start > end) return -1;//없다면 -1
        else //있다면
        {
            int middle = (start+end)/2;
            if(a.get(middle).getWord().equals(search))
                return middle;
            else if(a.get(middle).getWord().compareTo(search) >0)
                return binarySearch(a,start,middle,search);
            else
                return binarySearch(a,middle+1,end,search);
        }
    }

    static WordInfo findWord(ArrayList<WordInfo> list, String word) {
        for (int i = 0; i < list.size(); ++i)
            if (list.get(i).word.equals(word))
                return list.get(i);
        return null;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(텍스트파일));
        ArrayList<WordInfo> a = new ArrayList<WordInfo>();
        String word;
        while ( (word = getWord(reader)) != null) {
            word = word.toLowerCase();
            WordInfo wordInfo = findWord(a, word);
            if (wordInfo != null)
                wordInfo.count++;
            else
                a.add(new WordInfo(word, 1));
        }

        sortByCountDesc(a);
        System.out.println(a);
        System.out.println("e의 위치는"+binarySearch(a,0,a.size(),"e"));
    }
}
//출력 결과는 e 447204 t 329775 o 314600 a 289150 i 253990 s 248989 n 243262 r 23786 h 236868 l 170019