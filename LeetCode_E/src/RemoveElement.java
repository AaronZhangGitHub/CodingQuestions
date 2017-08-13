public class RemoveElement {
    /*
    https://leetcode.com/problems/remove-element/description/
    Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
     */
    public static void main (String args[]){
        int [] arr = {3, 2, 2, 3};
        removeElement(arr, 3);
    }
    public static int removeElement(int input [],int value) {
        int i = 0;
        for (int j = 0;j<input.length;j++){
            if(input[j]!=value){
                //bring values to beggining of array
                input[i]=input[j];
                i++;
            }
        }
        return i;
    }
}
