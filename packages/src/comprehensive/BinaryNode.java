package comprehensive;

/**
 * Represents a String binary tree node. Each binary node contains data, a reference to the left child, and a
 * reference to the right child.
 * 
 * @author Erin Parker and Brady Hartog and Vivek Vankayalapati
 * @version March 6, 2020
 */
public class BinaryNode
{
    /**The data */
    private String data;

    /**The node representing the left child */
    private BinaryNode leftChild;

    /**The node representing the right child */
    private BinaryNode rightChild;

    /**
     * Creates a BinaryNode, with members representing the data and its children
     * @param data
     * @param parent
     * @param leftChild
     * @param rightChild
     */
    public BinaryNode (String data, BinaryNode leftChild, BinaryNode rightChild)
    {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;    
    }

    /**
     * @return the node data
     */
    public String getData ()
    {
        return data;
    }

    /**
     * @return reference to the left child node
     */
    public BinaryNode getLeftChild ()
    {
        return leftChild;
    }

    /**
     * @return reference to the right child node
     */
    public BinaryNode getRightChild ()
    {
        return this.rightChild; 
    }
}