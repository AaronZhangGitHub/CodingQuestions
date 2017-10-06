public class LengthOfLastWord {
    //https://leetcode.com/problems/length-of-last-word/description/
    public int lengthOfLastWord(String s) {
        if(s.length()<0){return 0;}
        boolean charOccurence = false;
        int counter = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                counter++;
                charOccurence = true;
            }else if(charOccurence){
                //asume it is a ' '
                break;
            }
        }
        return counter;
    }
}
