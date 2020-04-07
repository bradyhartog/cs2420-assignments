package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
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
	BinaryMaxHeap<Integer> heapFromRepeatList;
	Integer[] expected;
	Integer[] expectedOne;
	Integer[] expectedBlank;
	Integer[] expectedBuild;
	
	@BeforeEach
	void setUp() 
	{
		ArrayList<Integer> integerList = new ArrayList<>();
		
		for (int i = 0; i < 7; i++) {
			integerList.add(i);
		}
		
		ArrayList<Integer> integerListReverse = new ArrayList<>();
		
		for (int i = 6; i >= 0; i--) {
			integerListReverse.add(i);
		}
		
		ArrayList<Integer> repeatList = new ArrayList<>();
		
		for (int i = 0; i < 7; i++) {
			repeatList.add(7);
		}
		
		heap = new BinaryMaxHeap<>();
		heapWithComp = new BinaryMaxHeap<>((i1, i2) -> i2 - i1);
		heapFromList = new BinaryMaxHeap<>(integerList);
		heapWithCompFromList = new BinaryMaxHeap<>(integerListReverse, (i1, i2) -> i2 - i1);
		heapFromRepeatList = new BinaryMaxHeap<>(repeatList);
		
		expected = new Integer[7];
		expectedOne = new Integer[1];
		expectedBlank = new Integer[0];
	}
	
	@Test
	void addFirst()
	{
		heap.add(1);
		
		expectedOne[0] = 1;
		
		assertTrue(Arrays.deepEquals(expectedOne, heap.toArray()));
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
		expectedBuild = new Integer[heapWithCompFromList.size()];
		expectedBuild[0] = 0;
		expectedBuild[1] = 2;
		expectedBuild[2] = 1;
		expectedBuild[3] = 3;
		expectedBuild[4] = 5;
		expectedBuild[5] = 6;
		expectedBuild[6] = 4;
		
		assertTrue(Arrays.deepEquals(expectedBuild, heapWithCompFromList.toArray()));
	}
	
	@Test
	void addComparatorListWithDuplicates()
	{
		for (int i = 0; i < 7; i++) {
			heapWithCompFromList.add(i);
		}
		
		expectedBuild = new Integer[14];
		expectedBuild[0] = 0;
		expectedBuild[1] = 0;
		expectedBuild[2] = 1;
		expectedBuild[3] = 1;
		expectedBuild[4] = 2;
		expectedBuild[5] = 4;
		expectedBuild[6] = 4;
		expectedBuild[7] = 3;
		expectedBuild[8] = 2;
		expectedBuild[9] = 5;
		expectedBuild[10] = 3;
		expectedBuild[11] = 6;
		expectedBuild[12] = 5;
		expectedBuild[13] = 6;
		
		assertTrue(Arrays.deepEquals(expectedBuild, heapWithCompFromList.toArray()));
	}
	
	@Test
	void addRepeated()
	{
		for (int i = 0; i < 7; i++) {
			heap.add(7);
			expected[i] = 7;
		}
		
		assertTrue(Arrays.deepEquals(expected, heap.toArray()));
	}
	
	@Test
	void addRepeatedFromList()
	{
		expectedBuild = new Integer[7];
		for (int i = 0; i < 7; i++) {
			expectedBuild[i] = 7;
		}
		
		assertTrue(Arrays.deepEquals(expectedBuild, heapFromRepeatList.toArray()));
	}

	@Test
	void peekEmpty()
	{
        assertThrows(NoSuchElementException.class, () -> {
            heap.peek();
        });
	}

	@Test
	void peekOne()
	{
		heap.add(1);
		
		assertEquals(1, heap.peek());
	}

	@Test
	void peek()
	{
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		
		assertEquals(4, heap.peek());
	}

	@Test
	void extractEmpty()
	{
		assertThrows(NoSuchElementException.class, () -> {
            heap.extractMax();
        });
	}

	@Test
	void extractOne()
	{
		heap.add(1);
		
		assertEquals(1, heap.extractMax());
		
		assertThrows(NoSuchElementException.class, () -> {
            heap.extractMax();
        });
	}

	@Test
	void extract()
	{
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		
		assertEquals(4, heap.extractMax());
		assertEquals(3, heap.extractMax());
		assertEquals(2, heap.extractMax());
		assertEquals(1, heap.extractMax());
		
		assertThrows(NoSuchElementException.class, () -> {
            heap.extractMax();
        });
	}

	@Test
	void extractComparator()
	{
		heapWithComp.add(4);
		heapWithComp.add(3);
		heapWithComp.add(2);
		heapWithComp.add(1);
		
		assertEquals(1, heapWithComp.extractMax());
		assertEquals(2, heapWithComp.extractMax());
		assertEquals(3, heapWithComp.extractMax());
		assertEquals(4, heapWithComp.extractMax());
		
		assertThrows(NoSuchElementException.class, () -> {
            heapWithComp.extractMax();
        });
	}

	@Test
	void extractList()
	{
		assertEquals(6, heapFromList.extractMax());
		assertEquals(5, heapFromList.extractMax());
		assertEquals(4, heapFromList.extractMax());
		assertEquals(3, heapFromList.extractMax());
		assertEquals(2, heapFromList.extractMax());
		assertEquals(1, heapFromList.extractMax());
		assertEquals(0, heapFromList.extractMax());
		
		assertThrows(NoSuchElementException.class, () -> {
            heapFromList.extractMax();
        });
	}

	@Test
	void extractComparatorList()
	{
		assertEquals(0, heapWithCompFromList.extractMax());
		assertEquals(1, heapWithCompFromList.extractMax());
		assertEquals(2, heapWithCompFromList.extractMax());
		assertEquals(3, heapWithCompFromList.extractMax());
		assertEquals(4, heapWithCompFromList.extractMax());
		assertEquals(5, heapWithCompFromList.extractMax());
		assertEquals(6, heapWithCompFromList.extractMax());
		
		assertThrows(NoSuchElementException.class, () -> {
            heapWithCompFromList.extractMax();
        });
	}

	@Test
	void sizeEmpty()
	{
		assertEquals(0, heap.size());
	}

	@Test
	void sizeNonEmpty()
	{
		heap.add(1);
		
		assertEquals(1, heap.size());
	}

	@Test
	void empty()
	{
		assertTrue(heap.isEmpty());
	}

	@Test
	void nonEmpty()
	{
		heap.add(1);
		
		assertFalse(heap.isEmpty());
	}

	@Test
	void clearEmpty()
	{
		heap.clear();
		
		assertTrue(Arrays.deepEquals(expectedBlank, heap.toArray()));
		assertTrue(heap.isEmpty());
	}

	@Test
	void clear()
	{
		heap.add(0);
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);
		heap.add(6);
		
		heap.clear();
		
		assertTrue(Arrays.deepEquals(expectedBlank, heap.toArray()));
		assertTrue(heap.isEmpty());
	}

	@Test
	void toArrayEmpty()
	{
		assertTrue(Arrays.deepEquals(expectedBlank, heap.toArray()));
	}

	@Test
	void toArrayOne()
	{
		heap.add(1);
		expectedOne[0] = 1;
		
		assertTrue(Arrays.deepEquals(expectedOne, heap.toArray()));
	}

	@Test
	void toArray()
	{
		heap.add(0);
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);
		heap.add(6);
		
		expected[0] = 6;
		expected[1] = 3;
		expected[2] = 5;
		expected[3] = 0;
		expected[4] = 2;
		expected[5] = 1;
		expected[6] = 4;
		
		assertTrue(Arrays.deepEquals(expected, heap.toArray()));
	}
}
