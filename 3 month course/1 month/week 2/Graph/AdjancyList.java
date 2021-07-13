import java.util.LinkedList;
import java.util.Stack;

public class AdjancyList {
    int edge;
    int vertices;
    LinkedList<Integer> adjlist[];

    AdjancyList(int ver){
        this.edge=0;
        this.vertices=ver;
        this.adjlist=new LinkedList[ver];

        for (int i = 0; i < ver; i++) {
            adjlist[i]=new LinkedList<>();
        }
    }

    void addEdge(int u,int v){
        adjlist[u].add(v);
        adjlist[v].add(u);
        edge++;
    }

    void print(){
        for (LinkedList<Integer> linkedList : adjlist) {
            for (Integer integer : linkedList) {
                System.out.print(integer+" ");
            }System.out.println();
        }
    }

    void bfsToPrintAllVerticesInGraph(int s){
        boolean[] visited=new boolean[vertices];

        LinkedList<Integer> que=new LinkedList<>();

        visited[s]=true;
        que.addLast(s);

        System.out.println("Breadth First Search");
        while (!que.isEmpty()) {
            int u=que.removeFirst();
           
            for(int node:adjlist[u]){
                if (!visited[node]) {
                    visited[node]=true;
                    que.addLast(node);
                }
            }
        }
    }

    void dfsToPrintAllVerticesInGraph(int source){
        boolean[] visited=new boolean[vertices];
        Stack<Integer> st=new Stack<>();
        System.out.println("DEPTH FIRST SEARCH");
        st.push(source);
        while (!st.isEmpty()) {
                int u=st.pop();
                if(!visited[u]){
                    visited[u]=true;
                    System.out.print(u+" ");
                    for (Integer node : adjlist[u]) {
                        if (!visited[node]) {
                            st.push(node);
                        }
                    }
                }
        }
    }
    public static void main(String[] args) {
        AdjancyList adj=new AdjancyList(4);
        adj.addEdge(0, 1);
        adj.addEdge(1, 2);
        adj.addEdge(2, 3);
        adj.addEdge(3, 0);
        adj.print();
        adj.bfsToPrintAllVerticesInGraph(0);
        adj.dfsToPrintAllVerticesInGraph(0);
    }
}
