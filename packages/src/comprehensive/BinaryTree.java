package comprehensive;

import java.util.ArrayList;

/**
 * A Generic Binary Tree
 * @author Brady Hartog and Vivek Vankayalapati
 */
public class BinaryTree
{
    /**The root node */
    private BinaryNode rootNode;

    /**The number of items in the BinaryTree */
    private int size;

    /**
     * Constructs a Binary Search Tree. Defined by a root node with an inaccesible parent for edge cases and its progeny
     */
    public BinaryTree ()
    {
         //A null root node
         this.rootNode = new BinaryNode(null,null,null);  
         size = 0;
    }

    public BinaryTree (String data, BinaryNode leftChild, BinaryNode rightChild)
    {
         //A null root node
         this.rootNode = new BinaryNode(data,leftChild,rightChild);  
         size = 0;
    }

    
    public boolean add (String item)
    {
        this.rootNode = new BinaryNode
    }

    public int size ()  //complete
    {
        return this.size;
    }


    // public ArrayList<String> toArrayList () //complete
    // {
    //     ArrayList<String> list = new ArrayList<String>();
        
	//     if (size != 0)
	//     {
	//     	listing(this.rootNode,list);
	//     }

    //     return list;
    // }
    /**
     * Performs an inorder traversal, adding node data values to an input array list
     * @param node
     * @param list
     */
    private void (BinaryNode node, ArrayList<String> list)
    {
        //do a recursive traversal of the subtree on the right
        if(node.getLeftChild() != null)
            listing(node.getLeftChild(),list);

        // "visit" this node
        node.getData()

        // do a recursive traversal of the subtree on the right
        if(node.getRightChild() != null)
            listing(node.getRightChild(),list);
    }

}
