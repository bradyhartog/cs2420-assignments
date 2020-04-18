package comprehensive;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * This class represents a vertex (AKA node) in a directed graph. The vertex is not generic, assumes that a string name
 * is stored there.
 * 
 * @author Erin Parker & Brady Hartog and Vivek Vankayalapati
 * @version February 28, 2020
 */
public class Vertex
{
    /**
     * Data stored in the Vertex
     */
    private String element;

    /**
     * Stores the distance from start
     */
    private double distanceFromStart;

    /**
     * Stores whether a vertex is visited or not
     */
    private boolean visited;

    /**
     * Previous vertex
     */
    private Vertex previousVertex;

    /**
     * List containing adjacent edges
     */
    private LinkedList<Edge> adj;

    /**
     * The indegree of the vertex, initially 0;
     */
    private int indegree = 0;

    /**
     * Constructs a vertex
     * 
     * @param element
     */
    public Vertex (String element)
    {
        this.element = element;
        this.adj = new LinkedList<Edge>();
    }

    /**
     * Gets the element in the vertex
     * 
     * @return element
     */
    public String getElement ()
    {
        return element;
    }

    /**
     * Adds an edge, based on a reference to another vertex
     * 
     * @param otherVertex
     */
    public void addEdge (Vertex otherVertex)
    {
        adj.add(new Edge(otherVertex));
    }

    /**
     * Returns list of edges from the vertex
     * 
     * @return edges
     */
    public LinkedList<Edge> getEdges ()
    {
        return adj;
    }

    /**
     * Iterator for the edges
     * 
     * @return iterator
     */
    public Iterator<Edge> edges ()
    {
        return adj.iterator();
    }

    /**
     * Sets the distance from start
     * 
     * @param distanceFromStart
     */
    public void setDistanceFromStart (double distanceFromStart)
    {
        this.distanceFromStart = distanceFromStart;
    }

    /**
     * Gets the distance from start
     * 
     * @return distance from start
     */
    public double getDistanceFromStart ()
    {
        return distanceFromStart;
    }

    /**
     * Sets the reference to the previous vertex
     * 
     * @param previousVertex
     */
    public void setPrevious (Vertex previousVertex)
    {
        this.previousVertex = previousVertex;
    }

    /**
     * Gets the previous vertex
     * 
     * @return previousVertex
     */
    public Vertex getPrevious ()
    {
        return previousVertex;
    }

    /**
     * Sets the vertex as visited or not
     * 
     * @param visited
     */
    public void setVisited (boolean visited)
    {
        this.visited = visited;
    }

    /**
     * Gets whether vertex was visited
     * 
     * @return visited
     */
    public boolean getVisited ()
    {
        return visited;
    }

    /**
     * Sets the indegree
     * 
     * @param indegree
     */
    public void setIndegree (int indegree)
    {
        this.indegree = indegree;
    }

    /**
     * Gets the indegree
     * 
     * @return indegree
     */
    public int getIndegree ()
    {
        return this.indegree;
    }
}