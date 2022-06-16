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
        if(arr1.length == 0 && arr2.length == 0)
			return 0.0;
		if(arr1.length == 0)
			return findMedian(arr2);
		if(arr2.length == 0)
			return findMedian(arr1);
		
		int combinedLength = arr1.length + arr2.length;
		
		int[] combinedArr = new int[combinedLength];
		
		int indexArr1 = 0;
		int indexArr2 = 0;
		for(int i = 0; i <= combinedLength - 1; i++) {
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
			
			if(i == Math.floor((double) (combinedLength / 2.0))) {
				if(combinedLength % 2 == 0) {
					// Even handler
					int latest = combinedArr[i];
					int prev = combinedArr[i-1];
					result = (latest + prev) / 2.0;
					break;
				} else {
					// Odd handler
					result = combinedArr[i];
					break;
				}
			}
		}
		return result;
	}
	
	public double binaryFindMedian(int[] arr1, int[] arr2) {
		if(arr1.length == 0 && arr2.length == 0)
			return 0.0;
		if(arr1.length == 0)
			return findMedian(arr2);
		if(arr2.length == 0)
			return findMedian(arr1);
		
		double result = 0.0;
		
		int combinedLength = arr1.length + arr2.length;
		int onEachSide = (int) Math.floor(combinedLength / 2.0);

		int arr1LeftPartIndex = onEachSide - 1;
		int arr2LeftPartIndex = onEachSide - arr1LeftPartIndex - 1;
		int arr1Next = 0;
		int arr2Next = 0;
		boolean partitionFound = false;
		
		if(combinedLength % 2 == 0) {
			// even case
			while(!partitionFound) {
				// 'Infinity' values to handle out of range values.
				arr1Next = getIndexVal(arr1, arr1LeftPartIndex+1);
				arr2Next = getIndexVal(arr2, arr2LeftPartIndex+1);

				// Check if it's safe to get the current indexes with current range
				
				// Update left partition if necessary
				if(getIndexVal(arr1, arr1LeftPartIndex) > arr2Next) {
					arr1LeftPartIndex--;
					// Update the other partition.
					arr2LeftPartIndex = onEachSide - arr1LeftPartIndex - 1;
				} else if(getIndexVal(arr2, arr2LeftPartIndex) > arr1Next) {
					arr1LeftPartIndex++;
					// Update the other partition.
					arr2LeftPartIndex = onEachSide - arr1LeftPartIndex - 1;
				}
				
				// Check if we found the median
				else if(getIndexVal(arr1, arr1LeftPartIndex) <= arr2Next && getIndexVal(arr2, arr2LeftPartIndex) <= arr1Next) {
					partitionFound = true;
					result = (getIndexVal(arr1, arr1LeftPartIndex) + getIndexVal(arr2, arr2LeftPartIndex)) / 2.0;
					return result;
				}
			}
		}
		// odd case
		arr2LeftPartIndex = onEachSide - arr1LeftPartIndex;
		while(!partitionFound) {
			// 'Infinity' values to handle out of range values.
			arr1Next = getIndexVal(arr1, arr1LeftPartIndex+1);
			arr2Next = getIndexVal(arr2, arr2LeftPartIndex+1);
			
			// Update left partition if necessary
			if(getIndexVal(arr1, arr1LeftPartIndex) > arr2Next) {
				arr1LeftPartIndex--;
				// Update the other partition.
				arr2LeftPartIndex = onEachSide - arr1LeftPartIndex;
			} else if(getIndexVal(arr2, arr2LeftPartIndex) > arr1Next) {
				arr1LeftPartIndex++;
				// Update the other partition.
				arr2LeftPartIndex = onEachSide - arr1LeftPartIndex;
			}
			
			// Check if we found the median
			else if(getIndexVal(arr1, arr1LeftPartIndex) <= arr2Next && getIndexVal(arr2, arr2LeftPartIndex) <= arr1Next) {
				partitionFound = true;
				result = Math.min(getIndexVal(arr1, arr1LeftPartIndex), getIndexVal(arr2, arr2LeftPartIndex));
				return result;
			}
		}
		return result;
	}
	
	public double findMedian(int[] arr) {
		double result = 0.0;
		if(arr.length == 0)
			return result;
		
		int onEachSide = (int) Math.floor(arr.length / 2.0);
		if(arr.length % 2 == 0) {
			// even case
			result = (double) (arr[onEachSide-1] + arr[onEachSide]) / 2;
			return result;
		}
		// odd case
		return arr[onEachSide];
	}
	
	public int getIndexVal(int[] arr, int index) {
		if(index > arr.length - 1)
			return Integer.MAX_VALUE;
		if(index < 0)
			return Integer.MIN_VALUE;
		return arr[index];
	}

}
