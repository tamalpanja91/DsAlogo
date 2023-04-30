package com.nagarro.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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

}
