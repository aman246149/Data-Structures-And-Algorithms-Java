package Arrays;

public class SunnyBuilding {
    public static void main(String[] args) {
        int arr[]={5,2,5,6,4,3,7};
        int maxlh=0,ans=0;

        for (int i = 0; i < arr.length; i++) {
            maxlh=Math.max(maxlh,arr[i]);


            if (arr[i]>=maxlh){
                ans++;
            }

        }

        System.out.println(ans);
    }
}
