public class SearchInsertPosition {
//https://leetcode.com/problems/search-insert-position/description/s
    public int searchInsert(int[] nums, int target) {
        if(nums==null){return -1;}
        if(target<nums[0]){return 0;}
        if(target>nums[nums.length-1]){return nums.length;}
        int returnValue = -1;

        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                return i;
            }else{
                if(target<=nums[i]){
                    return i;
                }
            }
        }
        //should not get here
        return -1;
    }
}
