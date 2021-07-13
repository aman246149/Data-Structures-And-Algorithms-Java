package Recursion;

public class PermutationOfString {
    public static void main(String[] args) {
        String str="abc";

        permute(str,0,str.length()-1);

    }

    private static void permute(String str, int l, int r) {
        if (l==r){
            System.out.println(str);
        }else{
            for (int i = l; i <=r ; i++) {
                str=swap(str,l,i);
                permute(str,l+1,r);
                str=swap(str,l,i);
            }
        }


    }

    private static String swap(String str, int l, int i) {
       char temp;
       char[] charArray=str.toCharArray();
       temp=charArray[l];
       charArray[l]=charArray[i];
       charArray[i]=temp;
        return  String.valueOf(charArray);
    }
}
