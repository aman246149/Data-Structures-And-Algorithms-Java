// for algorithm watch copy

import java.util.*;

class _132Pattern {
    public boolean find132pattern(int[] nums) {
        int min[]=new int[nums.length];
        min[0]=nums[0];
        
 for(int i =1;i<nums.length;i++) min[i] = Math.min(min[i-1],nums[i]); // maintain minimum so far 

        Stack<Integer> st=new Stack<>();
        
        for(int j=nums.length-1;j>=0;j--){
            
            while(st.size()>0 && min[j]>=st.peek()){  
//                 pop till min>k
//                 we want i<k
                st.pop();
            }
            
            if(!st.isEmpty() && st.peek() < nums[j]){
                return true;
//                 k<j
//                 int this case k is st.peek();
            }
            
            st.push(nums[j]); //preivous ha ya
//             pushing k;
            
        }
        return false;
    }
}