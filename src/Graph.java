import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    private boolean DFSUsingRecursionUtil(int source , int destination , boolean visited[]){
        if(destination == source)
            return true;

        for (int neighbor : adj[source]){
            if (!visited[neighbor]){
                visited[neighbor] = true;
                if (DFSUsingRecursionUtil(neighbor, destination, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public void DFSUsingRecursion(int source , int destination){
        boolean visited[] = new boolean[adj.length];
        System.out.println( "\n"+DFSUsingRecursionUtil(source ,destination , visited));
    }

    public boolean DFSUsingStack(int source , int destination){
        boolean visited [] = new boolean[adj.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()){
            int current = stack.pop();

            for (int neighbor : adj[current]){
                if (neighbor == destination) {
                    return true;
                }
                if(!visited[neighbor])
                {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String arg[]){
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(1 ,3);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        graph.BFS(4 , 5 );
        graph.DFSUsingRecursion(1 , 5);
        System.out.println(graph.DFSUsingStack(1,5));
    }
}
