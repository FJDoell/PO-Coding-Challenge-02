package com;

import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergekSortedTest {
	
	MergeLinkedListsService serv = new MergeLinkedListsService();

	@Test
	void test() {
		LinkedList<Integer> test1 = new LinkedList<Integer>();
		test1.add(1);
		test1.add(4);
		test1.add(5);
		
		LinkedList<Integer> test2 = new LinkedList<Integer>();
		test2.add(1);
		test2.add(3);
		test2.add(4);
		
		LinkedList<Integer> test3 = new LinkedList<Integer>();
		test3.add(2);
		test3.add(6);
		
		LinkedList<LinkedList<Integer>> completeList = new LinkedList<LinkedList<Integer>>();
		completeList.add(test1);
		completeList.add(test2);
		completeList.add(test3);
		
		LinkedList<Integer> expectedList = new LinkedList<Integer>();
		expectedList.add(1);
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(4);
		expectedList.add(4);
		expectedList.add(5);
		expectedList.add(6);
		
		LinkedList<Integer> result = serv.combineLists(completeList);
		
		Assertions.assertArrayEquals(expectedList.toArray(), result.toArray(), "test arrays equal");
	}
	
	@Test
	void testEmpty() {
		LinkedList<Integer> test4 = new LinkedList<Integer>();
		
		LinkedList<Integer> test5 = new LinkedList<Integer>();
		test5.add(1);
		test5.add(3);
		test5.add(4);
		
		LinkedList<Integer> test6 = new LinkedList<Integer>();
		test6.add(2);
		test6.add(6);

		LinkedList<Integer> test7 = new LinkedList<Integer>();
		
		LinkedList<LinkedList<Integer>> completeList = new LinkedList<LinkedList<Integer>>();
		completeList.add(test4);
		completeList.add(test5);
		completeList.add(test6);
		completeList.add(test7);
		
		LinkedList<Integer> expectedList2 = new LinkedList<Integer>();
		expectedList2.add(1);
		expectedList2.add(2);
		expectedList2.add(3);
		expectedList2.add(4);
		expectedList2.add(6);
		
		LinkedList<Integer> result2 = serv.combineLists(completeList);
		
		Assertions.assertArrayEquals(expectedList2.toArray(), result2.toArray(), "test arrays equal");
	}

}
