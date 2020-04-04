package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap <E> implements PriorityQueue<E> {

	int size = 0;
	int capacity = 16;
	boolean useComp;
	Comparator<? super E> comp;
	@SuppressWarnings("unchecked")
	E[] array = (E[]) new Object[capacity];
	
	
	public BinaryMaxHeap() {
		useComp = false;
	}
	
	public BinaryMaxHeap(Comparator<? super E> comp) {
		useComp = true;

		this.comp = comp;
	}
	
	public BinaryMaxHeap(List<? extends E> list) {
		useComp = false;
	}
	
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> comp) {
		useComp = true;
		this.comp = comp;
	}

	@Override
	public void add(E item) {
		if(size == 0) {
			this.array[0] = item;
			this.size++;
			return;
		}
		
		this.array[size()] = item;
		this.size++;
		
		percolateUp();
	}

	@Override
	public E peek() throws NoSuchElementException {
		return this.array[0];
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		E max = peek();

		

		return max;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.array = (E[]) new Object[capacity];
		this.size = 0;
	}

	@Override
	public Object[] toArray() {
		return this.array;
	}
	
	private void buildHeap() {
		//
	}
	
	private void percolateUp() 
	{
		//formula for parents:
			//(i-1)/2

		int index = this.size;

		percolateUp(index);
		
		
	}

	private void percolateUp(int index)
	{
		if (index == 0)
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

	private int parent(int index)
	{
		return (index-1)/2;
	}
	
	private void percolateDown() {
		//formula for left child:
			//(2*i)+1
		//forumla for right child:
			//(2*i)+2
	}

	@SuppressWarnings("unchecked")
	private int innerCompare(E parent, E item) 
	{	
		
		if (useComp)
		{
			return this.comp.compare(parent, item);
		}

		return ((Comparable<? super E>)parent).compareTo(item);
	}

}
