import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Homework
{
    static final String 텍스트파일 = "C:\\Users\\xogns\\shakespeare.txt";

    static String getWord(Reader reader) throws IOException {
        int ch;
        StringBuilder builder = new StringBuilder();
        while ((ch = reader.read()) != -1) {
            if (Character.isAlphabetic(ch))
                builder.append((char) ch);
            else if (builder.length() > 0)
                break;
        }
        if (builder.length() > 0)
            return builder.toString();
        else
            return null;
    }

    //내림차순으로 정렬
    static void sortByCount(ArrayList<WordInfo> a) { // bubble sort
        for (int i = a.size() - 1; i > 0; --i)
        {
            boolean temp =true;
            for (int j = 0; j <i; ++j)
            {
                WordInfo value1 = a.get(j);
                WordInfo value2 = a.get(j + 1);
                if (value1.count < value2.count) {
                    WordInfo tt = a.get(j);
                    a.set(j, value2);
                    a.set(j + 1, tt);
                    temp = false;
                }
            }
            if(temp == true) break;
        }
    }

    // 단어 목록에서 단어를 찾는 작업을 이진 탐색으로 구현하라.
    public static WordInfo binarySearch(ArrayList<WordInfo> a, int start, int end, String search) // 재귀 호출
    {
        if (start > end)
            return null; // 없다면 null
        else // 있다면
        {
            int middle = (start + end) / 2;
            if (a.get(middle).word.equals(search))
                return a.get(middle);
            else if (a.get(middle).word.compareTo(search) < 0)
                return binarySearch(a, middle+1, end, search);
            else
                return binarySearch(a, start, middle-1, search);
        }
    }

    static WordInfo findWord(ArrayList<WordInfo> list, String word) { // 이진탐색으로 word찾기
        return binarySearch(list, 0, list.size()-1, word) == null ? null : binarySearch(list, 0, list.size(), word);
    }

    static void sortAdd(List<WordInfo> list, WordInfo w)
    {
        if(list.size() == 0) list.add(0, w); //이 조건이 없으면 arrayIndexOutofBoundsExeption 에러 난다.
        else
            for(int i=0; i<list.size(); ++i)
                if(list.get(i).compareTo(w)>0)
                {
                    list.add(i, w);
                    break; //break를 안하면 그 뒤에도 검사해서 시간이 많이 걸린다.
                }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(텍스트파일));
        ArrayList<WordInfo> a = new ArrayList<WordInfo>();
        String word;
        while ((word = getWord(reader)) != null) {
            word = word.toLowerCase();
            WordInfo wordInfo = findWord(a, word);
            if (wordInfo != null) //찾았으면 count하기
                wordInfo.count++;
            else //못찾았으면 단어 새단어 등록(미리 정렬하면서 list에 넣기)
                sortAdd(a,new WordInfo(word,1));
        }

        sortByCount(a); // 내림차순
        for (int i = 0; i < 10; ++i) // 선두 10 개 단어 출력
            System.out.printf("%s %d\n", a.get(i).word, a.get(i).count);
    }
}