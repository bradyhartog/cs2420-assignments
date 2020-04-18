package comprehensive;

/**
 * This class represents an edge between a source vertex and a destination vertex in a directed graph.
 * 
 * The source of this edge is the Vertex whose object has an adjacency list containing this edge.
 * 
 * @author Erin Parker & Brady Hartog & Vivek Vankayalapati
 * @version February 28, 2020
 */
public class Edge
{

    /**
     * Destination of the edge
     */
    private Vertex dst;

    /**
     * Constructs an edge to the destination vertex
     * 
     * @param dst
     */
    public Edge (Vertex dst)
    {
        this.dst = dst;
    }

    /**
     * Gets the destination vertex
     * 
     * @return dst
     */
    public Vertex getOtherVertex ()
    {
        return this.dst;
    }

    /**
     * Gets the destination vertex's element
     * 
     * @return element
     */
    public String Element ()
    {
        return this.dst.getElement();
    }
}