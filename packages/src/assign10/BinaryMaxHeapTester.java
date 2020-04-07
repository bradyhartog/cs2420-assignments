package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Contains unit tests for a generic PriorityQueue
 */
class BinaryMaxHeapTester {

	BinaryMaxHeap<Integer> heap;
	BinaryMaxHeap<Integer> heapWithComp;
	BinaryMaxHeap<Integer> heapFromList;
	BinaryMaxHeap<Integer> heapWithCompFromList;
	Integer[] expected;

	Integer[] expectedBuild;
	
	@BeforeEach
	void setUp() 
	{
		ArrayList<Integer> integerList = new ArrayList<>();
		
		for(int i = 0; i < 7; i++) {
			integerList.add(i);
		}
		
		heap = new BinaryMaxHeap<>();
		heapWithComp = new BinaryMaxHeap<>((i1, i2) -> i2 - i1);
		heapFromList = new BinaryMaxHeap<>(integerList);
		heapWithCompFromList = new BinaryMaxHeap<>(integerList, (i1, i2) -> i2 - i1);
		
		expected = new Integer[16];
	}
	
	@Test
	void addFirst()
	{
		heap.add(1);
		
		expected[0] = 1;
		
		assertTrue(Arrays.deepEquals(expected, heap.toArray()));
	}

	@Test
	void add()
	{
		for (int i = 0; i < 7; i++) {
			heap.add(i);
		}
		
		expected[0] = 6;
		expected[1] = 3;
		expected[2] = 5;
		expected[3] = 0;
		expected[4] = 2;
		expected[5] = 1;
		expected[6] = 4;
		
		assertTrue(Arrays.deepEquals(expected, heap.toArray()));
	}

	@Test
	void addComparator()
	{
		for (int i = 6; i >= 0; i--) {
			heapWithComp.add(i);
		}
		
		expected[0] = 0;
		expected[1] = 3;
		expected[2] = 1;
		expected[3] = 6;
		expected[4] = 4;
		expected[5] = 5;
		expected[6] = 2;
		
		assertTrue(Arrays.deepEquals(expected, heapWithComp.toArray()));
	}
	
	@Test
	void addComparatorSequential()
	{
		for (int i = 0; i < 7; i++) {
			heapWithComp.add(i);
			expected[i] = i;
		}
		
		assertTrue(Arrays.deepEquals(expected, heapWithComp.toArray()));
	}

	@Test
	void addList()
	{
		expectedBuild = new Integer[heapFromList.size()];
		expectedBuild[0] = 6;
		expectedBuild[1] = 4;
		expectedBuild[2] = 5;
		expectedBuild[3] = 3;
		expectedBuild[4] = 1;
		expectedBuild[5] = 0;
		expectedBuild[6] = 2;
		
		assertTrue(Arrays.deepEquals(expectedBuild, heapFromList.toArray()));
	}

	@Test
	void addComparatorList()
	{
		
	}

	@Test
	void peekEmpty()
	{
		
	}

	@Test
	void peekOne()
	{
		
	}

	@Test
	void peek()
	{
		
	}

	@Test
	void extractEmpty()
	{
		
	}

	@Test
	void extractOne()
	{
		
	}

	@Test
	void extract()
	{
		
	}

	@Test
	void extractComparator()
	{
		
	}

	@Test
	void extractList()
	{
		
	}

	@Test
	void extractComparatorList()
	{
		
	}

	@Test
	void sizeEmpty()
	{
		
	}

	@Test
	void sizeNonEmpty()
	{
		
	}

	@Test
	void empty()
	{
		
	}

	@Test
	void nonEmpty()
	{
		
	}

	@Test
	void clearEmpty()
	{
		
	}

	@Test
	void clear()
	{
		
	}

	@Test
	void toArrayEmpty()
	{
		
	}

	@Test
	void toArrayOne()
	{
		
	}

	@Test
	void toArray()
	{
		
	}

	@Test
	void toArrayComparator()
	{
		
	}

	@Test
	void toArrayList()
	{
		
	}

	@Test
	void toArrayComparatorList()
	{
		
	}

}
