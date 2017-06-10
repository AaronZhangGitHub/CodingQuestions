
public class CTCI_Chapter1Question2 {
	// Implement a function void which reverses a string
	public static void main(String args[]) {
		String input = "Hello";
		input = reverseString(input);
		System.out.println(input);
	}
	//O(n)
	public static String reverseString(String input) {
		char temp;
		char[] inputCharArray = input.toCharArray();//O(n)
		for (int i = 0; i < (input.length() / 2); i++) {
			//O(3n/2)
			temp = inputCharArray[i];
			inputCharArray[i] = inputCharArray[inputCharArray.length - 1 - i];
			inputCharArray[inputCharArray.length - 1 - i] = temp;
		}
		return new String(inputCharArray); //O(n)
	}
}