

class SearchInRotatedArray {
    public int search(int[] arr, int target) {
        int left=0;
        int right=arr.length-1;
        int mid=0;
        
        while(left<=right){
            mid=(left+right)/2;
            
            if(arr[mid]==target){
                return mid;
            }else if(arr[left]<=arr[mid]){
                //left to mid part is sorted
                if(target>=arr[left] && arr[mid]>=target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(arr[mid]<=arr[right]){
                //right to mid part sorted
                if(target>=arr[mid] && arr[right]>=target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        
      return -1;
    }
}