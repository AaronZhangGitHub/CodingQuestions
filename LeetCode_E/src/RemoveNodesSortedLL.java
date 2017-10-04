public class RemoveNodesSortedLL {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headPointer = head;
        if(head==null){
            return null;
        }
        while(head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }else{
                head = head.next;
            }
            //head.next could now be null
            if(head==null){
                break;
            }
        }
        return headPointer;
    }
}
