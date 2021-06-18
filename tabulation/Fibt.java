
class FibonacciTabu{
    public static void main(String[] args) {
        int n=12;
        int ans=fib(n,new int[n+1]);
        System.out.println(ans);
    }

    private static int fib(int n, int[]  arr) {
       arr[0]=0;
       arr[1]=1;

       for (int i = 2; i < arr.length; i++) {
            arr[i]=arr[i-1]+arr[i-2];
       }
       return arr[n];
    }
}