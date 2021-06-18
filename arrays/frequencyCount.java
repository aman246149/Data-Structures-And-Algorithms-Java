import java.util.HashMap;
import java.util.Map;

public class frequencyCount {
    public static void main(String[] args) {
        int arr[]={2,4,5,6,8};
        int p=5;
       
      frequencycount(arr,p);
     
    }

    private static void frequencycount(int[] arr, int p) {
      
        
        
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>arr.length){
                continue;
            }
           if (!map.containsKey(arr[i])) {
               map.put(arr[i],1);
           }else{
               int getdata=map.get(arr[i]);
               int addOne=getdata+1;
               map.put(arr[i], addOne);
               
           }
        }

        System.out.println(map);
        
        for (int i = 0; i <arr.length; i++) {
            arr[i]=0;
        }
        
    //     map.entrySet()
    // .forEach((entry) -> arr[entry.getKey()-1]=entry.getValue());

     
        map.forEach((key, value) -> arr[key-1]=value);
       
       


        for (int data : arr) {
            System.out.print(data+" ");
        }
        
    }
}
