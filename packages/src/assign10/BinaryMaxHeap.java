package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A Generic Binary Max Heap
 * 
 * @author Brady Hartog & Vivek Vankayalapati
 * @version April 9, 2020
 */
public class BinaryMaxHeap<E> implements PriorityQueue<E>
{
	/** Size of the Heap */
	int size = 0;

	/** Size of the backing array */
	int capacity = 16;

	/** Determines when to use a comparator */
	boolean useComp;

	/** Stores the comparator (When used) */
	Comparator<? super E> comp;

	/** Backing array for the Heap */
	E[] array;

	/**
	 * Constructs an empty Binary Max Heap
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap()
	{
		this.array = (E[]) new Object[capacity];
		useComp = false;
	}

	/**
	 * Constructs an empty Binary Max Heap that uses a Comparator
	 * 
	 * @param comp
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(Comparator<? super E> comp)
	{
		this.array = (E[]) new Object[capacity];
		useComp = true;
		this.comp = comp;
	}

	/**
	 * Constructs a Binary Max Heap from a list of elements
	 * 
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> list)
	{
		this.capacity = list.size();
		this.array = (E[]) new Object[capacity];
		useComp = false;
		buildHeap(list);
	}

	/**
	 * Constructs a Binary Max Heap from a list of elements that uses a Comparator
	 * 
	 * @param list
	 * @param comp
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> comp)
	{
		this.capacity = list.size();
		this.array = (E[]) new Object[capacity];
		useComp = true;
		this.comp = comp;
		buildHeap(list);
	}

	@Override
	public void add(E item)
	{
		if (size == 0)
		{
			this.array[0] = item;
			this.size++;
			return;
		}

		if (this.size + 1 >= this.capacity)
		{
			resize();
		}

		this.array[size()] = item;
		this.size++;
		percolateUp();
	}

	/**
	 * Doubles the capacity of the backing array
	 */
	@SuppressWarnings("unchecked")
	private void resize()
	{
		this.capacity *= 2;
		E[] tempArray = (E[]) new Object[capacity];

		int i = 0;
		for (E element : this.array)
		{
			tempArray[i] = element;
			i++;
		}

		this.array = tempArray;
	}

	@Override
	public E peek() throws NoSuchElementException
	{
		if (size() == 0)
		{
			throw new NoSuchElementException();
		}

		return this.array[0];
	}

	@Override
	public E extractMax() throws NoSuchElementException
	{
		if (size() == 0)
		{
			throw new NoSuchElementException();
		}

		E max = peek();

		this.array[0] = this.array[size() - 1];
		size--;
		percolateDown();

		return max;
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public boolean isEmpty()
	{
		return (this.size == 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		this.array = (E[]) new Object[capacity];
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray()
	{
		Object[] arrayOut = (E[]) new Object[this.size];

		for (int i = 0; i < this.size; i++)
		{
			arrayOut[i] = this.array[i];
		}

		return arrayOut;
	}

	/**
	 * Constructs a Heap from a given list
	 * 
	 * @param list
	 */
	private void buildHeap(List<? extends E> list)
	{
		for (E item : list)
		{
			this.array[this.size] = item;
			this.size++;
		}

		// Doesn't percolate the leaves
		for (int i = this.size / 2 - 1; i >= 0; i--)
		{
			percolateDown(i);
		}
	}

	/**
	 * Driver method for percolating up a Binary Heap
	 */
	private void percolateUp()
	{
		int index = this.size - 1;

		percolateUp(index);
	}

	/**
	 * Percolates up the Binary Heap from a given index
	 */
	private void percolateUp(int index)
	{
		if (index <= 0)
		{
			return;
		}

		E parent = this.array[parent(index)];
		E item = this.array[index];

		if (innerCompare(parent, item) < 0)
		{
			E temp = item;

			this.array[index] = parent;

			this.array[parent(index)] = temp;

			percolateUp(parent(index));
		}
	}

	/**
	 * Calculates the index of a parent from a given index. Note that elements start
	 * at index 0
	 * 
	 * @param index
	 * @return
	 */
	private int parent(int index)
	{
		return (index - 1) / 2;
	}

	/**
	 * Calculates the index of a left child from a given index. Note that elements
	 * start at index 0
	 * 
	 * @param index
	 * @return
	 */
	private int leftChild(int index)
	{
		return 2 * index + 1;
	}

	/**
	 * Calculates the index of a right child from a given index. Note that elements
	 * start at index 0
	 * 
	 * @param index
	 * @return
	 */
	private int rightChild(int index)
	{
		return 2 * index + 2;
	}

	/**
	 * Driver method for percolating down a Binary Heap
	 */
	private void percolateDown()
	{
		percolateDown(0);
	}

	/**
	 * Percolates down the Binary Heap from a given index
	 */
	private void percolateDown(int index)
	{
		/*
		 * If item < left && left > right switch left
		 * 
		 * If item < right && right > left switch right
		 */

		int leftIndex = leftChild(index);

		if (leftIndex > size() - 1)
		{
			return;
		}

		E leftChild = this.array[leftIndex];
		E rightChild = null;
		E item = this.array[index];

		boolean useLeft = innerCompare(item, leftChild) < 0;
		boolean useRight = false;
		boolean leftIsGreater = true;

		int rightIndex = rightChild(index);

		if (rightIndex <= size() - 1)
		{
			rightChild = this.array[rightChild(index)];

			useRight = innerCompare(item, rightChild) < 0;
			leftIsGreater = innerCompare(leftChild, rightChild) > 0;
		}

		if (useLeft && leftIsGreater)
		{
			E temp = leftChild;

			this.array[leftChild(index)] = item;
			this.array[index] = temp;

			percolateDown(leftChild(index));
		} else if (useRight && !leftIsGreater)
		{
			E temp = rightChild;

			this.array[rightChild(index)] = item;
			this.array[index] = temp;

			percolateDown(rightChild(index));
		}
	}

	/**
	 * Performs a comparison of two items. Changes depending on whether or not a
	 * Comparator is used.
	 */
	@SuppressWarnings("unchecked")
	private int innerCompare(E parent, E item)
	{
		if (useComp)
		{
			return this.comp.compare(parent, item);
		}

		return ((Comparable<? super E>) parent).compareTo(item);
	}

}
