
public class PalindromeInt {
	/*
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space. https://leetcode.com/problems/palindrome-number/#/description
	 */
	public static void main(String args[]){
		///System.out.println(isPalindrome(1000000001)); //testing purposes
		//System.out.println(reverseInteger(1000000001));
	}
	public static boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		int reversedNum = reverseInteger(x);
		return ((x - reversedNum) == 0) ? true : false;
	}

	public static int reverseInteger(int x) {
		long total = 0;
		while (x != 0) {
			total += x % 10;
			total *= 10;
			x -= x % 10;
			x /= 10;
			//System.out.println("total: "+total+" x:"+ x);
		}
		return (int) (total /= 10);
	}
}
