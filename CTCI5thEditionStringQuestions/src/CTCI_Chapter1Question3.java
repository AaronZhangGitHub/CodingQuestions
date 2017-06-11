
public class CTCI_Chapter1Question3 {
	// Given two strings write a method to decide if one is a permuation of the
	// other
	public static void main(String ars[]) {
		String a = "HelloMate";
		String b = "MateHello";
		System.out.println(isPermuation(a, b));
	}

	public static boolean isPermuation(String a, String b) {
		// assuming ascii
		int[] characterOccurences = new int[128];
		if (a.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			characterOccurences[a.charAt(i)] += 1;
		}
		for (int i = 0; i < b.length(); i++) {
			if (characterOccurences[b.charAt(i)]-- < 0) {
				return false;
			}
		}

		return true;
	}
}
