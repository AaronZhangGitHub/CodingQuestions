import java.util.HashMap;

public class TwoSum {
	/*
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target. You may assume that each input would
	 * have exactly one solution, and you may not use the same element twice.
	 * https://leetcode.com/problems/two-sum/#/description
	 */
	public static void main(String args[]) {
		int[] input = { -3, 4, 3, 90 };
		System.out.println(twoSum(input, 0)[0]+" "+twoSum(input,0)[1]);
		int [] input2 = {-1,-2,-3,-4,-5};
		System.out.println(twoSum(input2, -8)[0]+" "+twoSum(input2,-8)[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> indexToInt = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int difference = (target>=0) ? (target - Math.abs(nums[i])): (target-nums[i]);
			if (indexToInt.containsKey(difference)) {
				int index = indexToInt.get(difference);
				int[] result = { index, i };
				return result;
			} else {
				indexToInt.put(nums[i], i);
			}
		}
		return null;
	}
}
