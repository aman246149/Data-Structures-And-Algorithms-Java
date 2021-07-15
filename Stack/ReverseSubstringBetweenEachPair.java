import java.util.*;

/*
Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"

<==============ALGORITHM=====>>>>>>>>
1->REVERSE THE STRING BETWEEN THESE BRACKET ()
2->AFTER REVERSING STORE THEM IN STACK
3->WE REMOVE FIRST THEN INSERT OTHERWISE OUTPUT NOT COME
4->WE USE QUEUE DS TO REVERSE THE STRING PART
5->LASTLY STORE ALL DATA  IN ARRAY AND THEN RETURN IT AFTER CONVERTING IT IN STRING
6->WE STORE DATA IN ARRAY FROM BACKSIDE BECAUSE IN OUR STACK DATA IS
LIKE     [ ILOVEU ]  => OUTPUT=>[ILOVEU]

*/


class ReverseSubstringBetweenEachPair {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
          
            char ch=s.charAt(i);
            
           
             if(ch==')'){
                Queue<Character> que=new LinkedList<>();
                while(st.peek()!='('){
                    que.add(st.pop());    
                }
                st.pop();
                
                while(!que.isEmpty()){
                    st.push(que.remove());
                }
            }else  {
                st.push(ch);
 
             }
         }
        
      
        char[] arr=new char[st.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=st.pop();
        }
        
        return new String(arr);
    }
}