package solve;

import java.util.Arrays;

// inging...
public class 길찾기게임 {

    static Node node;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}
        )));
    }

    public static int[][] solution(int[][] nodeinfo) {
        int x = 0;
        int y = 0;

        for (int i=0; i<nodeinfo.length; ++i) {
            x = Math.max(nodeinfo[i][1], x);
            y = Math.max(nodeinfo[i][0], y);
        }

        x += 1;
        y += 1;

        int[][] newArray = createArray(x, y, nodeinfo);

        createNode(newArray);

        int[][] answer = {};
        return answer;
    }

    private static int[][] createArray(int x, int y, int[][] nodeInfo) {
        int[][] newArray = new int[x][y];

        x -= 1;

        for (int i=0; i<nodeInfo.length; ++i) {
            newArray[x - nodeInfo[i][1]][nodeInfo[i][0]] = i + 1;
        }

        return newArray;
    }

    private static void createNode(int[][] newArray) {

        for (int i=0; i<newArray.length; ++i) {
            for (int z=0; z<newArray[i].length; ++z) {
                if (i == 0 && newArray[i][z] > 0) {
                    addNode(newArray[i][z]);
                }
            }
        }

    }

    private static void addNode(int value) {
        if (node == null) {
            node = new Node(value, null, null);
        }
    }

}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}