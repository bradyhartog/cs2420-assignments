package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap <E> implements PriorityQueue<E> {

	int size = 0;
	int capacity = 16;
	
	@SuppressWarnings("unchecked")
	E[] array = (E[]) new Object[capacity];
	
	
	public BinaryMaxHeap() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryMaxHeap(Comparator<? super E> comp) {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryMaxHeap(List<? extends E> list) {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> comp) {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
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
	
	private void percolateUp() {
		//
	}
	
	private void percolateDown() {
		//
	}
	
	private void innerCompare() {
		//
	}

}
