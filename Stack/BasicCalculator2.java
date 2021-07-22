import java.util.*;
//leetcode 227

/*


s consists of integers and operators ('+', '-', '*', '/') 

Algorithm
1. + push value in stack
2. - push value in stack after chainging its sign to -ve
3. * and / ==> pop  previous value from stack and do multiplication and division on them
4. Reset val =0 and  chage sign=ch;

*/

class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        char sign='+';
        int val=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(Character.isDigit(ch)){ //if we have digit
                                  //make it complete number
                    val=val*10+(ch-'0'); 
                  
                }
        if(i+1==s.length() || ch=='+' || ch=='-' || ch=='*' || ch=='/'){ //if we have operators
            if (sign == '+') {
               st.push(val);
             } else if (sign == '-') {
          st.push(-val);
             } else if (sign == '*') {
          st.push(st.pop()*val);
             } else if (sign == '/') {
          st.push(st.pop() / val);
             }
            
            val=0;                      //chainging value and sign
            sign=ch;
        }
                
                
        }
        
        int sum=0;
        while(st.size()>0)sum+=st.pop();   //when we have only elements left like [1+2-4+5+23]
        
        return sum;
    }
}
