
import java.util.*;

class NoOfValidSubArrays{
    public static void main(String[] args) {
        int arr[]={1,4,2,5,3};
        Stack<Integer> st=new Stack<>();
       int count=0;
       
       for(int num:arr){
           //agar increasing order ma ha toh push
         //    varna pop from stack
        //   agar peek vala element bada ha cuurent sa
     // toh pop karenga
        
        // or current agar chota ho toh push kardinga
        // bina pop kiya hua
           while (st.size()>0 && st.peek()>num) {
               st.pop();
           }
           st.push(num);
           System.out.println(st.size());
           count+=st.size();
       }

        System.out.println(count);
    }
}