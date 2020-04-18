package comprehensive;

import java.util.*;

/**
 * Represents a directed graph (a set of vertices and a set of edges).
 * 
 * @author Erin Parker, Brady Hartog, and Vivek Vankayalapati
 * @version February 28, 2020
 */
public class Graph
{
    /**
     * The graph, a set of vertices each with an element
     */
    HashMap<String, Vertex> vertices;

    /**
     * Constructs an empty graph.
     */
    public Graph ()
    {
        vertices = new HashMap<String, Vertex>();
    }

    /**
     * Adds to the graph an edge from the vertex with name "vertex1" to the vertex with name "vertex2". The edge is
     * associated with the "weight". If either vertex does not already exist in the graph, it is added.
     */
    public void addEdge (String src, String dst)
    {
        Vertex vertex1;

        if (vertices.containsKey(src))
            vertex1 = vertices.get(src);

        else
        {
            vertex1 = new Vertex(src);
            vertices.put(src, vertex1);
        }

        Vertex vertex2;

        if (vertices.containsKey(dst))
            vertex2 = vertices.get(dst);

        else
        {
            vertex2 = new Vertex(dst);
            vertices.put(dst, vertex2);
        }

        vertex1.addEdge(vertex2);
    }

//    /**
//     * Breadth first search algorithm
//     * 
//     * @param s
//     */
//    public void BFS (Vertex<Type> s)
//    {
//        // Create a queue for BFS
//        LinkedList<Vertex<Type>> queue = new LinkedList<Vertex<Type>>();
//
//        // Mark the current node as visited and enqueue it
//        s.setVisited(true);
//        queue.add(s);
//
//        while (queue.size() != 0)
//        {
//            // Dequeue a vertex from queue
//            s = queue.poll();
//
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it as visited and enqueue it
//            Iterator<Edge<Type>> i = s.edges();
//            while (i.hasNext())
//            {
//                Vertex<Type> n = i.next().getOtherVertex();
//                if (!n.getVisited())
//                {
//                    n.setVisited(true);
//                    queue.add(n);
//                }
//            }
//        }
//    }
//
//    /**
//     * Depth first search algorithm
//     * 
//     * @param s
//     */
//    private void DFS (Vertex<Type> s)
//    {
//        // Mark the current node as visited
//        s.setVisited(true);
//
//        // Iterate for all edges
//        Iterator<Edge<Type>> i = s.edges();
//        while (i.hasNext())
//        {
//            Vertex<Type> n = i.next().getOtherVertex();
//            if (!n.getVisited())
//                DFS(n); // Recur
//        }
//    }
//
//    /**
//     * Driver method for Depth First Search
//     * 
//     * @param s
//     */
//    public void DFSDrive (Vertex<Type> s)
//    {
//
//        // Makes sure the starting vertex starts unvisited
//        s.setVisited(false);
//
//        // Essentially first loop for DFS
//        Iterator<Edge<Type>> i = s.edges();
//        if (i.hasNext())
//        {
//            Vertex<Type> n = i.next().getOtherVertex();
//            if (!n.getVisited())
//                DFS(n);
//        }
//    }
//
//    /**
//     * Clears the visited state of vertices traversed
//     * 
//     * @param s
//     */
//    public void clear (Vertex<Type> s)
//    {
//        // Mark the current node as visited and print it
//        s.setVisited(false);
//
//        // Recur for all the vertices adjacent to this vertex
//        Iterator<Edge<Type>> i = s.edges();
//        while (i.hasNext())
//        {
//            Vertex<Type> n = i.next().getOtherVertex();
//            if (n.getVisited())
//                clear(n);
//        }
//    }
//
//    /**
//     * Returns a list of elements sorted topographically
//     * 
//     * @return
//     */
//    public List<Type> topologicalSort () throws IllegalArgumentException
//    {
//        // The queue
//        LinkedList<Vertex<Type>> queue = new LinkedList<>();
//
//        // Contains the sorted elements
//        LinkedList<Type> sorted = new LinkedList<>();
//
//        Collection<Vertex<Type>> vertices = this.vertices.values();
//
//        // Goes through all vertices and sets the indegree
//        Iterator<Vertex<Type>> i = vertices.iterator();
//
//        while (i.hasNext())
//        {
//            Iterator<Edge<Type>> j = i.next().edges();
//            while (j.hasNext())
//            {
//                Vertex<Type> n = j.next().getOtherVertex();
//
//                int indegree = n.getIndegree();
//
//                n.setIndegree(++indegree);
//            }
//        }
//
//        // Populates the queue with vertices of indegree 0
//        Iterator<Vertex<Type>> k = vertices.iterator();
//        while (k.hasNext())
//        {
//            Vertex<Type> n = k.next();
//
//            if (n.getIndegree() == 0)
//                queue.addLast(n);
//        }
//
//        // Places items in the queue, puts those now sorted elements in a list and shifts the indegree accordingly
//        while (!queue.isEmpty())
//        {
//            Vertex<Type> v = queue.removeFirst();
//            Type element = v.getElement();
//            sorted.add(element);
//
//            Iterator<Edge<Type>> j = v.edges();
//            while (j.hasNext())
//            {
//                Vertex<Type> n = j.next().getOtherVertex();
//
//                int indegree = n.getIndegree();
//                n.setIndegree(--indegree);
//
//                if (n.getIndegree() == 0)
//                {
//                    queue.addLast(n);
//                }
//            }
//        }
//        
//        if (this.vertices.size() != sorted.size())
//        {
//            throw new IllegalArgumentException();
//        }
//
//        return sorted;
//    }
}