package Arrays;

public class CountZerosInFactorial {

    public static void main(String[] args) {
        int n=105;
        int zeros_count=0;
        while (n>0){
            System.out.println(n);
            n=n/5;
            zeros_count+=n;
        }
        System.out.println(zeros_count);
    }
}
