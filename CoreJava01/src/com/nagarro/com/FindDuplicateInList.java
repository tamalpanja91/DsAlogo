package com.nagarro.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Using the contains() Method of Set
	List<Integer> listDuplicateUsingSet(List<Integer> list) {
	    List<Integer> duplicates = new ArrayList<>();
	    Set<Integer> set = new HashSet<>();
	    for (Integer i : list) {
	        if (set.contains(i)) {
	            duplicates.add(i);
	        } else {
	            set.add(i);
	        }
	    }
	    return duplicates;
	}
	
	//Using a Map and Storing the Frequency of Elements
	List<Integer> listDuplicateUsingMap(List<Integer> list) {
	    List<Integer> duplicates = new ArrayList<>();
	    Map<Integer, Integer> frequencyMap = new HashMap<>();
	    for (Integer number : list) {
	        frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
	    }
	    for (int number : frequencyMap.keySet()) {
	        if (frequencyMap.get(number) != 1) {
	            duplicates.add(number);
	        }
	    }
	    return duplicates;
	}
	
	//Using filter() and Set.add() Method
	List<Integer> listDuplicateUsingFilterAndSetAdd(List<Integer> list) {
	    Set<Integer> elements = new HashSet<Integer>();
	    return list.stream()
	      .filter(n -> !elements.add(n))
	      .collect(Collectors.toList());
	}
	
	//Using Collections.frequency()
	List<Integer> listDuplicateUsingCollectionsFrequency(List<Integer> list) {
	    List<Integer> duplicates = new ArrayList<>();
	    Set<Integer> set = list.stream()
	      .filter(i -> Collections.frequency(list, i) > 1)
	      .collect(Collectors.toSet());
	    duplicates.addAll(set);
	    return duplicates;
	}
	
	//Using Map and Collectors.groupingBy()
	List<Integer> listDuplicateUsingMapAndCollectorsGroupingBy(List<Integer> list) {
	    List<Integer> duplicates = new ArrayList<>();
	    Set<Integer> set = list.stream()
	      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	      .entrySet()
	      .stream()
	      .filter(m -> m.getValue() > 1)
	      .map(Map.Entry::getKey)
	      .collect(Collectors.toSet());
	    duplicates.addAll(set);
	    return duplicates;
	}

}
