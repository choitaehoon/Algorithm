import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("all")
public class 암호만들기 {

    static int l;
    static int c;
    static String[] alphabet;
    static StringBuilder builder = new StringBuilder();
    static List<String> list = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        l = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        alphabet = new String[c];
        check = new boolean[c];

        StringTokenizer alpha = new StringTokenizer(buffer.readLine());

        for (int i=0; i<c; ++i)
            alphabet[i] = alpha.nextToken();


        getCode(0,0,0,"");

        Collections.sort(list);
        for (int i=0; i<list.size(); ++i)
            builder.append(list.get(i)).append("\n");

        System.out.println(builder);
    }

    //알파벳 개수, 자음, 모음, 알파벳 만든 문자
    private static void getCode(int alphabetNumber, int consonant, int vowel, String text) {
        check[alphabetNumber] = true;
        System.out.println(alphabetNumber);

        if (alphabetNumber == l){
            if (consonant >= 2 && vowel >= 1){
                char[] temp = text.toCharArray();
                Arrays.sort(temp);
                for (char i : temp)
                    builder.append(i);
                list.add(builder.toString());
                builder.setLength(0);
            }
                return;
        }

        for (int i = alphabetNumber +1 ; i < c; ++i) {
            if (!check[i] && (alphabet[i].equals("a") || alphabet[i].equals("e") || alphabet[i].equals("i") || alphabet[i].equals("o") || alphabet[i].equals("u")) ) {
                check[i] = true;
                getCode(i, consonant, vowel+1, text+alphabet[i]);
            }
            else if (!check[i]){
                check[i] = true;
                getCode(i,consonant+1, vowel, text+alphabet[i]);
            }

        }

        check[alphabetNumber] = false;
    }

}
