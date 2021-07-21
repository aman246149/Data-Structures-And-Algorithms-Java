import java.util.*;
/*
check if word is valid After Substitutions

Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.


Input: s = "abccba"
Output: false
Explanation: It is impossible to get "abccba" using the operation.

----------------------------------------------------------
ALGORITHM

iF We remove all character from stack return true
else 
return false

*/


class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch=='c'){
                if(st.size()>=2 && st.pop()=='b' && st.pop()=='a'){  //checking if we get c than if we have 2 elements in stack 
                                                                // and they are b and a
                    // already pop (abc)
                }else{              // if we get c but stack size is not 2 or previous element is not b and a then return false
                    return false;
                }
            }else{    //if we get a and b then push them in stack
                st.push(ch);
            }
        }
        return st.size()==0;  //if we parsed all string and we got empty stack it means our string substitution is valid
    }
}