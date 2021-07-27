
class FindMiniMumInRotatedSorted {
    public int findMin(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int mid=0;
        //applying binary Search
        if(arr[low]<=arr[high])return arr[low];  //checking condition when array is already sorted
        
        while(low<=high){
            mid=(low+high)/2;
            
            if(arr[mid]>arr[mid+1]){  // agar sorted array ma left vala bada ha aaga vala sa toh yahi chota ha
                return arr[mid+1];
            }else if(arr[mid]<arr[mid-1]){ //agar picha vala pada ha toh aaga vala chota hoga
                return arr[mid];
            }else if(arr[low]<=arr[mid]){// sorted part ma nahi dundna
                low=mid+1;
            }else if(arr[mid]<=arr[high]){ //sorted part ma nahi dundana
                high=mid-1;
            }
        }
        
        
        return -1;
    }
}