public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){return -1;}
        int left = 0;
        int right = nums.length-1;
        int midpoint;
        while(left<=right){
            midpoint = (left+right)/2;
            if(nums[midpoint]==target){return midpoint;}
            if(nums[left]<=nums[midpoint]){
                if(nums[left]<=target && nums[midpoint]>target){
                    right = midpoint-1;
                }else{
                    left = midpoint+1;
                }
            }
            if(nums[midpoint]<=nums[right]){
                if(target>nums[midpoint]&&target<=nums[right]){
                    left = midpoint+1;
                }else{
                    right = midpoint-1;
                }
            }
        }
        return -1;
    }
}
