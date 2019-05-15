package 알고리즘중급.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 로또 {

    static int givenNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            String[] temp = buffer.readLine().split(" ");
            givenNumber = Integer.parseInt(temp[0]);

            List<String> list = new ArrayList<>();
            recursive(list, 1, "", temp, 0);

            for (String data : list)
                writer.write(data.trim()+"\n");
            writer.write("\n");
        }while (givenNumber != 0);

        writer.close();
    }

    static void recursive(List<String> list, int index, String temp, String[] store, int sum) {
        if (sum == 6) {
            list.add(temp);
            return;
        }

        if (index < givenNumber+1) {
            recursive(list, index+1, temp+store[index]+" ",store,sum+1);
            recursive(list,index+1,temp,store,sum);
        }
    }

}
