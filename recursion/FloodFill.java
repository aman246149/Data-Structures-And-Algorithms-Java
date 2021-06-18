public class FloodFill {
    public static void main(String[] args) {
        int arr[][]={
        {1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 0, 0},
        {1, 0, 0, 1, 1, 0, 1, 1},
        {1, 2, 2, 2, 2, 0, 1, 0},
        {1, 1, 1, 2, 2, 0, 1, 0},
        {1, 1, 1, 2, 2, 2, 2, 0},
        {1, 1, 1, 1, 1, 2, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 1},
        };
    floodFill(arr,4,4,3,arr[4][4]);
        
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    }

    public static void floodFill(int arr[][],int r,int c,int toFill,int prevFill){
        int rows=arr.length;
        int cols=arr[0].length;

        if(r<0 || r>=rows || c<0 || c>=cols){
            return;
        }

        if(arr[r][c]!=prevFill){
            return;
        }

        arr[r][c]=toFill;

        floodFill(arr, r-1, c, toFill, prevFill);
        floodFill(arr, r, c-1, toFill, prevFill);
        floodFill(arr, r+1, c, toFill, prevFill);
        floodFill(arr, r, c+1, toFill, prevFill);

    }
    
}
