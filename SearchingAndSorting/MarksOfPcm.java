/*
Explanation: Firstly, the Physics marks of 
students are sorted in ascending order.
Those having same marks in Physics have
their Chemistry marks in descending order.
Those having same marks in both Physics
and Chemistry have their Math marks in
ascending order.

*/


class MarksOfPcm
{
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        int n=phy.length;
        marks arr[]=new marks[n];
        for(int i=0;i<n;i++){
            arr[i]=new marks(phy[i],chem[i],math[i]);  //creating object and store them in array 
        }
        
        Arrays.sort(arr);  //sort the array on basis of marks
        
        for(int i=0;i<n;i++){
            phy[i]=arr[i].phy;
            chem[i]=arr[i].chem;
            math[i]=arr[i].math;
        }
    }
    
    class marks implements Comparable<marks>{   //imlement comparable interface to sort marks
        int phy;
        int chem;
        int math;
      
      marks(){
          
      }
      
    marks(int phy,int chem,int math){
        this.phy=phy;
        this.chem=chem;
        this.math=math;
    }
    
     public int compareTo(marks obj){
        if(this.phy!=obj.phy){
            return this.phy-obj.phy;
        }else if(this.chem!=obj.chem){
            return obj.chem-this.chem;
        }else{
            return this.math-obj.math;
        }
    }
    
    }
    
}
