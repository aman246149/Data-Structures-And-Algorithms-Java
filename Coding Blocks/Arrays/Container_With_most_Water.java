package Arrays;

public class Container_With_most_Water {
    public static void main(String[] args) {
        int[] arr ={1,8,6,2,5,4,8,3,7};
        int left=0;
        int right= arr.length-1;
        int area=0;

        while (left<right){

            area=Math.max(area,Math.min(arr[left],arr[right])*(right-left));

            if (arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(area);
    }

}
