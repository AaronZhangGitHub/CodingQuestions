import java.util.HashSet;
import java.util.Set;

public class CTCI_Chapter1Question1 {
	//implement an algorithim to determine if a string has all unique characters
	public static void main(String args[]){
		String input = null;
		System.out.println(stringContainsUniqueCharacters(input));
		System.out.println(stringContainsUniqueCharacters(input));
	}
	public static boolean stringContainsUniqueCharacters(String input){
		//assuming input not null uses hashset
		stringInputSanitization(input);
		Set<Character> uniqueCharCheck = new HashSet<Character>(input.length());
		for(int i = 0;i<input.length();i++){
			if(uniqueCharCheck.contains(input.charAt(i))){
				return false;
			}else{
				uniqueCharCheck.add(input.charAt(i));
			}
		}
		return true;
	}
	public static void stringInputSanitization(String input){
		if(input==null){
			System.out.println("Input can not be null");
			throw new IllegalArgumentException();
		}
	}
	//no data structures
	public static boolean stringContainsUniqueCharactersNoDataStructures(String input){
		//assuming ascii
		stringInputSanitization(input);
		boolean [] uniqueCharCheck = new boolean[128];
		for(int i=0;i<input.length();i++){
			if(uniqueCharCheck[input.charAt(i)] == true){
				return false;
			}else{
				uniqueCharCheck[input.charAt(i)] = true;
			}
		}
		return true;
	}
}
