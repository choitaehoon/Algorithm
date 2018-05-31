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

    static void sortByCount(ArrayList<WordInfo> a) { //bubble sort
        for(int i=a.size()-1; i>0; --i)
            for(int j=0; j<a.size()-1; ++j)
            {
                WordInfo value1 = a.get(j);
                WordInfo value2 = a.get(j+1);

                if(value1.getWord().compareTo(value2.getWord()) >0)
                {
                    a.set(j,value2);
                    a.set(j+1,value1);
                }
            }
    }

    // 단어 목록에서 단어를 찾는 작업을 이진 탐색으로 구현하라.
    public static int binarySearch(ArrayList<WordInfo> a,int start, int end, String search) //재귀 호출
    {
        if(start >= end) return -1; //없다면 -1
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

        sortByCount(a); //오름차순
        System.out.println(a);
        System.out.println("a배열 위치는"+binarySearch(a,0,a.size(),"a")+"입니다.");
        System.out.println("o배열 위치는"+binarySearch(a,0,a.size(),"o")+"입니다.");
        System.out.println("z배열 위치는"+binarySearch(a,0,a.size(),"z")+"입니다.");
    }
}