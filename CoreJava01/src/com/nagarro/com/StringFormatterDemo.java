package com.nagarro.com;

import java.util.HashMap;
import java.util.Map;

public class StringFormatterDemo {

	public static void main(String[] args) {
		System.out.println(String.format("%'12'10d", 93)); // prints: |00000000000000000093|
		Map<String,Object> mm = new HashMap<>();
		mm.put("ww", 121);
		Integer jdeSalesNumber = (Integer) mm.get("ww");
		System.out.println(jdeSalesNumber== null);

	}

}
