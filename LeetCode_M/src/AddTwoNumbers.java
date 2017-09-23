public class AddTwoNumbers {
    /*
    https://leetcode.com/problems/add-two-numbers/description/
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
*/
    public static void main(String args[]){
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

/*
[2,4,3]
[5,6,4]
*/
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode addedListRep = new ListNode(0);
            //0->null
            ListNode returnNode = addedListRep; //0alr->null
            ListNode longerList = null;
            int sum;
            int carryOver = 0;
            ListNode toAdd;
            while(true){
                //This assumes the lists are non empty
                sum = l1.val+l2.val+carryOver; //10
                carryOver = sum/10;//ints floor in Java 10=1
                sum = sum % 10; //get digit value 0
                toAdd = new ListNode(sum); //0
                addedListRep.next=toAdd; // add to list
                //0alr->0->null
                addedListRep = addedListRep.next; //move list one slot over
                //0->0alr->null
                l1=l1.next;//node null
                l2=l2.next;//node 9
                if(l1==null&&l2==null){
                    //Need to check if there is still a cary over
                    if(carryOver>0){
                        toAdd = new ListNode(1);
                        addedListRep.next=toAdd;
                        addedListRep = addedListRep.next; //move list one slot over
                    }
                    return returnNode.next;
                }else if(l1==null){
                    longerList = l2;
                    break;
                }else if(l2==null){
                    longerList = l1;
                    break;
                }
            }
            //One node longer than the other
            while(longerList!=null){
                sum = longerList.val+carryOver;
                carryOver = sum/10;
                sum = sum % 10;
                toAdd = new ListNode(sum);
                addedListRep.next=toAdd; // add to list
                addedListRep = addedListRep.next; //move list one slot over
                longerList = longerList.next;
            }
            if(carryOver>0){
                toAdd = new ListNode(1);
                addedListRep.next=toAdd;
                addedListRep = addedListRep.next; //move list one slot over
            }

            return returnNode.next;
        }
    }
}
