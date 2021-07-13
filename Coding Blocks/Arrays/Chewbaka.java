package Arrays;

public class Chewbaka {
    public static void main(String[] args) {
        String str="9981";
        String ans="";
        boolean isGreater=false;

        char[] aman=str.toCharArray();

           if (aman[0]>9){
               isGreater=true;
           }

        if (isGreater){
            ans=ans+Character.getNumericValue(aman[0]);
        }else{
            int a=Character.getNumericValue(aman[0]);
            a = Math.abs(a - 9);
            ans=ans+a;
        }

        for (int i = 1; i < aman.length; i++) {
                if (Character.getNumericValue(aman[i]) >= 5) {
                    int a = Character.getNumericValue(aman[i]);
                    a = Math.abs(a - 9);
                    ans = ans + a;
                }else{
                    ans=ans+Character.getNumericValue(aman[i]);
                }
        }
        System.out.println(ans);
    }
}
