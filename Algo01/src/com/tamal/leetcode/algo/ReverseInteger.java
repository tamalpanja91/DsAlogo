package com.tamal.leetcode.algo;

import java.util.ArrayList;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(-2147483647));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);

	}

	public static int reverse(int x) {
		int sign = 1;
		int result=0;
		if(x == -2147483648) {
			return 0;
		}
		if(x<0) {
			x = x*(-1);
			sign = -1;
		} else if (x == 0) {
			return 0;
		}
		ArrayList<Integer> list = new ArrayList<>();
		int dividend = x;
		while (dividend != 0) {
			list.add(dividend%10);
			dividend = dividend/10;
		} ;
		int n = list.size() - 1;
		for(int i=0;i<=n;i++) {
			if(sign < 0 && Double.compare(Integer.MAX_VALUE-result, list.get(i)*Math.pow(10, (n-i))) > -1) {
				result = (int) (result + list.get(i)*Math.pow(10, (n-i)));
			}else if(sign>0 && Double.compare(Integer.MAX_VALUE-result, list.get(i)*Math.pow(10, (n-i))) > 0) {
				result = (int) (result + list.get(i)*Math.pow(10, (n-i)));
			} else {
				result = 0;
				break;
			}
			
		}
		return result*sign;
	}

}
