package com.tamal.leetcode.algo;

public class LogestPalindrome {
	class Solution {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0) 
	            return "";
	        if(s.length() == 1) 
	            return s;
	        
	        int l = s.length();
	        boolean[][] charMat = new boolean[l][l];

	        // Diagonal elem
	        for(int i = 0; i < l; i++) 
	            charMat[i][i] = true;
	        
	        int startInd = 0;
	        int endInd = 0;
	        int maxSize = 0;
	        // elem for len 2
	        for(int i = 0; i < l-1; i++) {
	            if(s.charAt(i) == s.charAt(i+1)) {
	                charMat[i][i+1] = true;
	                startInd = i;
	                endInd = i+1; 
	                maxSize = 2;
	            }
	        }

	        for(int size = 3 ; size <= l; size++) {
	            for(int i = 0; i+size-1 < l ; i++) {
	                int j = i+size-1;
	                if(charMat[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
	                    charMat[i][j] = true;
	                    if(size > maxSize) {
	                        maxSize = size;
	                        startInd = i;
	                        endInd = j;
	                    }
	                        
	                }
	            }
	        }
	        if(endInd == l-1)
	            return s.substring(startInd);
	        else 
	            return s.substring(startInd, endInd+1);

	        
	    }

	}
}
