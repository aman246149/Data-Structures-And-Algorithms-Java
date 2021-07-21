/*
ALGORITHM

1->CREATING AN ARRAY FOR STORING UNIQUE INDEX OF EVERY ELEMENT EX(BRACKETS)
 ..BECAUSE ORDER OF BRACKETS MATTER

 2-> WE ONLY STORE INDEX OF OPENING BRACKET IN OUR STACK
 
 3->IF WE SEE CLOSING BRACKET AND IF WE HAVE OPENING
 BRACKET POP OPENING BRACKET FROM STACK

 4-> IF WE FOUND SOMETHING INVALID IN OUR STRING
 MAKE IF FLAG IN OUR ARRAY IN THAT PARICULAR POSITION


*/

// 1249. Minimum Remove to Make Valid Parentheses


import java.util.*;

class MinimumRemoveToMakeVaild {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        char chars[]=s.toCharArray();
        
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){ //only pushing opening bracket index on stack
                st.push(i);
            }else if(chars[i]==')'){ //when closing bracket comes
                if(st.size()==0){
                    chars[i]='.';
                }else{
                    st.pop();
                }
            }
        }
        
        //man lo ki sab kuch hona ka baad opening bracket raha gaya
        //like((( esa kuch uss case ma 
        
        while(st.size()>0){
            chars[st.pop()]='.';
        }
        
        //at last returning ans in string
        
        StringBuilder builder=new StringBuilder();
        int i=0;
        while(i<chars.length){
            if(chars[i]!='.'){
                builder.append(chars[i]);
            }
            i++;
        }
        return builder.toString();
    }
}