package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Collects of tests for finding the k Largest items in a list
 */
class FindKLargestTester 
{
	List<Integer> emptyList;
	List<Integer> oneList;
	List<Integer> list;
	List<Integer> duplicateList;
	List<Integer> correctList;
	List<Integer> correctDuplicateList;
	List<Integer> correctListComp;
	List<Integer> correctDuplicateListComp;
	Comparator<Integer> comp;

	@BeforeEach
	void setUp() throws Exception 
	{
		emptyList = new ArrayList<Integer>();
		oneList = new ArrayList<Integer>();
		oneList.add(42);
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(0);
		Collections.shuffle(list);
		duplicateList = new ArrayList<Integer>();
		duplicateList.add(6);
		duplicateList.add(4);
		duplicateList.add(2);
		duplicateList.add(3);
		duplicateList.add(5);
		duplicateList.add(1);
		duplicateList.add(0);
		duplicateList.add(6);
		duplicateList.add(4);
		duplicateList.add(2);
		duplicateList.add(3);
		duplicateList.add(5);
		duplicateList.add(1);
		duplicateList.add(0);
		Collections.shuffle(duplicateList);
		
		comp  =  (i1, i2) -> i2 - i1;

		correctList = new ArrayList<Integer>();
		correctList.add(6);
		correctList.add(5);
		correctList.add(4);
		correctList.add(3);

		correctListComp = new ArrayList<Integer>();
		correctListComp.add(0);
		correctListComp.add(1);
		correctListComp.add(2);
		correctListComp.add(3);

		correctDuplicateList = new ArrayList<Integer>();
		correctDuplicateList.add(6);
		correctDuplicateList.add(6);
		correctDuplicateList.add(5);
		correctDuplicateList.add(5);

		correctDuplicateListComp = new ArrayList<Integer>();
		correctDuplicateListComp.add(0);
		correctDuplicateListComp.add(0);
		correctDuplicateListComp.add(1);
		correctDuplicateListComp.add(1);


	}

	@Test
	void kHeapkTooSmall()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			FindKLargest.findKLargestHeap(list, -42);
		 });
	}

	@Test
	void kSortKTooBig() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			FindKLargest.findKLargestSort(list, 42);
		 });
	}

	@Test
	void kSortKTooSmall() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			FindKLargest.findKLargestSort(list, -42);
		 });
	}

	@Test
	void emptyListKTooBig() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			FindKLargest.findKLargestSort(emptyList, 4);
		 });
	}

	@Test
	void emptyListHeap() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestHeap(emptyList, 0));
	}

	@Test
	void emptyListSort() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestSort(emptyList, 0));
	}
	@Test
	void emptyListHeapComp() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestHeap(emptyList, 0,comp));
	}

	@Test
	void emptyListSortComp() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestSort(emptyList, 0,comp));
	}

	@Test
	void K0listHeap() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestHeap(list, 0));
	}

	@Test
	void K0listHeapComp() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestHeap(list, 0,comp));
	}

	@Test
	void K0listSort() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestSort(list, 0));
	}

	@Test
	void K0SortComp() 
	{
		assertEquals(emptyList,FindKLargest.findKLargestSort(list, 0,comp));
	}

	@Test
	void oneListHeap() 
	{
		assertEquals(oneList,FindKLargest.findKLargestHeap(oneList, 1));
	}

	@Test
	void oneListHeapComp() 
	{
		assertEquals(oneList,FindKLargest.findKLargestHeap(oneList, 1,comp));
	}

	@Test
	void oneListSort() 
	{
		assertEquals(oneList,FindKLargest.findKLargestSort(oneList, 1));
	}

	@Test
	void oneListSortComp() 
	{
		assertEquals(oneList,FindKLargest.findKLargestSort(oneList, 1,comp));
	}

	@Test
	void listHeap() 
	{
		assertEquals(correctList,FindKLargest.findKLargestHeap(list, 4));
	}

	@Test
	void listHeapComp() 
	{
		assertEquals(correctListComp,FindKLargest.findKLargestHeap(list, 4,comp)); 
	} 

	
	@Test
	void listSort() 
	{
		assertEquals(correctList,FindKLargest.findKLargestSort(list, 4));
	}

	@Test
	void listSortComp() 
	{
		assertEquals(correctListComp,FindKLargest.findKLargestSort(list, 4,comp)); 
	}

	@Test
	void duplicateListHeap() 
	{
		assertEquals(correctDuplicateList,FindKLargest.findKLargestHeap(duplicateList, 4));
	}

	@Test
	void duplicateListHeapComp() 
	{
		assertEquals(correctDuplicateListComp,FindKLargest.findKLargestHeap(duplicateList, 4,comp)); 
	}

	
	@Test
	void duplicateListSort() 
	{
		assertEquals(correctDuplicateList,FindKLargest.findKLargestSort(duplicateList, 4));
	}

	@Test
	void duplicateListSortComp() 
	{	
		assertEquals(correctDuplicateListComp,FindKLargest.findKLargestSort(duplicateList, 4,comp)); 
	}
}

