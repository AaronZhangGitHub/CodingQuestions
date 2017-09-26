public class ReverseListRecursive {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp = reverseList(head.next); //this returns next node
        //head has current node
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
