package 알고리즘중급.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 암호만들기 {

    static int l;
    static int c;
    static String[] array;
    static List<String> list = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        l= Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        array = new String[c];
        check = new boolean[c];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<c; ++i)
            array[i] = tokenizer.nextToken();

        Arrays.sort(array);

        recursive(0,0,0,"",0);

        for (String data : list)
            writer.write(data+"\n");
        writer.close();

        System.out.println(writer);
    }

    static void recursive(int index, int vowel,int consonant, String temp, int sum) {

        if (sum == l) {
            if (vowel < 1 || consonant < 2) return;
            list.add(temp);
            return;
        }

        if (index == c)
            return;

        String store = array[index];
        if (store.equals("a") || store.equals("e") || store.equals("i") || store.equals("o") || store.equals("u"))
            recursive(index+1, vowel+1,consonant,temp+store, sum+1);
        else
            recursive(index+1, vowel,consonant+1,temp+store,sum+1);
        recursive(index+1,vowel,consonant,temp,sum);

    }

}
