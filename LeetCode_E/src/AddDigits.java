public class AddDigits {
    public int addDigits(int num) {
        if(num<0){
            num = num*-1;
        }
        return 1 + (num-1)%9;
    }
}
