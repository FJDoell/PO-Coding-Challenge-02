package com;

import java.util.LinkedList;
import java.util.List;

public class MergeLinkedListsService {
	
	MergeLinkedListsService() {
	}
	
	public LinkedList<Integer> combineLists(List<LinkedList<Integer>> linkedList) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int lowest = 0;
		int lowestListIndex = 0;
		
		while(linkedList.size() > 0) {
			lowest = 2147483647;
			for(LinkedList<Integer> list : linkedList) {
//				System.out.println(list);
				// If list size is 0, remove it
				if(list.size() <= 0) {
					linkedList.remove(list);
				} else if(lowest > list.get(0)) {
					lowest = list.get(0);
//					System.out.println("INDEX " + linkedList.indexOf(list));
					lowestListIndex = linkedList.indexOf(list);
				}
			}
			if(linkedList.size() == 0)
				break;
//			System.out.println(linkedList.get(lowestListIndex).get(0));
			result.add(linkedList.get(lowestListIndex).removeFirst());
		}
		
		return result;
	}

}
