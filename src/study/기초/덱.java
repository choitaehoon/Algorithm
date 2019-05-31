package study.기초;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayDeque;
        import java.util.Deque;
        import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < number; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            String temp = token.nextToken();

            if (temp.equals("push_front"))
                deque.addFirst(Integer.parseInt(token.nextToken()));

            else if (temp.equals("push_back"))
                deque.addLast(Integer.parseInt(token.nextToken()));

            else if (temp.equals("pop_front"))
                System.out.println(deque.isEmpty() ? -1 : deque.removeFirst());

            else if (temp.equals("pop_back"))
                System.out.println(deque.isEmpty() ? -1 : deque.removeLast());

            else if (temp.equals("size"))
                System.out.println(deque.size());

            else if (temp.equals("empty"))
                System.out.println(deque.isEmpty() ? 1 : 0);

            else if (temp.equals("front"))
                System.out.println(deque.isEmpty() ? -1 : deque.getFirst());

            else
                System.out.println(deque.isEmpty() ? -1 : deque.getLast());
        }
    }
}
