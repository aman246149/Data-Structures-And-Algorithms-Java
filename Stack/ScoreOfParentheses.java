import java.util.Stack;

/*
() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

*/



class ScoreOfParenthesestion {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                //agar opening bracket ha toh
                // add kardo stack ma
                st.push(-1);
            }else if(ch==')'){
                // agar opposite bracket ha toh 
                // immediately pop from the stack 
                // and add total score 1 in stack
                if(st.peek()==-1){
                    st.pop();
                    st.push(1);
                }else{
                    // agar immediate pop nahi ho paata toh matlab
                    // hame while loop use karna padega total pop
                    // karna ka lia
                    // toh pop karo till hama opposite bracket nahi
                    // mill jaata ...jaise hee mila
                    // uska dugna kardo or stack ma push kardo
                    int val=0;
                    while( st.peek()!=-1){
                       val+=st.pop();
                    }
                    st.pop();//last openining bracket bach gaya pop it
                    //ab hama pata ha ki while loop chala toh iska matlab ya ha kee multiple  opening and closing ha (()())
                    st.push(2*val);//add it in stack   multiply by 2
                }
            }
        }
        int val=0;
        //ya condition bhi ha jab hampa stack ma kuch element bach jaayenga
        // ya tab hoga jab ()() esa kuch hoga
        // kyu ki isa hamna kaali stack ma push hee kiya ha 
        // iss case ma inha pop karo or return kardo
        while(st.size()>0){ //todo stack ma sa value nikalka return kardo
            val+=st.pop();
        }
        
        return val;
    }
}