package medium;

import java.util.*;

public class Main684 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection1(
                new int[][]{{1, 2}, {1, 3}, {2, 3}}
        )));
    }


    public static int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= 1000; ++i)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            Set<Integer> set = new HashSet<>();

            if (!graph.get(edge[0]).isEmpty() && !graph.get(edge[1]).isEmpty() &&
                    edgesDFS(edge[0], edge[1], set, graph)) {
                return edge;
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        throw new AssertionError();
    }

    private static boolean edgesDFS(int lineA, int lineB,  Set<Integer> set, List<List<Integer>> graph) {
        if (!set.contains(lineA)) {
            set.add(lineA);

            if (lineA == lineB) return true;
            for (int value : graph.get(lineA)) {
                if (edgesDFS(value, lineB, set, graph)) return true;
            }
        }

        return false;
    }

    public static int[] findRedundantConnection1(int[][] edges) {
        DSU dsu = new DSU(1000 + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError();
    }

}

class DSU {
    int[] parent;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;

    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        }

        parent[xr] = yr;

        return true;
    }
}