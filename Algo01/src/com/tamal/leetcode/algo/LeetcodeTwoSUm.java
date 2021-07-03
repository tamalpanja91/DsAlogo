package com.tamal.leetcode.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
https://leetcode.com/problems/two-sum/
 * 
 * **/
 
public class LeetcodeTwoSUm {
	public static void main(String[] args) {
		printArray(twoSumWithHsh(new int[]{1,2,3,4},5));
	}
	
	private static void printArray(int[] objArr) {
		Arrays.stream(objArr).forEach(elem -> System.out.println(elem));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		for(int i=0 ; i<nums.length; i++) {
			int res = target-nums[i];
			for(int j= i+1; j<nums.length; j++) {
				if(res==nums[j]) {
					ans[0] =i;
					ans[1]=j;
					break;
				}
			}
		}
		return ans;
	}
	
	public static int[] twoSumWithHsh(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
}
