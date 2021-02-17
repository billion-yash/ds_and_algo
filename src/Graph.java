import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private  LinkedList<Integer> adj[];

    Graph(int vertices){
           adj= new LinkedList[vertices];
           for (int i = 1 ; i<vertices ; i++ ){
               adj[i] = new LinkedList<>();
           }
    }

    public void addEdge(int source , int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public void BFS(int source , int destination){
        boolean visited[] = new boolean[adj.length];
        int  parent[] = new int[adj.length];

        Queue<Integer> queue= new LinkedList<>();
        queue.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int neighbor : adj[current]){
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent[neighbor] = current;
                }
            }
        }

        int cur = destination;
        while (parent[cur] != -1){
            System.out.print(cur + " -> ");
            cur = parent[cur];
        }
        System.out.print(cur);
    }

    public static void main(String arg[]){
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(1 ,3);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(4,5);

        graph.BFS(1 , 5 );
    }
}
