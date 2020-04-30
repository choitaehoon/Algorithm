package kakao;

import java.util.Arrays;
import java.util.Stack;

public class 크레인인형뽑기게임 {

    static int[][] doll;
    static int len;
    static Stack<Integer> pullDoll = new Stack<>();
    static int removeDollCount;

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ));
    }

    public static int solution(int[][] board, int[] moves) {
        len = board.length;
        doll = new int[len][len];

        dollAdd(board);
        dollMoveStack(moves);

        return removeDollCount;
    }

    private static void dollMoveStack(int[] moves) {

        for (int index = 0; index < moves.length; ++index) {
            int high = moves[index] - 1;
            for (int width = 0; width < len; ++width) {
                if (doll[width][high] != 0) {

                    pullDoll.push(doll[width][high]);
                    doll[width][high] = 0;

                    while (true) {

                        if (pullDoll.empty() || pullDoll.size() == 1) {
                            break;
                        }

                        int preOne = pullDoll.pop();
                        int postTwo = pullDoll.pop();

                        if (preOne == postTwo) {
                            removeDollCount += 2;
                        } else {
                            pullDoll.push(postTwo);
                            pullDoll.push(preOne);
                            break;
                        }
                    }

                    break;
                }

            }
        }

    }

    private static void dollAdd(int[][] board) {

        for (int width = 0; width < len; ++width) {
            for (int high = 0; high < len; ++high) {
                doll[width][high] = board[width][high];
            }
        }

    }

}
