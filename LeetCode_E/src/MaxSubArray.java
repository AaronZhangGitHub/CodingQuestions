public class MaxSubArray {
//https://leetcode.com/problems/maximum-subarray/description/
    public int maxSubArray(int[] nums) {
        int overallMax = Integer.MIN_VALUE;
        int currentMax = 0;
        for(int i = 0;i<nums.length;i++){
            if(currentMax<nums[i] && currentMax<0){
                currentMax = 0;
            }
            currentMax+=nums[i];
            if(currentMax>overallMax){
                overallMax=currentMax;
            }
        }
        return overallMax;
    }
}
