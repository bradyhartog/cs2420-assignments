package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * A Generic Binary Tree
 * @author Brady Hartog and Vivek Vankayalapati
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>
{

    /**The root node */
    private BinaryNode<Type> rootNode;

    private BinaryNode<Type> fakeParent;

    /**The number of items in the BinarySearchTree */
    private int size;

    /**
     * Constructs a Binary Search Tree. Defined by a root node with an inaccesible parent for edge cases and its progeny
     */
    public BinarySearchTree ()
    {
        //The node has parent for the purpose of access, analagous to a head for a doubly linked list
         this.fakeParent = new BinaryNode<Type>(null);

         //A null root node
         this.rootNode = new  BinaryNode<Type>(null,this.fakeParent);


        //Parent left child is the rootnode
        this.fakeParent.setLeftChild(this.rootNode);
        
         size = 0;
    }

    @Override
    public boolean add (Type item)
    {
        //Generates the root node
        if (this.rootNode.getData() == null)
        {
        	this.rootNode.setData(item);
        	size++;
        	return true;
        }
        
        //Run if insertion was successful
    	if (insert(this.rootNode,item))
        {
            size++;
            return true;
        }
       
        return false;
    }
    
    /**
     * Helper method for add. Performs the insertion.
     * @param node
     * @param item
     */
    private boolean insert (BinaryNode<Type> node, Type item)
    {   //Left branch
    	if (item.compareTo(node.getData()) < 0)
        {   
            //Insertion
        	if (node.getLeftChild() == null)
        	{
        		BinaryNode<Type> newNode = new BinaryNode<>(item, node);
        		
        		node.setLeftChild(newNode);
        		
        		return true;
            }
            
        	else
        	{   
                //Continue searching
        		return insert(node.getLeftChild(), item);
        	}
        }

        //Right branch
        else if (item.compareTo(node.getData()) > 0)
        {   
            //Insertion
        	if (node.getRightChild() == null)
        	{
        		BinaryNode<Type> newNode = new BinaryNode<>(item, node);
        		
        		node.setRightChild(newNode);
        		
        		return true;
        	}
        	else
        	{   
                //Continue search
        		return insert(node.getRightChild(), item);
        	}
        }
        
        //Returns false is item is in BST
        return false;
    }

    @Override
    public boolean addAll (Collection<? extends Type> items)
    {
        Iterator<? extends Type> i = items.iterator();

        int successCounter = 0;

        while (i.hasNext())
        {
        	boolean ifAdded = add(i.next());
        	
            if (ifAdded)
            {
                successCounter++;
            }
        
        }

        if(successCounter>0)
        {
            return true;
        }

        return false;
    }

    @Override
    public void clear ()
    {
        //Sets the data members to null
        this.rootNode.setData(null);
        this.rootNode.setRightChild(null);
        this.rootNode.setLeftChild(null);
        this.size = 0;
    }

    @Override
    public boolean contains (Type item)
    {
        if (this.rootNode.getData() == null)
        {
            return false;
        }

        BinaryNode<Type> node = contains(this.rootNode, item);
        
        return (node != null);
    }

    private BinaryNode<Type> contains (BinaryNode<Type> node, Type item)
    {
        //If node is null, then it doesn't contain
        if (node == null)
        {
            return node;
        }

        int compare = item.compareTo(node.getData());

        //If found
        if (compare == 0)
        {
            return node;
        }
        else if (compare < 0)
    	{
            //Continue searching
    		return contains(node.getLeftChild(), item);
    	}
        //Right tree traversal
    	return contains(node.getRightChild(), item);
    }

    @Override
    public boolean containsAll (Collection<? extends Type> items)
    {
    	Iterator<? extends Type> i = items.iterator();
        
        while (i.hasNext())
        {
        	boolean doesContain = contains(i.next());
        	
        	if (!doesContain)
        	{
        		return false;
        	}
        }
        
        return true;
    }

    @Override
    public Type first () throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        return this.rootNode.getLeftmostNode().getData();
    }

    @Override
    public boolean isEmpty ()
    {
    	if (this.size == 0)
    	{
    		return true;
    	}
    	
        return false;
    }

    @Override
    public Type last () throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        
        return this.rootNode.getRightmostNode().getData();
    }

    @Override
    public boolean remove (Type item) //Incomplete
    {
    	int initialSize = size();
        
        if (initialSize == 0)
        { 
            return false;
        }

        else
        {
             return findAndRemove(rootNode, item);
        }
    	
    }

    
    /**
     * Deletes a leaf node
     * @param node 
     */
    private void delete(BinaryNode<Type> node)
    {
        if (node.getIsLeft())
        {
            node.getParent().setLeftChild(null);
        }
        else
        {
            node.getParent().setRightChild(null);
        }
    }
    
    /**
     * Helper method for remove. Performs the removal.
     * @param node
     * @param item
     */
    private boolean findAndRemove (BinaryNode<Type> node, Type item) // Test comment
    {   
        //If the node is null, them removal can't occur
        if (node == null)
        {
            return false;
        }

        //If the node is found
    	if (item.compareTo(node.getData()) == 0)
    	{
            //Leaf
    		if (node.getLeftChild() == null && node.getRightChild() == null)
    		{
                delete(node);
                size--;
                return true;
            }
            //Only a left child
    		else if (node.getRightChild() == null)
    		{
                Type leftChildData = node.getLeftChild().getData();
                
                node.setData(leftChildData);
                
                node.getLeftChild().setParent(node.getParent());
                
                if (node.getIsLeft())
                {
            		node.getParent().setLeftChild(node.getLeftChild());
                }
                else
                {
                	node.getParent().setRightChild(node.getLeftChild());
                }
                
                size--;
                return true;
            }
            //Only a right child
    		else if (node.getLeftChild() == null)
    		{
    			Type rightChildData = node.getRightChild().getData();
                
                node.setData(rightChildData);
                
                node.getRightChild().setParent(node.getParent());
                
                if (node.getIsLeft())
                {
            		node.getParent().setLeftChild(node.getRightChild());
                }
                else
                {
                	node.getParent().setRightChild(node.getRightChild());
                }
                
                size--;
                return true;
            }
            //Two children
    		else
    		{
    			BinaryNode<Type> minNode = node.getRightChild().getLeftmostNode();
    			
				Type minNodeData = minNode.getData();
				
				remove(minNodeData);
				
				node.setData(minNodeData);
    		}
    	}
    	//Continue searching
    	else if (item.compareTo(node.getData()) < 0)
    	{
    		return findAndRemove(node.getLeftChild(), item);
    	}
    	
    	else if (item.compareTo(node.getData()) > 0)
    	{
    		return findAndRemove(node.getRightChild(), item);
        }
        
        return false;
    }

    @Override
    public boolean removeAll (Collection<? extends Type> items)
    {
        Iterator<? extends Type> i = items.iterator();

        int removeCounter = 0;

        while (i.hasNext())
        {
        	boolean ifRemoved = remove(i.next());
        	
            if (ifRemoved)
            {
                removeCounter++;
            }       
        }

        return (removeCounter > 0);
    }

    @Override
    public int size ()  //complete
    {
        return this.size;
    }

    @Override
    public ArrayList<Type> toArrayList () //complete
    {
        ArrayList<Type> list = new ArrayList<Type>();
        
	    if (size != 0)
	    {
	    	listing(this.rootNode,list);
	    }

        return list;
    }
    /**
     * Performs an inorder traversal, adding node data values to an input array list
     * @param node
     * @param list
     */
    private void listing (BinaryNode<Type> node,ArrayList<Type> list)
    {
        //do a recursive traversal of the subtree on the right
        if(node.getLeftChild() != null)
            listing(node.getLeftChild(),list);

        // "visit" this node
        list.add(node.getData());

        // do a recursive traversal of the subtree on the right
        if(node.getRightChild() != null)
            listing(node.getRightChild(),list);
    }

}
