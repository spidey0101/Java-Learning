public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val){
        this val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode new_head = ListNode(0);
        ListNode to_return = new_head;

        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                to_return.next = temp2;
                temp2 = temp2.next;
            } else {
                to_return.next = temp1;
                temp1 = temp1.next;
            }
        }

        while (temp1 != null) {
            to_return.next = temp1;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            to_return.next = temp2;
            temp2 = temp2.next;
        }

        return new_head.next;
    }
}