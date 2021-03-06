package com.tamal.leetcode.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingChars {

	public static int lengthOfLongestSubstring(String s) {
		char[] sArr = s.toCharArray();
		int lastLength =0;
		Set<Character> uniqueSet = new HashSet<>();
		Queue<Character> q = new LinkedList<>();
		for(Character c: sArr) {
			q.add(c);
			if(!uniqueSet.add(c)) {
				lastLength = Math.max(lastLength, uniqueSet.size());
				removeUntilAdd(uniqueSet,q, c);
			} else {
				lastLength = Math.max(lastLength, uniqueSet.size());
			}
		}
		return lastLength;
	}
	
	private static void removeUntilAdd(Set<Character> s,Queue<Character> q, Character c) {
		do {
			Character ch = q.poll();
			s.remove(ch);
			if(s.add(c)) {
				break;
			}
		} while(!q.isEmpty());
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("qrsvbspk"));
		System.out.println(longestUniqueSubsttr1("qrsvbspk"));
		

	}
	
	
	public static int longestUniqueSubsttr(String str)
	{
	    int n = str.length();
	     
	    // Result
	    int res = 0;
	     
	    for(int i = 0; i < n; i++)
	    {
	         
	        // Note : Default values in visited are false
	        boolean[] visited = new boolean[256];
	         
	        for(int j = i; j < n; j++)
	        {
	             
	            // If current character is visited
	            // Break the loop
	            if (visited[str.charAt(j)] == true)
	                break;
	 
	            // Else update the result if
	            // this window is larger, and mark
	            // current character as visited.
	            else
	            {
	                res = Math.max(res, j - i + 1);
	                visited[str.charAt(j)] = true;
	            }
	        }
	 
	        // Remove the first character of previous
	        // window
	        visited[str.charAt(i)] = false;
	    }
	    return res;
	}
	
	static int longestUniqueSubsttr1(String str)
    {
        int n = str.length();
 
        int res = 0; // result
 
        // last index of all characters is initialized
        // as -1
        int [] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
 
        // Initialize start of current window
        int i = 0;
 
        // Move end of current window
        for (int j = 0; j < n; j++) {
 
            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);
 
            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);
 
            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }

}
