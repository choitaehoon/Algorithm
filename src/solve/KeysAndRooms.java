package solve;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

    Set<Integer> roomVisit = new HashSet<>();
    List<List<Integer>> room;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        room = rooms;
        if (rooms == null || rooms.size() == 0) return false;

        if (rooms.size() == 1) return true;

        roomVisit.add(0);
        keySearch(rooms.get(0));

        return roomVisit.size() == rooms.size();
    }

    private void keySearch(List<Integer> keys) {
        for (Integer key : keys) {
            if (!roomVisit.contains(key)) {
                roomVisitAdd(key);
            }
        }
    }

    private void roomVisitAdd(Integer key) {
        roomVisit.add(key);
        keySearch(room.get(key));
    }
}
