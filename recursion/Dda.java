public class Dda {
    public static void main(String[] args) {
        DDA(2, 2, 14, 16);
    }

 static   int abs (int n)
        {
            return ( (n>0) ? n : ( n * (-1)));
        }


       static void DDA(int X0, int Y0, int X1, int Y1)
        {
            // calculate dx & dy
            int dx = X1 - X0;
            int dy = Y1 - Y0;
         
            // calculate steps required for generating pixels
            int steps = abs(dx) > abs(dy) ? abs(dx) : abs(dy);
         
            // calculate increment in x & y for each steps
            float Xinc = dx / (float) steps;
            float Yinc = dy / (float) steps;
         
            // Put pixel for each step
            float X = X0;
            float Y = Y0;
            for (int i = 0; i <= steps; i++)
            {
               System.out.print((Math.round(X)+" "+Math.round(Y)+" "+"color"));  // put pixel at (X,Y)
                X += Xinc;           
                Y += Yinc;         
                    
                System.out.println();
            }
        }   
}
