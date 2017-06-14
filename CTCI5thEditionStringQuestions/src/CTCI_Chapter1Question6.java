
public class CTCI_Chapter1Question6 {
/*
 * Given an image rep. by a NxN matrix where each pixel in the image is 4 bytes representation
 * write a method to rotate the image by 90 degrees
 */
	/*
	 * [1][2] -> [3 1
	 * [3][4]     4 2]
	 * 
	 * [1 2 3    [7 4 1
	 *  4 5 6  -> 8 5 2
	 *  7 8 9]    9 6 3]
	 */
	public static void main(String args[]){
		int n = 5;
		Pixel [][] matrixRepresentation = new Pixel[n][n];
		
	}
	public void rotateMatrix90Deg(Pixel [][] matrixRep){
		int x = 0;
		for(int i = 0;i<matrixRep.length;i++){
			//send left to top
			Pixel temp = matrixRep[i][0];
			matrixRep[i][x] = matrixRep[i][matrixRep.length-1];
			
			//send top to right
			
			//send right to bottom
			//send bottom to left
			//send left to top
			x++;
		}
		
	}
}
class Pixel {
	static byte[] _pixelArray = new byte[4];
	public Pixel(byte [] _pixelArray){
		Pixel._pixelArray = _pixelArray;
	}
	public static byte[] getByteArray(){
		return _pixelArray;
	}
}
