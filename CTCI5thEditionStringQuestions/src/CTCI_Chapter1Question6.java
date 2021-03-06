
public class CTCI_Chapter1Question6 {
/*
 * Given an image rep. by a NxN matrix where each pixel in the image is 4 bytes representation
 * write a method to rotate the image by 90 degrees
 */

	public static void main(String args[]){
		
	}
	public boolean rotateMatrix90Deg(Pixel [][] matrixRep){
		if(matrixRep==null||matrixRep.length<=1||matrixRep.length!=matrixRep[0].length) 
			return false;
		for(int i = 0;i<matrixRep.length/2;i++){
			int lastIndex = matrixRep.length-i-1;
			for(int j = i;j<lastIndex;j++){
				int tempOff = j-i;
				Pixel temp = matrixRep[i][j];
				matrixRep[i][j] = matrixRep[lastIndex-tempOff][i];
				matrixRep[lastIndex-tempOff][i]=matrixRep[lastIndex][lastIndex-tempOff];
				matrixRep[lastIndex][lastIndex-tempOff] = matrixRep[j][lastIndex];
				matrixRep[j][lastIndex] = temp;
				
			}
		}
		return true;
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
