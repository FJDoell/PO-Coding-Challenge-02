package com;

import java.util.LinkedList;
import java.util.List;

public class MergeLinkedListsService {
	
	MergeLinkedListsService() {
	}
	
	public LinkedList<Integer> combineLists(List<LinkedList<Integer>> linkedList) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		LinkedList<Integer> toRemove = null;
		
		int lowest = 0;
		int lowestListIndex = 0;
		
		while(linkedList.size() > 0) {
			lowest = 2147483647;
			for(LinkedList<Integer> list : linkedList) {
//				System.out.println(list);
				// If list size is 0, remove it
				if(list.size() <= 0) {
					toRemove = list;
				} else if(lowest > list.get(0)) {
					lowest = list.get(0);
//					System.out.println("INDEX " + linkedList.indexOf(list));
					lowestListIndex = linkedList.indexOf(list);
				}
			}
			if(toRemove != null) {
				linkedList.remove(toRemove);
				toRemove = null;
			} else {
//				System.out.println(linkedList.get(lowestListIndex).get(0));
				result.add(linkedList.get(lowestListIndex).removeFirst());
			}
			if(linkedList.size() == 0)
				break;
		}
		
		return result;
	}

}
