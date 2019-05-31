package study.기초;

import java.io.*;

public class ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] small = new char[26];
        char[] upper = new char[26];

        for (int i=0; i<26; ++i)
            small[i] = (char) (97+i);

        for (int i=0; i<26; ++i)
            upper[i] = (char)(65+i);

        for (char data : buffer.readLine().toCharArray()){
            if (65 <= data && data <= 90) {
                writer.write(upper[(data - 'A'+13)%26]+"");
                continue;
            }
            else if (97 <= data && data <= 122) {
                writer.write(small[(data - 'a'+13)%26]+"");
                continue;
            }

            writer.write(data);
        }

        writer.close();
    }
}
