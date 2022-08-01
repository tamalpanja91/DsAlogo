package com.tamal.leetcode.algo;

public class ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int numRows) {
		StringBuilder result = new StringBuilder();
		if(s == null) {
			return result.toString();
		} else if (numRows <1) {
			return result.toString();
		} else if (numRows ==1) {
			return s;
		}
		int n = s.length();
		int c = 2*(numRows - 1);
		int k = n/c;
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<=k; j++) {
				if((i + c*j) < n ) {
					result.append(s.charAt(i + c*j));
				}
				if(i != 0 && i != numRows-1) {
					if((i + c*j+c-2*i) < n ) {
						result.append(s.charAt(i + c*j+c-2*i));
					}
				}
				
			}
		}
		return result.toString();
	}

}
