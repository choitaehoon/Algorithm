package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main609 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(
                new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}
        ));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contextPath = new HashMap<>();

        for (String value : paths) {
            String[] temp = value.split(" ");
            Pattern pattern = Pattern.compile("\\([^)]+");

            for (int i = 1; i < temp.length; ++i) {
                Matcher matcher = pattern.matcher(temp[i]);
                while (matcher.find()) {
                    String key = matcher.group();
                    int end = temp[i].indexOf('(');
                    List<String> directory = contextPath.getOrDefault(key, new ArrayList<>());
                    directory.add(temp[0]+"/"+temp[i].substring(0, end));
                    contextPath.put(key, directory);
                }
            }

        }

        List<List<String>> result = new ArrayList<>();
        for (String key : contextPath.keySet()) {
            if (contextPath.get(key).size() > 1)
                result.add(contextPath.get(key));
        }

        return result;
    }

}
