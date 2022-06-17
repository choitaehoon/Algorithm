package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        List<Integer> store = new ArrayList();

        ListNode search = list1;
        while(search != null) {
            store.add(search.val);
            search = search.next;
        }

        search = list2;
        while(search != null) {
            store.add(search.val);
            search = search.next;
        }

        int storeSize = store.size();
        Collections.sort(store);
        ListNode result = new ListNode(store.get(0));
        search = result;

        for (int i = 1; i < storeSize; ++i) {
            search.next = new ListNode(store.get(i));
            search = search.next;
        }

        return result;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }