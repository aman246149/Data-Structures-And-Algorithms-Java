package Recursion;

public class NoOfPathsIn2d {
    public static void main(String[] args) {
        System.out.println(countPath(2,2));
    }

    private static int countPath(int i, int j) {
        if(i==1 || j==1){
            return 1;
        }
        return countPath(i-1,j)+countPath(i,j-1);
    }
}
