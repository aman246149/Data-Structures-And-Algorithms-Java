public class AdjancyMatrix {
    
    int edges;
    int vertices;
    int adjMatrix[][];

    AdjancyMatrix(int ver){
        this.vertices=ver;
        this.edges=0;
        this.adjMatrix=new int [ver][ver];
    }

    void addEdge(int u,int v){
        adjMatrix[u][v]=1;
        adjMatrix[v][u]=1;
        edges++;
    }

    void display(){
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        AdjancyMatrix adj=new AdjancyMatrix(4);
        adj.addEdge(0, 1);
        adj.addEdge(1, 2);
        adj.addEdge(2, 3);
        adj.addEdge(3, 0);
        adj.display();
    }
}
