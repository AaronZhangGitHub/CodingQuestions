
public class CTCI_Chapter1Question4 {
	/*
	 * replace all spaces with '%20', assume the string has sufficient space at the end 
	 * to hold additional characters. given the true length of the string which is the total
	 * number of characters+spaces. Needs to be in place
	 */
	public static void main(String args[]){
		String input = "Mr John Smith    ";
		int trueLength = 13;
		//expected output "Mr%20John%20Smith"
		System.out.println(replaceSpaces(input,trueLength));
	}
	//O(N) where N is the length of the string
	static String replaceSpaces(String inp, int trueLength){
		char [] input = inp.toCharArray();
		int currentCharIndex = trueLength-1; 
		int arrayIndex =input.length-1; 
		while(currentCharIndex!=-1){
			if(input[currentCharIndex]==' '){
				//replace with %20
				input[arrayIndex]='0';
				input[arrayIndex-1]='2';
				input[arrayIndex-2]='%';
				currentCharIndex--;
				arrayIndex-=3;
			}else{
				//assign value to index i
				input[arrayIndex]=input[currentCharIndex];
				currentCharIndex--;
				arrayIndex--;
			}
		}
		return new String(input);
	}
}
