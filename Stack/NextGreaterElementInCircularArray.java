import java.util.Stack;

class NextGreaterElementInCircularArray {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[nums.length];
        
        for(int i=nums.length-2;i>=0;i--){   // check notebook for explanation
            while(st.size()>0 && st.peek()<=nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }
        
         for(int i=nums.length-1;i>=0;i--){
            while(st.size()>0 && st.peek()<=nums[i]){
                st.pop();
            }
             ans[i]=st.size()==0?-1:st.peek();
            st.push(nums[i]);
        }
        
        return ans;
        
    }
}