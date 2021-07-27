import java.util.Arrays;

//Todo Method 1

class FindPairWithGivenDiff
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
      Arrays.sort(arr);//sorting array

      int i=0,j=1;
      while (i<arr.length && j<arr.length) {
          if(arr[j]-arr[i]==target){ //agar directly mill gaya diff toh true
              return true;
          }else if (arr[j]-arr[i]<target){ //agar chota value aaya target sa increase j kyuki j aaga ha aur hamara array bhi sorted ha
              j++;
          }else{
              i++;//else agar value badhi ha target sa increase i taaki chota chhota differece minus ho
          }
      }

      return false;
    }
}











//Todo Method  2
// class FindPairWithGivenDiff
// {
//     public boolean findPair(int arr[], int size, int n)
//     {
//         //code here.
//         Set<Integer> set=new TreeSet<>();
   
        
//        for(int i=0;i<size;i++){
//             set.add(arr[i]);
  
//         }
           
//            for(int i=0;i<size;i++)
//             if(set.contains(n+arr[i])){
//             return true;
        
//        }
       
//        return false;
//     }
// }