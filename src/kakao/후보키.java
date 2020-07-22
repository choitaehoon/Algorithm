package kakao;


import java.util.*;

public class 후보키 {

    public static void main(String[] args) {
        System.out.println(solution(
                new String[][]{
                        {"100","ryan","music","2"} , {"200","apeach","math","2"} ,
                        {"300","tube","computer","3"}, {"400","con","computer","4"} ,
                        {"500","muzi","music","3"}, {"600","apeach","music","2"}
        }));
    }
    public static int solution(String[][] relation) {

        int answer = 0;
        int ySize = relation.length;
        int xSize = relation[0].length;
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i < (1 << xSize); i++) {
            if (check(i, relation, ySize, xSize)) {
                list.add(i);
            }
        }

        System.out.println(list);

        while (list.size() != 0) {
            int n = list.remove(0);
            answer++;

            list.removeIf(c -> (n & c) == n);
        }

        return answer;
    }

    static boolean check(int subset, String[][] relation, int ySize, int xSize) {

        for (int y = 0; y < ySize - 1; y++) {
            for (int yy = y + 1; yy < ySize; yy++) {

                boolean isSame = true;

                for (int k = 0; k < xSize; k++) {
                    if ((subset & 1 << k) == 0) {
                        continue;
                    }
                    System.out.println(relation[y][k]+" "+relation[yy][k]+" "+relation[y][k].equals(relation[yy][k]));
                    if (!relation[y][k].equals(relation[yy][k])) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    return false;
                }
            }
        }
        return true;
    }

}