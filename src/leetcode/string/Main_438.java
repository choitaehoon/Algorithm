package leetcode.string;

import java.util.*;

public class Main_438 {

    public static void main(String[] args) {
        System.out.println(
                findAnagrams(
                        "cbaebabacd",
                        "abc"
                )
        );
    }

    public static List<Integer> findAnagrams(String s, String p) {

        int ns = s.length();
        int np = p.length();

        if(np > ns) return new ArrayList<>();

        List<Integer> ans = new ArrayList<Integer>();

        int pArr[] = new int[26];
        int sArr[] = new int[26];


        for(int i=0; i < np; i++){

            pArr[p.charAt(i)-'a']++;
            sArr[s.charAt(i)-'a']++;
        }

        int i = 0;

        for(i=0; i < ns-np; i++){

            if(checkAnagram(pArr, sArr)){

                ans.add(i);
            }

            sArr[s.charAt(i)-'a']--;
            sArr[s.charAt(i+np)-'a']++;
        }

        if(checkAnagram(pArr, sArr)){

            ans.add(i);
        }

        return ans;

    }

    private static boolean checkAnagram(int[] pArr, int[] sArr){

        for(int i=0; i < pArr.length; i++){

            if(pArr[i]!=sArr[i]){

                return false;
            }
        }
        return true;
    }
}
