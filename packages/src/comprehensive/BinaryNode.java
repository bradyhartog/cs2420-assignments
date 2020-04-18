package assign08;

/**
 * Represents a generically-typed binary tree node. Each binary node contains data, a reference to the left child, and a
 * reference to the right child.
 * 
 * @author Erin Parker and Brady Hartog and Vivek Vankayalapati
 * @version March 6, 2020
 */
public class BinaryNode<Type>
{
    /**The data */
    private Type data;

    /**The node representing the parent */
    private BinaryNode<Type> parent;

    /**The node representing the left child */
    private BinaryNode<Type> leftChild;

    /**The node representing the right child */
    private BinaryNode<Type> rightChild;

    /**Whether the node is left of its partent or not */
    private boolean isLeft;
    
    /**
     * Creates a BinaryNode, with members representing the data, its parent, and its children
     * @param data
     * @param parent
     * @param leftChild
     * @param rightChild
     */
    public BinaryNode (Type data, BinaryNode<Type> parent, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild)
    {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;


        
    }

    /**
     * Constructs a leaf
     * @param data
     * @param parent
     */
    public BinaryNode (Type data, BinaryNode<Type> parent)
    {
        this(data, parent, null, null);
    }

    /**
     * Constructs the root node
     * @param data
     */
    public BinaryNode (Type data)
    {
        this(data, null, null, null);
    }

    /**
     * @return the node data
     */
    public Type getData ()
    {
        return data;
    }

    /**
     * @param data - the node data to be set
     */
    public void setData (Type data)
    {
        this.data = data;
    }
    
    /**
     * @return reference to the parent node
     */
    public BinaryNode<Type> getParent ()
    {
    	return parent;
    }
    
    /**
     * @param parent - reference to the parent node to be set
     */
    public void setParent (BinaryNode<Type> parent)
    {
    	this.parent = parent;
    }

    /**
     * @return reference to the left child node
     */
    public BinaryNode<Type> getLeftChild ()
    {
        return leftChild;
    }

    /**
     * @param leftChild - reference of the left child node to be set
     */
    public void setLeftChild (BinaryNode<Type> leftChild)
    {
        this.leftChild = leftChild;

        if (null != this.leftChild)
        {
            this.leftChild.isLeft = true;
        }
        
    }

    /**
     * @return reference to the right child node
     */
    public BinaryNode<Type> getRightChild ()
    {
        
        return this.rightChild; 
    }

    public boolean getIsLeft()
    {
        return this.isLeft;
    }

    /**
     * @param rightChild - reference of the right child node to be set
     */
    public void setRightChild (BinaryNode<Type> rightChild)
    {
        
        this.rightChild = rightChild;

        if (null != this.rightChild)
        {
            this.rightChild.isLeft = false;
        }
        
    }

    /**
     * @return reference to the leftmost node in the binary tree rooted at this node
     */
    public BinaryNode<Type> getLeftmostNode ()
    {
        if (this.getLeftChild() == null)
        {
            return this;
        }
        
        return this.getLeftChild().getLeftmostNode();
        
    }

    /**
     * @return reference to the rightmost node in the binary tree rooted at this node
     */
    public BinaryNode<Type> getRightmostNode ()
    {

        if (this.getRightChild() == null)
        {
            return this;
        }
        
        return this.getRightChild().getRightmostNode();
    }

    /**
     * @return the height of the binary tree rooted at this node
     * 
     *         The height of a tree is the length of the longest path to a leaf node. Consider a tree with a single node
     *         to have a height of zero.
     */
    // public int height ()  //Not sure how this method could be used
    // {
    //     return 0;
    // }
}