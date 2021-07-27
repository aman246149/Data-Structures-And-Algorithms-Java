/*
Algorithm

1.using Binary Search
2.using binary search to find a row where that target element is exist in that row
3. if it exist again using binary search to find if target exist in that row or not

*/


class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //select a row using binary search
        int r=binarySearchRow(matrix,target);
        
        if(r==-1){
            return false;
        }
        
        //search in rth row using binary search
        boolean isFound=binarySearch(matrix,target,r);
        
        return isFound;
    }
    
    public  int  binarySearchRow(int[][] matrix, int target){
        int low=0;
        int high=matrix.length-1;
        int lastColumn=matrix[0].length-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(matrix[mid][0]<=target && matrix[mid][lastColumn]>=target){
                return mid;
            
            }else if(matrix[mid][0]<target){
                low=mid+1;
            }else if(matrix[mid][0]> target){
                high=mid-1;
            }
            
        }
        
        return -1;
    }
    
    public boolean binarySearch(int[][] matrix,int target,int r){
        
        int low=0;
        int high=matrix[0].length-1;
        while(low<=high){
            int mid=(low+high)/2;
                
                if(matrix[r][mid]==target){
                    return true;
                }else if(matrix[r][mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
        }
        
        return false;
    }
    
}