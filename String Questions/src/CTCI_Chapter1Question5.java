
public class CTCI_Chapter1Question5 {
	/*implement a method to perform basic string compression using the
	 *  counts of repeated characters
	 */
	public static void main(String args[]){
		String input = "aabcccccaaa";
		String compressedString = compressString(input);
		System.out.println((compressedString.length()>input.length()) ? input:compressedString);
	}
	public static String compressString(String input){
		StringBuffer sb = new StringBuffer();
		int charOccurence = 1;
		char currentChar = input.charAt(0);
		sb.append(currentChar);
		for(int i=1;i<input.length();i++){
			if(currentChar==input.charAt(i)){
				//current character is the same as the last character
				charOccurence++;
			}else{
				//new character appears
				sb.append(charOccurence);
				charOccurence = 1;
				currentChar = input.charAt(i);
				sb.append(currentChar);
			}
		}
		sb.append(charOccurence);
		return sb.toString();
	}
}
