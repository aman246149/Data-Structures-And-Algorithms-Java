import java.util.Stack;


// Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
// Output: true
// Explanation: We might do the following sequence:
// push(1), push(2), push(3), push(4), pop() -> 4,
// push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

// Algorithm
// we push the element in the stack while checking if the peek element of stack  is equal to popped array element
// if its equal we popped stack element
// we check if j reached to its last point then we return true
class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        
        int j=0;
        for(int ele:pushed){
            st.push(ele);
            while(st.size()>0 && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        
        return j==popped.length;
    }
}

// for more watch copy