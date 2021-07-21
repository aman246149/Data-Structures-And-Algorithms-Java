import java.util.*;
/*
Algorithm

loop{
    Valid
    Smaller
    Remove  till small elements  remove all greater elements

}else
    check K Digits
    Add

    requirement=k-st.size();
    remaining=n-i-1
*/

public class Lexicographically_Smallest_Subsequence {
    
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int ans[]=new int[k];
            Stack<Integer> st=new Stack<>();
            int n=nums.length;
            
            for(int i=0;i<nums.length;i++){
                int val=nums[i];
                
                while(st.size()>0 && st.peek()>val && n-i-1>=k-st.size()){ //pop till arr[i] chota ha current element sa
                                                                            //or sath sath ma condition bhi check karta raho
                                                                            //ki within k ki range ma ha ki nahi
                    st.pop();
                }
                
                if(st.size()<k){  //checking if space available for  new elements
                    st.push(val);
                }
                
            }
            
            int i=k-1;
            
            while(i>=0){
                ans[i--]=st.pop();
            }
            
            return ans;
        }
    }
}
