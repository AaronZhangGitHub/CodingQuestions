
public class LongestCommonPrefix {
	public static void main(String args[]) {
		String[] test = { "aa","a" };
		System.out.println("Result: "+longestCommonPrefix(test));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0){
			return "";
		}
		java.util.Arrays.sort(strs);
		String longestPrefix = strs[0];
		String temp;
		for (int i = 1; i < strs.length; i++) {
			if ((temp = longestCommonPrefixBetweenTwoStrings(longestPrefix, strs[i])) != null) {
				longestPrefix = temp;
			}
		}
		return longestPrefix;
	}

	public static String longestCommonPrefixBetweenTwoStrings(String a, String b) {
		StringBuffer sb = new StringBuffer();
		System.out.println("a: "+a + " b:" + b);
		int shortestLength = (a.length() >= b.length()) ? b.length() : a.length();

		for (int i = 0; i < shortestLength; i++) {
			System.out.println(a.charAt(i) + " " + b.charAt(i));
			if (a.charAt(i) == b.charAt(i)) {
				sb.append(a.charAt(i));
			} else if (sb.toString().isEmpty()) {
				return "";
			} else {
				return sb.toString();
			}
		}
		return sb.toString();
	}
}
