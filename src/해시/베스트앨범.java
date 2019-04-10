package 해시;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
//        String[] genres= {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};

        String[] genres = {"classic", "pop", "classic", "classic"};
        int[] plays = {800, 600, 150, 800};

        System.out.println(Arrays.toString(solution(genres, plays)));

    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        List<Album> albums = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Queue<Album> queue = new LinkedList<>();

        for (int i = 0; i < genres.length; ++i) {
            albums.add(new Album(genres[i], plays[i], i));
            map.put(genres[i], map.get(genres[i]) == null ? plays[i] : map.get(genres[i]) + plays[i]);
        }

        Collections.sort(albums);
        List<Compare> list = sortByValue(map);

        while (list.size() != 0) {
            Compare compare = list.remove(0);
            for (int i = 0; i < albums.size(); ++i)
                if (compare.key.equals(albums.get(i).id))
                    queue.offer(new Album(albums.get(i).id, albums.get(i).recycling, albums.get(i).number));
        }

        System.out.println(map);
        for (int i = 0; i < albums.size(); ++i)
            System.out.println(albums.get(i).id + " " + albums.get(i).recycling + " " + albums.get(i).number);

        Vector<Integer> vector = new Vector<>();
        while (!queue.isEmpty()) {
            int sum = 1;
            if (queue.size() != 0)
                vector.add(queue.peek().number);
            Album album = queue.poll();

            while (!queue.isEmpty()) {
                if (sum == 2)
                    break;

                if (sum != 2 || album.id.equals(queue.peek().id)) {
                    ++sum;
                    vector.add(queue.poll().number);
                }
                if (sum == 1 && !album.id.equals(queue.peek().id))
                    break;

            }

            for (Album album1 : queue)
                if (album.id.equals(album1.id)) {
                    queue.poll();
                    break;
                }
        }

        answer = new int[vector.size()];
        for (int i = 0; i < vector.size(); ++i)
            answer[i] = vector.get(i);

        return answer;
    }

    public static List sortByValue(Map<String,Integer> map) {

        List<Compare> list = new ArrayList();

        for (Map.Entry<String,Integer> maps : map.entrySet()) {
            list.add(new Compare(maps.getKey(),maps.getValue()));
        }

        Collections.sort(list);

        return list;
    }
}

class Album implements Comparable<Album> {
    String id;
    int recycling;
    int number;

    public Album(String id, int recycling, int number) {
        this.id = id;
        this.recycling = recycling;
        this.number = number;
    }

    @Override
    public int compareTo(Album o) {
        int r =  this.id.compareTo(o.id);
        if (r != 0) return r;
        int n = o.recycling - this.recycling;
        if (n != 0) return n;
        return this.number - o.number;
    }
}

class Compare implements Comparable<Compare> {
    String key;
    int value;

    public Compare(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Compare o) {
        return o.value - this.value;
    }
}