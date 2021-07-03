package com.tamal.leetcode.algo;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbbbcd"));

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		int res=0;
		int startIndex=-1;
		int endIndex = -1;
		for(int i = 0; i<s.length(); i++) {
			//check sunstring starting with s.charAt(i)
			int k=i;
			int z = len-1;
			int temp = 0;
			int n=1;
			boolean firstMatch = false;
			int startIndexTemp=-1;
			int endIndexTemp = -1;
			while(z>=k) {
				if(s.charAt(k)==s.charAt(z)) {
					if(k==z || (z-k)==1) {
						if(temp>res) {
							res = temp;
							startIndex = startIndexTemp;
							endIndex = endIndexTemp;
						}
					}
					if(firstMatch) {
						k++;
					} else {
						firstMatch= true;
						temp = Math.max(res, z-k+1);
						startIndexTemp=k;
						endIndexTemp=z;
						if(k==z || (z-k)==1) {
							if(temp>res) {
								res = temp;
								startIndex = startIndexTemp;
								endIndex = endIndexTemp;
							}
						}
						k++;
					}
					z--;
				} else {
					z=len-1-n;
					n++;
					temp=0;
					k=i;
					firstMatch= false;
				}
			}
		}
		StringBuilder strb = new StringBuilder();
		if(startIndex !=-1 && endIndex !=-1) {
		for(int j = startIndex; j<= endIndex ; j++) {
			strb.append(s.charAt(j));
		}
		}
		return strb.toString();
	}

}
