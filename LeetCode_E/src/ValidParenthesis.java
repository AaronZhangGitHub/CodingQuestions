import java.util.Stack;

public class ValidParenthesis {
    /*
    https://leetcode.com/problems/valid-parentheses/description/
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    public boolean isValid(String s) {
        //"[])"
        if(s.length()==1||s.length()==0||s==null){
            return false;
        }
        Stack<Character> stackValidString = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stackValidString.push(c);
                //[
            }else if(!stackValidString.empty()){
                char compareChar = stackValidString.pop();
                if(compareChar=='(' && c!=')'){
                    return false;
                }else if(compareChar=='{' && c!='}'){
                    return false;
                }else if(compareChar=='[' && c!=']'){
                    return false;
                }
            }else{
                return false;
            }
        }
        if(stackValidString.empty()){
            return true;
        }else{
            return false;
        }
    }
}
