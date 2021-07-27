/*

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3

iss question ma hame minimum parenthiss remove karana ha taaki vo valid ho jaaya

here empty string is also a valid string

*/

import java.util.*;


class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){ //agar opening bracket ha toh push
                st.push(ch);
            }else if(ch==')'){//agar closing ha toh phela check karna
                //ha ke peek pa oppsite bracket ha ki nahi 
                //agar ha toh pop
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }else{
                    //agar nahi ha toh same bracket ha matlab push
                    st.push(ch);
                }
            }
        }
        
        return st.size();//ya batara ha hama no of invalid brakcet
    }
}