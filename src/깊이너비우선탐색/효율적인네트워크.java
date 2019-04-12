package 깊이너비우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적인네트워크 {

    static Node[] nodes;
    static boolean[] checkVisit;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        nodes = new Node[n+1];

        for (int i=0; i<m; ++i) {
            StringTokenizer forToken = new StringTokenizer(buffer.readLine());
            int a = Integer.parseInt(forToken.nextToken());
            int b = Integer.parseInt(forToken.nextToken());

            if (nodes[b] == null)
                nodes[b] = new Node(a,null);
            else {
                Node temp = nodes[b];
                while (temp.node != null)
                    temp = temp.node;
                temp.node = new Node(a,null);
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = 0;

        for (int i=1; i<nodes.length; ++i) {
            Node temp = nodes[i];
            checkVisit = new boolean[n+1];

            if (temp == null)
                continue;

            int num = checkSearchNode(nodes[i]);
            if (max <= num) {
                max = num;
                list.add(i);
            }
        }

        for (int i=0; i<list.size(); ++i)
            System.out.print((i+1)+" ");
    }

    public static int checkSearchNode(Node temp) {
        int sum = 1;

        if (temp != null && checkVisit[temp.data] )
            return 0;

        else if (temp != null && !checkVisit[temp.data]) {
            checkVisit[temp.data] = true;
        }

        if (temp == null)
            return sum;

        else {

            while (temp != null) {
                sum = checkSearchNode(nodes[temp.data])+1;
                temp = temp.node;
            }
            return sum;
        }

    }

}

class Node {
    int data;
    Node node;

    public Node(int data, Node node) {
        this.data = data;
        this.node = node;
    }
}
