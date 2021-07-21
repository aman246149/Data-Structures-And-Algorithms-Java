import java.util.Stack;

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int ele:asteroids){
            if(ele>0){  //if we have positive value in array just push it
                st.push(ele);
            }else{  //if we have nevative value 4 case are made
                while(st.size()>0 && st.peek()>0 && st.peek()<-ele){  
                    //case 1 if peekvalue is small than current element which is in opposite direction.pop till we get big value
                    st.pop();
                }
                if(st.size()>0 && st.peek()==-ele){
                    // case 2  peekvalue is same as arr[i] .. both asteroid have same value they cancel each other
                    st.pop();
                }else if(st.size()>0 && st.peek()>-ele){
                    // case three if peek value(+) greater than arr[i] negative value dont do anything
                    // or we can say that collision only occurs when asteroid comes from right to left direction
                    //   <-------------------------------------------------==============
                }else{
                    // else we have normal element just push it
                    // pushing everyvalue wheather it is -ve or +ve
                    st.push(ele);
                }
            }
        }
        int ans[]=new int[st.size()];
        
        int i=ans.length-1;
       while(st.size()>0){
           int val=st.pop();
           ans[i--]=val;
       }
return ans;
    }
}