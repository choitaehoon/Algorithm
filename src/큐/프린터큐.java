//package 큐;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class 프린터큐 {
//
//    public static int n;
//    public static int m;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        int testCase = Integer.parseInt(buffer.readLine());
//
//        for (int i=0; i<testCase; ++i) {
//            StringTokenizer token = new StringTokenizer(buffer.readLine());
//            StringTokenizer importanceToken = new StringTokenizer(buffer.readLine());
//
//            n = Integer.parseInt(token.nextToken());
//            m = Integer.parseInt(token.nextToken());
//            Queue<stock> queue = new LinkedList<>();
//
//            for (int j=0; j<n; ++j)
//                queue.offer(new stock(j,Integer.parseInt(importanceToken.nextToken())));
//
//            System.out.println(findOutHowManyTimes(queue));
//        }
//    }
//
//    public static int findOutHowManyTimes(Queue<stock> queue) {
//        int sum = 1;
//
//        while (true) {
//            if (identifyHigherImportance(queue)) {
//                if (queue.poll().document == m)
//                    return sum;
//                else
//                    ++sum;
//            }
//        }
//    }
//
//    public static boolean identifyHigherImportance(Queue<stock> queue) {
//        Iterator<stock> iterator = queue.iterator();
//        int importance = iterator.next().importance;
//        while (iterator.hasNext())
//            if (importance < iterator.next().importance) {
//                queue.offer(queue.poll());
//                return false;
//            }
//
//        return true;
//    }
//}
//
//class Pair {
//    int document;
//    int importance;
//
//    public Pair(int document, int importance) {
//        this.document = document;
//        this.importance = importance;
//    }
//}
