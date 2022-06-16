package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MedianSortTest {
	
	MedianSortServ serv = new MedianSortServ();

	@Test
	void testOne() {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		
		double result = serv.findMedian(nums1, nums2);
		
		assertEquals(2.0, result, "2.0 expected");
	}
	
	@Test
	void testTwo() {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		
		double result = serv.findMedian(nums1, nums2);
		
		assertEquals(2.5, result, "2.5 expected");
	}
	
	@Test
	void testThree() {
		int[] nums1 = {1, 6, 8};
		int[] nums2 = {3, 4};
		
		double result = serv.findMedian(nums1, nums2);
		
		assertEquals(4.0, result, "4.0 expected");
	}
	
	@Test
	void testLarge() {
		int[] nums1 = new int[1000];
		for(int i = 1; i < nums1.length; i++)
			nums1[i] = i;
		
		int[] nums2 = new int[1000];
		for(int i = 1; i < nums2.length; i++)
			nums2[i] = i+1000;
		
		double result = serv.findMedian(nums1, nums2);
		assertEquals(998.5, result, "998.5 expected");
	}
	
	@Test
	void testEmpty() {
		int[] nums1 = {};
		int[] nums2 = {};
		
		double result = serv.findMedian(nums1, nums2);
		assertEquals(0.0, result, "0.0 expected");
	}
	
	@Test
	void testTwoOnes() {
		int[] nums1 = {1};
		int[] nums2 = {1};

		double result = serv.findMedian(nums1, nums2);
		assertEquals(1.0, result, "1.0 expected");
	}
	
	@Test
	void testNegative() {
		int[] nums1 = {1, 2};
		int[] nums2 = {-1, 3};

		double result = serv.findMedian(nums1, nums2);
		assertEquals(1.5, result, "1.5 expected");
	}
	
	// *******************
	// BINARY METHOD TESTS
	// *******************
	@Test
	void testBinaryOne() {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		
		double result = serv.binaryFindMedian(nums1, nums2);
		
		assertEquals(2.0, result, "2.0 expected");
	}
	
	@Test
	void testBinaryTwo() {
		int[] nums2 = {1, 2};
		int[] nums1 = {3, 4};

		double result = serv.binaryFindMedian(nums1, nums2);
		
		assertEquals(2.5, result, "2.5 expected");
	}
	
	@Test
	void testBinaryThree() {
		int[] nums1 = {1, 6, 8};
		int[] nums2 = {3, 4};

		double result = serv.binaryFindMedian(nums1, nums2);
		
		assertEquals(4.0, result, "4.0 expected");
	}
	
	@Test
	void testBinaryLarge() {
		int[] nums1 = new int[1000];
		for(int i = 1; i < nums1.length; i++)
			nums1[i] = i;
		
		int[] nums2 = new int[1000];
		for(int i = 1; i < nums2.length; i++)
			nums2[i] = i+1000;

		double result = serv.binaryFindMedian(nums1, nums2);
		assertEquals(998.5, result, "998.5 expected");
	}
	
	@Test
	void testBinaryEmpty() {
		int[] nums1 = {};
		int[] nums2 = {};

		double result = serv.binaryFindMedian(nums1, nums2);
		assertEquals(0.0, result, "0.0 expected");
	}
	
	@Test
	void testBinaryTwoOnes() {
		int[] nums1 = {1};
		int[] nums2 = {1};

		double result = serv.binaryFindMedian(nums1, nums2);
		assertEquals(1.0, result, "1.0 expected");
	}
	
	@Test
	void testBinaryNegative() {
		int[] nums1 = {1, 2};
		int[] nums2 = {-1, 3};

		double result = serv.binaryFindMedian(nums1, nums2);
		assertEquals(1.5, result, "1.5 expected");
	}
	
	// ******************
	// TEST SINGLE MEDIAN
	// ******************
	@Test
	void testSingleOne() {
		int[] nums1 = {1, 2, 3};
		
		double result = serv.findMedian(nums1);
		
		assertEquals(2.0, result, "2.0 expected");
	}
	
	@Test
	void testSingleTwo() {
		int[] nums1 = {1, 2, 3, 4};
		
		double result = serv.findMedian(nums1);
		
		assertEquals(2.5, result, "2.5 expected");
	}
	
	@Test
	void testSingleThree() {
		int[] nums1 = {1, 3, 4, 6, 8};
		
		double result = serv.findMedian(nums1);
		
		assertEquals(4.0, result, "4.0 expected");
	}
	
	@Test
	void testSingleLarge() {
		int[] nums1 = new int[2000];
		for(int i = 1; i < nums1.length; i++)
			nums1[i] = i;
		
		double result = serv.findMedian(nums1);
		assertEquals(999.5, result, "999.5 expected");
	}
	
	@Test
	void testSingleEmpty() {
		int[] nums1 = {};
		
		double result = serv.findMedian(nums1);
		assertEquals(0.0, result, "0.0 expected");
	}
	
}
