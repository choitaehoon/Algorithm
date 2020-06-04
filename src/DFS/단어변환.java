package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단어변환 {

    public int solution(String begin, String target, String[] words) {

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        return recosion(begin,target,wordList,0);
    }

    public int recosion(String begin, String target, List<String> wordList, int stack){
        char[] beginList = begin.toCharArray();
        char[] targetList = target.toCharArray();
        int check = beginList.length-1;

        for(int i=0;i<wordList.size();i++){
            int count= 0;
            int targetcount = 0;
            char[] compare = wordList.get(i).toCharArray();

            for(int j=0;j<beginList.length;j++){
                if(beginList[j]==compare[j])
                    count++;

                if(beginList[j]==targetList[j])
                    targetcount++;

            }


            if(targetcount==check){
                stack++;
                return stack;
            }

            if(count==check){
                stack++;
                return recosion(wordList.remove(i), target, wordList, stack);
            }
        }

        return 0;

    }
}
