package medium;

import java.util.Arrays;
import java.util.List;

public class Main841 {

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(
                Arrays.asList(Arrays.asList(1,3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))
        ));
//        System.out.println(canVisitAllRooms(
//                Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())
//        ));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] searchRooms = new boolean[rooms.size()];

        for (int i = 0; i < rooms.get(0).size(); ++i) {
            int roomsKey = rooms.get(0).get(i);
            if (!searchRooms[roomsKey]) {
                recursiveRoomsKey(roomsKey, searchRooms, rooms);
            }
        }

        System.out.println(Arrays.toString(searchRooms));

        for (int i = 1; i < rooms.size(); ++i) {
            if (!searchRooms[i])
                return false;
        }

        return true;
    }

    private static void recursiveRoomsKey(int roomsKey, boolean[] searchRooms, List<List<Integer>> rooms) {
        searchRooms[roomsKey] = true;

        for(int i = 0; i < rooms.get(roomsKey).size(); ++i) {
            if (!searchRooms[rooms.get(roomsKey).get(i)]) {
                recursiveRoomsKey(rooms.get(roomsKey).get(i), searchRooms, rooms);
            }
        }

    }

}
