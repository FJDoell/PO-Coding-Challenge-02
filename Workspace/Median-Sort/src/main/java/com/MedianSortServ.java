package com;

/**
 * Given two sorted arrays, find the median.
 * @author darkm
 *
 */
public class MedianSortServ {
	
	public MedianSortServ() {
	}
	
	public double findMedian(int[] arr1, int[] arr2) {
		double result = 0.0;
		
		int combinedLength = arr1.length + arr2.length;
		
		int[] combinedArr = new int[combinedLength];
		
		int indexArr1 = 0;
		int indexArr2 = 0;
		for(int i = 0; i < combinedLength - 1; i++) {
			if(indexArr2 == arr2.length) {
				combinedArr[i] = arr1[indexArr1];
				indexArr1++;
			}else if(indexArr1 == arr1.length) {
				combinedArr[i] = arr2[indexArr2];
				indexArr2++;
			}else if(arr1[indexArr1] <= arr2[indexArr2]) {
				combinedArr[i] = arr1[indexArr1];
				indexArr1++;
			}else if(arr1[indexArr1] > arr2[indexArr2]) {
				combinedArr[i] = arr2[indexArr2];
				indexArr2++;
			}
			
//			System.out.println(Math.floor((double) (combinedLength / 2.0)));
//			System.out.println(combinedArr[i]);
			if(i == Math.floor((double) (combinedLength / 2.0))) {
				if(combinedLength % 2 == 0) {
					// Even handler
					// number between latest two elements
					System.out.println("even length");
					int latest = combinedArr[i];
					int prev = combinedArr[i-1];
					result = (latest + prev) / 2.0;
					break;
				} else {
					// Odd handler
					// latest element in result
					System.out.println("odd length");
					result = combinedArr[i];
					break;
				}
			}
		}
		return result;
	}

}
