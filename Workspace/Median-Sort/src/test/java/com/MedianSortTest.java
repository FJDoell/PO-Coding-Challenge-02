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
		int[] nums1 = new int[1000];
		for(int i = 1; i < nums1.length; i++)
			nums1[i] = i;
		
		int[] nums2 = new int[1000];
		for(int i = 1; i < nums2.length; i++)
			nums2[i] = i+1000;
		
		double result = serv.findMedian(nums1, nums2);
		assertEquals(998.5, result, "998.5 expected");
	}

}
