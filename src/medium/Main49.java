package medium;

import java.util.*;

public class Main49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(
                new String[]{"eat","tea","tan","ate","nat","bat"}
        ));
        System.out.println(groupAnagrams(
                new String[]{"a"}
        ));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupStr = new HashMap<>();

        for (String strValue : strs) {
            String[] sortStrValue = strValue.split("");
            Arrays.sort(sortStrValue);
            StringBuilder sortMix = new StringBuilder();

            for (String sortValue : sortStrValue)
                sortMix.append(sortValue);

            List<String> groupAdd = groupStr.getOrDefault(sortMix.toString(), new ArrayList<>());

            groupAdd.add(strValue);

            groupStr.put(sortMix.toString(), groupAdd);
        }

        return new ArrayList<>(groupStr.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> groupStr = new HashMap<>();

        for (String strValue : strs) {
            char[] strValueChar = strValue.toCharArray();
            Arrays.sort(strValueChar);
            String key = String.valueOf(strValueChar);

            List<String> storeGroup = groupStr.getOrDefault(key, new ArrayList<>());
            storeGroup.add(strValue);
            groupStr.put(key, storeGroup);
        }

        return new ArrayList<>(groupStr.values());
    }

}
