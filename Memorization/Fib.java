
class FibonacciMemo{
    public static void main(String[] args) {
        int n=12;
        int ans=fib(n,new int[n+1]);
        System.out.println(ans);
    }

    private static int fib(int n, int[]  arr) {
        if (n==0 || n==1){
            return n;
        }

        if (arr[n]!=0){
            return arr[n];
        }

        int fib1=fib(n-1,arr);
        int fib2=fib(n-2,arr);
        int sum=fib1+fib2;

        arr[n]=sum;

        return sum;
    }
}