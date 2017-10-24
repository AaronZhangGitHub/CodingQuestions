public class FindPeakElement {
    //https://leetcode.com/problems/find-peak-element/description/
    public int findPeakElement(int[] nums) {
        if(nums.length==1){return 0;}
        if(nums.length==2){return (nums[0]>nums[1])?0:1;}
        //atleast size 3
        int i = 0, j = 1, k = 2;
        //Check edges
        if(nums[i]>nums[j]){return i;}
        if(nums[nums.length-1]>nums[nums.length-2]){return nums.length-1;}

        while(k<nums.length){
            if(nums[j]>nums[i]&&nums[j]>nums[k]){
                return j;
            }
            i++;
            j++;
            k++;
        }
        return Integer.MIN_VALUE;
    }
}
