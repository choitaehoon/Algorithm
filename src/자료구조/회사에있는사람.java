package 자료구조;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 회사에있는사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        Map<String, Boolean> person = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            String[] word = buffer.readLine().split(" ");
            String name = word[0];
            String log = word[1];

            if (log.equals("enter")) {
                if (!person.containsKey(name)) {
                    person.put(name, true);
                } else {
                    removePerson(person, name);
                }
            } else {
                removePerson(person, name);
            }
        }

        List<Map.Entry<String, Boolean>> result = new ArrayList<>(person.entrySet());
        result.sort((a1, a2) -> a2.getKey().compareTo(a1.getKey()));

        for (Map.Entry<String, Boolean> stringBooleanEntry : result) {
            System.out.println(stringBooleanEntry.getKey());
        }
    }

    public static void removePerson(Map<String, Boolean> person, String name) {
        if (person.containsKey(name)) {
            person.remove(name);
        }
    }

}
