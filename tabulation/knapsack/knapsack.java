package knapsack;

class Knapsack{
      public static void main(String[] args) {
          int w=8;
          int wt[]={3,2,4};
          int pr[]={6,8,7};
          int n=wt.length-1;
          System.out.println(knapsack(wt, pr, w, n));
      }

       static int knapsack(int wt[],int pr[],int w,int n){
            if (n<=0 || w==0) {
                  return 0;
            } 

            if (wt[n]>w) {
                  return knapsack(wt, pr, w, n-1);
            } else {
                  return Math.max(knapsack(wt, pr, w, n-1), 
                  pr[n]+knapsack(wt, pr, w-wt[n], n-1)
                  );
            }
       }
}