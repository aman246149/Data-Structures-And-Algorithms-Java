
//using binary search to find the elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans=new ArrayList<>();
        int low=0;
        int high=arr.length-1;
        int mid=0;
        
        while(low<=high){  //applying normal binary search  to find closest index of x
            mid=(low+high)/2;
            
            if(arr[mid]==x){
                break;
            }else if(arr[mid]<x){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        
        low=0;
        high=0;
        
        if(mid==0 && mid<arr.length-1){  //handling corner cases when we have 2 elements otherwise we get error
            low=mid;
            high=mid+1;
        }else{
            low=mid-1;
            high=mid;
        }
        
        while(low>=0 && high<arr.length && k>0){  // Now Main Logic find element closet to K
            if(Math.abs(arr[low]-x) <= Math.abs(arr[high]-x)){ // calculating left part is smallest
                ans.add(arr[low]);
                low--;
            }else{
                 ans.add(arr[high]);  //if right part is smallest
                high++;
            }
            
            k--;
        }
        
        while(k>0 && low>=0){  //if k is not fullfill means k is not 0  but we get exited from above while loop
            ans.add(arr[low]);        //because that got teriminated ,that loop reaches it basecase ( high<arr.legth )
            low--;
            k--;
        }
        
         while(k>0 && high<arr.length){  //same above explanation
            ans.add(arr[high]);
            high++;
            k--;
        }
        
        Collections.sort(ans);   //sorting the list as we have to return ans in ascending order
        
        
        return ans;
    }
}

