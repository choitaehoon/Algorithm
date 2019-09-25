import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 암호만들기다시 {

    static int l;
    static int c;
    static String[] alphabet;
    static List<String> alphabetList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        l = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        alphabet = new String[c];

        //배열 삽입
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<c; ++i)
            alphabet[i] = tokenizer.nextToken();

        //정렬
        Arrays.sort(alphabet);
        recursiveAlphabet(0,0,0,"", 0);

        for (int i=0; i<alphabetList.size(); ++i)
            System.out.println(alphabetList.get(i));
    }

    private static void recursiveAlphabet(int index, int vowel, int consonant, String text, int count) {
        if (count == l){
            if (vowel >= 1 && consonant >=2)
                alphabetList.add(text);
            return;
        }

        if (index >= c)
            return;

        if (alphabet[index].equals("a") || alphabet[index].equals("e") || alphabet[index].equals("i") || alphabet[index].equals("o") || alphabet[index].equals("u"))
            recursiveAlphabet(index+1, vowel+1, consonant, text+alphabet[index], count+1);
        else
            recursiveAlphabet(index+1,vowel,consonant+1,text+alphabet[index],count+1);
        recursiveAlphabet(index+1,vowel,consonant,text,count);
    }

}
