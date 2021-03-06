
public class ReverseInteger {
	/*
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 */
	public static void main(String args[]){
		//System.out.println(reverse(-155)); //testing purposes
	}
    public static int reverse(int x) {
    	long result = 0;
    	while(x!=0){
	    	int temp = x%10;
	    	result+=temp;
	    	x-=temp;
	    	x/=10;
	    	result*=10;
    	}
    	result/=10;
    	if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
    		return 0;
    	}
    	return (int)result;
    }
}
