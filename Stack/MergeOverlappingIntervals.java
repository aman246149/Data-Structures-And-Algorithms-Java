import java.util.ArrayList;
import java.util.Arrays;

class MergeOverlappingIntervals{
	public static void main(String[] args) {
		
	}

	public static int[][] mergeIntervals(int Intervals[][]){

		//Step 1 Sort the array

		Arrays.sort(Intervals,(a,b)->Integer.compare(a[0], b[0]));

		//create an arraylist to store ans

		ArrayList<int []> list=new ArrayList<>();

		for (int[] interval : Intervals) {
			if (list.size()==0) {//inserting 1st element
				list.add(interval);
			}else{ //merge the intervals
				int prevInterval[]=list.get(list.size()-1); //getting previous element for comparision

				if (interval[0]<prevInterval[1]) {//partially merging
					prevInterval[1]=Math.max(prevInterval[1],interval[1] ); //get max from the end interveral of previous and current 
					
				} else {
					list.add(interval); //no overlapping found
				}
				
			}
		}
		return list.toArray(new int[list.size()][]); // return the list after converting it into an array
	}
}