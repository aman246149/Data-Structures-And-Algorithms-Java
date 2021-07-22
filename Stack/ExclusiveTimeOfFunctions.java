import java.util.List;
import java.util.Stack;

class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<pair> st=new Stack<>();
        int ans[]=new int[n];
        
        for(String log:logs){
            String[] data=log.split(":"); //splitting the data  by semicolon
            if(data[1].equals("start")){  //if we got start push data in stack
                pair p=new pair();  
                p.id=Integer.parseInt(data[0]);
                p.st_or_ed_time=Integer.parseInt(data[2]);
                p.child_time=0;
                
                st.push(p);
            }else{                        //if we got end pop the data from the stack
                pair p=st.pop();
                int diff=Integer.parseInt(data[2])-p.st_or_ed_time+1;   //calculate the differece for interval by simply substracting  endData-startData+1
                int timefornextchild=diff-p.child_time;                     //we got child time by simply substracting diffenece- previous childtime
                ans[p.id]+=timefornextchild;
                
                if(st.size()>0){           //agar parent ha toh   // notify parent about their children
                    st.peek().child_time+=diff;
                }
            }
        }
        
        return ans;
    }
    
    class pair{
        int id;
        int st_or_ed_time;
        int child_time;
    }
}