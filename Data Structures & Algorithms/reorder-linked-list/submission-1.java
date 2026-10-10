/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 2 4 6 8



class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = head;
        ListNode cur2 = reverse(slow);
        if(prev == null)
            return;
        prev.next = null;
        while(cur != null && cur2 != null){
            ListNode temp = cur.next;
            cur.next = cur2;
            ListNode temp2 = cur2.next;
            if(temp == null)
                break;
            cur2.next = temp;
            
            cur = temp;  
            cur2 = temp2;  
        }
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}