public class RemoveNthNodeFromEnd {
    /*
    https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //given n is always valid
        if(head==null || head.next==null){
            return null;
        }
        //{1,2}, 2
        ListNode newHeadReference = new ListNode(0);
        newHeadReference.next = head;
        ListNode pointer1 = newHeadReference;
        ListNode pointer2 = newHeadReference;
        for (int i = 0; i < n; i++) {
            //iterate pointer 1
            pointer1 = pointer1.next;
        }
        //0p2->1->2p1
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        //next node from pointer 2 is the node to remove
        pointer2.next = pointer2.next.next;
        return newHeadReference.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
