

class RoofTop
{
    //Function to find maximum number of consecutive steps 
    //to gain an increase in altitude with each step.
    static int maxStep(int A[], int N)
    {
        // Your code here
        int maxcount=0;
        int count=0;
        int j=1;
        
        for(int i=0;i<N-1;i++){
            if(A[i]<A[j]){
                count++;
            }else{
                maxcount=Math.max(count,maxcount);
                count=0;
            }
                j++;
                
        }
        
        if(count>maxcount){
            maxcount=count;
        }
        
        
        return maxcount;
    }
    
}