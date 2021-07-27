
class FirstAndLastPosition {
    public int[] searchRange(int[] arr, int target) {
        int ans[]={-1,-1};
        int low=0;
        int high=arr.length-1;
        int mid=0;
        //for finding first index binary search
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==target){
                ans[0]=mid; //agar mid mill bhi jaaya toh aur left ma check karo kyu ki vaha first occurence hoggi
                high=mid-1; //issa hamara high left side aa jaayega
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
         //for finding last index binary search
        low=0;
        high=arr.length-1;
        mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==target){
                ans[1]=mid; //similarly find last index byy updating low=mid+1
                low=mid+1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return ans;
    }
}