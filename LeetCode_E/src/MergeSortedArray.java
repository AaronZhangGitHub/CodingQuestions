public class MergeSortedArray {
    //https://leetcode.com/problems/merge-sorted-array/description/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalIndex = n+m-1;
        n--;
        m--;
        while(m>-1 && n>-1){
            nums1[totalIndex]=(nums1[m]>=nums2[n])?nums1[m--]:nums2[n--];
            totalIndex--;
        }
        while(n>-1){
            nums1[totalIndex] = nums2[n--];
            totalIndex--;
        }
    }
}
