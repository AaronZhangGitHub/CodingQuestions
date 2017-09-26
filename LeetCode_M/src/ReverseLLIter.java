public class ReverseLLIter {
    //https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }
        //1->2->null
        //head = node 1
        ListNode previousNode = null;
        ListNode currentNode = head;// node 1
        while(currentNode!=null){
            ListNode nextNode=currentNode.next;//node null
            currentNode.next=previousNode;//2->1->null
            previousNode=currentNode;//node 2
            currentNode=nextNode;//node null
        }
        return previousNode;
    }
}
