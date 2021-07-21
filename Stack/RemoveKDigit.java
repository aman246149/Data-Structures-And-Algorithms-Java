import java.util.*;

class RemoveKDigit {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        
            for(int i=0;i<num.length();i++){
                char ch=num.charAt(i);
                while(st.size()>0 && k>0 && st.peek()>ch){//non decreasing order
                    st.pop();
                    k--;
                }
                st.push(ch);
                
              
            }
        
          while(k>0){ //increaing order ma ha ya ho gaya ha data
                    st.pop();
                    k--;
                }
                
        
          //storing our ans
                char[] ans=new char[st.size()];
                int p=ans.length-1;
                while(p>=0){
                    ans[p--]=st.pop();
                }
                
               
        
         //handle some corner cases
                
                //case 1:
                //when we got our char array like 00200
                //here  0 is unnecessary remove it ,then we got 0200
                int d=0;
                while(d<ans.length && ans[d]=='0'){
                    d++;
                }
                
          //creating string builder to return our answer
        StringBuilder build=new StringBuilder();
        while(d<ans.length  ){
            build.append(ans[d++]);
        }
        //checking another case
        //if we got array like this [0,0,0,0,0,0,0]
        //then our string builder length will be zero because we handled this case in case 1
        
        if(build.length()==0){
            build.append('0');
        }
         
        return build.toString();
    }
}