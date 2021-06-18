public class BoundaryFillWith8 {
    public static void main(String[] args) {
        int arr[][]={
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            };

            boundaryFill(arr, 4, 4, 2, 0, 1);

            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
    }

    public static void boundaryFill(int arr[][],int r,int c,int toFill,int prevFill,int boundary){
        int rows=arr.length;
        int cols=arr[0].length;

        if(r<0 || r>=rows || c<0 || c>=cols){
            return;
        }

        if(arr[r][c]!=prevFill){
            return;
        }
        if (arr[r][c]==boundary) {
            return;
        }

        arr[r][c]=toFill;

        boundaryFill(arr, r-1, c, toFill, prevFill,boundary);
        boundaryFill(arr, r, c-1, toFill, prevFill,boundary);
        boundaryFill(arr, r+1, c, toFill, prevFill,boundary);
        boundaryFill(arr, r, c+1, toFill, prevFill,boundary);
        boundaryFill(arr, r-1, c-1, toFill, prevFill,boundary);
        boundaryFill(arr, r-1, c+1, toFill, prevFill,boundary);
        boundaryFill(arr, r+1, c-1, toFill, prevFill,boundary);
        boundaryFill(arr, r+1, c+1, toFill, prevFill,boundary);


    }
    }





