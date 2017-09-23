import java.util.Stack;

public class ValidParenthesis {
    /*
    https://leetcode.com/problems/valid-parentheses/description/
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    Stack<Character> s = new Stack<Character>();
    public boolean isValid(String s) {
        if(s.length()%2!=0){return false;}
        for(char c: s.toCharArray()){
            switch(c){
                case '{':
                    s.push(c);
            }
        }
    }
}
