/*
leetcode 240

this question is different from the previous one.
in this for every element in the array, the next element is sorted
so we can start iterating the array from the top right side
*/


class Search2DSortedArray2 {
    public boolean searchMatrix(int[][] matrix, int target) {
       int r=0;
        int c=matrix[0].length-1;
        
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target){
                 return true;       
            }else if(matrix[r][c]>target){
                c--;
            }else {
                r++;
            }
        }
        
        return false;
    }
}