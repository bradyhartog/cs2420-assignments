//package comprehensive;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
///**
// * Contains several methods for solving problems on generic, directed, unweighted, sparse graphs.
// * 
// * @author Erin Parker & Brady Hartog & Vivek Vankayalapati
// * @version February 27, 2020
// */
//public class GraphUtility
//{
//
//    /**
//     * Determines if a graph, defined as a list of sources pointing to destinations in a one to one, is cyclic
//     * 
//     * @param <Type>
//     * @param sources
//     * @param destinations
//     * @return cyclicity
//     * @throws IllegalArgumentException if there is a size mismatch between the list of sources and destinations
//     */
//    public static <Type> boolean isCyclic (List<Type> sources, List<Type> destinations) throws IllegalArgumentException
//    {
//
//        // Constructs graph
//        Graph<Type> g = generateGraph(sources, destinations);
//
//        // Iterate through each vertex, traversing each time. If at any the starting vertex was visited
//        // (ie it traversed back), return true
//        Iterator<Vertex<Type>> i = g.vertices.values().iterator();
//
//        while (i.hasNext())
//        {
//            Vertex<Type> curr = i.next();
//            g.DFSDrive(curr); //Timing was tested on isCyclic, but is testable on a single call
//            if (curr.getVisited())
//            {
//                return true;
//            }
//
//            g.clear(curr);  
//        }
//
//        return false;
//    }
//
//    /**
//     * Determines whether two vertices are connected
//     * 
//     * @param <Type>
//     * @param sources
//     * @param destinations
//     * @param srcData
//     * @param dstData
//     * @return connection state
//     * @throws IllegalArgumentException is there is size mismatch or the two vertices are not in the graph
//     */
//    public static <Type> boolean areConnected (List<Type> sources, List<Type> destinations, Type srcData, Type dstData)
//            throws IllegalArgumentException
//    {
//
//        Graph<Type> g = generateGraph(sources, destinations);
//
//        // If the data doesn't exist throw an exception
//        if (!g.vertices.containsKey(srcData) || !g.vertices.containsKey(dstData))
//        {
//            throw new IllegalArgumentException();
//        }
//
//        // Used breadth first search to traverse from the src
//        g.BFS(g.vertices.get(srcData));
//
//        // If the dst was visited, return true, else return false
//        return g.vertices.get(dstData).getVisited();
//    }
//
//    /**
//     * Returns a list containing the topographically sorted acyclic graph, can have multiple correct lists
//     * 
//     * @param <Type>
//     * @param sources
//     * @param destinations
//     * @return List
//     * @throws IllegalArgumentException if size mismatch or is cyclic
//     */
//    public static <Type> List<Type> sort (List<Type> sources, List<Type> destinations) throws IllegalArgumentException
//    {
//        Graph<Type> g = generateGraph(sources, destinations);
//
//        return g.topologicalSort();
//    }
//
//    /**
//     * Generates a graph based on sources and destination lists
//     * 
//     * @param <Type>
//     * @param sources
//     * @param destinations
//     * @return
//     * @throws IllegalArgumentException if size mismatch
//     */
//    public static <Type> Graph<Type> generateGraph (List<Type> sources, List<Type> destinations)
//            throws IllegalArgumentException
//    {
//        Graph<Type> graph = new Graph<>();
//
//        int size = sources.size();
//
//        if (size != destinations.size())
//        {
//            throw new IllegalArgumentException();
//        }
//
//        for (int i = 0; i < size; i++)
//        {
//            graph.addEdge(sources.get(i), destinations.get(i));
//        }
//
//        return graph;
//    }
//}