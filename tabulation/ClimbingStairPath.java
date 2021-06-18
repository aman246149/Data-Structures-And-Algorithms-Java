public class ClimbingStairPath {
    public static void main(String[] args) {
        System.out.println(countPath(6));

    }

    static int countPath(int n){
        int arr[]=new int[n+1];

        arr[0]=1;

        for (int i = 1; i < arr.length; i++) {
            if(i==1){
                arr[i]=arr[i-1];
            }else if(i==2){
                arr[i]=arr[i-1]+arr[i-2];
            }else{
                arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
            }
        }
      
        return arr[n];
    }
}
