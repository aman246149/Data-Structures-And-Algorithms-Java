
class Graph {
    int v;
    int e;
    int [][] adjmatrix;

    Graph(int data){
        v=data;
        e=0;
        adjmatrix=new int[v][v];
    }
    void addEdge(int u,int v){
        adjmatrix[u][v]=1;
        adjmatrix[v][u]=1;
        e++;
    }
  
    void display(){
        for (int i = 0; i < adjmatrix.length; i++) {
            for (int j = 0; j < adjmatrix.length; j++) {
                System.out.print(adjmatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.display();
	}
}
