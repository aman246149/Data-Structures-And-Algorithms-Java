/*
This question is also be implemented by 2 pointer method.
*/

class UnionOf2SortedArray
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {

        ArrayList<Integer> ans=new ArrayList<>();
        Set<Integer> set=new TreeSet<>();
        
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }
        
        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }
        
        for(Integer ele:set){
            ans.add(ele);
        }
        
        return ans;
    }
}



