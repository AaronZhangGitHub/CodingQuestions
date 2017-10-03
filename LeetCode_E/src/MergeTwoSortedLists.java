public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode newList;
        if(l1.val<=l2.val){
            //l1 is lowest value in list
            newList = l1;
            newList.next = mergeTwoLists(l1.next,l2);
        }else{
            //l2 is lower value in the list
            newList = l2;
            newList.next = mergeTwoLists(l1,l2.next);
        }
        return newList;
    }
}
