

class pivotIndexx {
    public int pivotIndex(int[] nums) {
        //pivot index or equilibrim index
        
        int sum=0;
        //step1--> calculate sum
        for(int n:nums)sum+=n;
        
        // step2--> calculate leftsum and right sum
        
        int leftsum=0,rightsum=sum;
        
        for(int i=0;i<nums.length;i++){
            rightsum=rightsum-nums[i];  //aata hee right sum ko sahi karroo
                                        //rightsum ma sa khud ho haatenga toh sum mill jaayega
            
            if(rightsum==leftsum)return i;
            
            leftsum+=nums[i];
        }
        
        return -1;
    }
}