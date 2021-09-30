/*

Given an integer array, write your own implementation to inplace sort it.

*/

class Solution
{
	public static void sort(int[] nums)
	{
		quickSort(nums,0,nums.length-1);
	}
	
	private static  void quickSort(int [] array,int start,int end){
		
		if(start>=end){
			return;
		}
		
		int partition=partition(array,start,end);
		quickSort(array,start,partition-1);
		quickSort(array,partition+1,end);
		
	}
	
	private static int partition (int[] array,int start,int end){
		int partitionVariable=array[end];
		int bound=start-1;
		for (int i=start;i<=end ;i++ ){
			if(array[i]<=partitionVariable){
				swap(array,i,++bound);
			}
		}
		
		return bound;
	}
	
	private static void swap(int[] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
