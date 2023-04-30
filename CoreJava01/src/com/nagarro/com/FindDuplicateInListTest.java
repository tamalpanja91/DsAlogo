package com.nagarro.com;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FindDuplicateInListTest {

	@Test
	void givenList_whenUsingSet_thenReturnDuplicateElements() {
	    List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5);
	    FindDuplicateInList FindDuplicateInList = new FindDuplicateInList();
	    List<Integer> duplicates = FindDuplicateInList.listDuplicateUsingSet(list);
	    Assert.assertEquals(duplicates.size(), 2);
	    Assert.assertEquals(duplicates.contains(3), true);
	    Assert.assertEquals(duplicates.contains(4), true);
	    Assert.assertEquals(duplicates.contains(1), false);
	}

}
