package com.nagarro.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 	X?	X occurs once or not at all
	X+	X occurs once or more times
	X*	X occurs zero or more times
	X{n}	X occurs n times only
	X{n,}	X occurs n or more times
	X{y,z}	X occurs at least y times but less than z times
 * 
 * 
 */
public class RegExDemo {

	public static void main(String[] args) {
		RegExDemo regExDemo = new RegExDemo();
		regExDemo.demo5();

	}
	
	private void demo1() {
		int count = 0;
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("ababbaba");
		while(m.find()) {
			count++;
			System.out.println(m.start()+"..."+m.end()+"..."+m.group());
		}
		
	}
	
	private void demo2() {
		int count = 0;
		/*[abc] Either a or b or c
		 * [^abc] Except a, b, c
		 * [a-z] any lower case alphabet symbol
		 * [A-Z] any upeer case alphabet symbol
		 * [a-zA-z] any alphabet symbol
		 * [0-9] any digit from 0 to 9
		 * [a-zA-Z0-9] any alphanumeric character
		 * [^a-zA-Z0-9] except alphanumeric character 
		 * \s space character
		 * \S except space character
		 * \d any digit from 0-9
		 * \D except digit 
		 * \w any word/alphanumeric character
		 * \W except word character ie special character
		 * . any character
		 * a+ at least one a
		 * a* any no of a including 0
		 * a? atmost one a ie 0 or 1
		 */
		Pattern p = Pattern.compile("z(a[0-9]ba|b[0-9]ca)");
		Matcher m = p.matcher("za3babzakbabazb5ca");
		while(m.find()) {
			count++;
			System.out.println(m.start()+"..."+m.end()+"..."+m.group());
		}
		
	}
	
	private void demo3() {
		int count = 0;
		//mobile
		//? means o or 1 time
		Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher m = p.matcher("9548745874");
		while(m.find()) {
			count++;
			System.out.println(m.start()+"..."+m.end()+"..."+m.group());
		}
		
	}
	
	private void demo4() {
		int count = 0;
		/*email
		First character is alphanumeric
		then any character
		[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+
		for gmail: [a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com
		*/
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher m = p.matcher("abhc_huh@gmail.com");
		while(m.find()) {
			count++;
			System.out.println(m.start()+"..."+m.end()+"..."+m.group());
		}
		
	}
	
	private void demo5() {
		int count = 0;
		/*Custom
		 * Allower character: a-z A-Z 0-9 # $
		 * Length atleast 2
		 * first character should be lower alphabet a to k
		 * second character should be any digit divisible 3 ie 0,3,6,9
		 * 
		 * To represent all names starts with a or A
		 * [aA][a-zA-Z]*
		 * 
		 * To representation ens with l
		 * [a-zA-Z]*[lL]
		 * 
		 * To represents all names that starts with a or A and end with l or L
		 * [aA][]
		 */
		Pattern p = Pattern.compile("402 is located.+from (ab|df|cd).+to (ab|df|cd)[.]");
		Matcher m = p.matcher("402 is located 8\", 38\", 68\" from ab to cd.");
		while(m.find()) {
			count++;
			System.out.println(m.start()+"..."+m.end()+"..."+m.group());
			String output = m.replaceFirst("new new");
			System.out.println(output);
		}
		
	}
	
	private void demo6() {
		int count = 0;
		String str = "2.0507\"";
		System.out.println("str>>>"+str.replaceAll(".0000\"|000\"|00\"|0\"", "\""));
		
	}

}
