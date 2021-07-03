package com.tamal.leetcode.algo;

/*
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 * 
 */
public class LeetcodeAddTwoNumber {

	public static void main(String[] args) {
		ListNode l11 =new ListNode(2);
		ListNode l12 = new ListNode(4);
		l11.next=l12;
		ListNode l13 = new ListNode(3);
		l12.next=l13;
		
		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		l21.next=l22;
		ListNode l23 = new ListNode(4);
		l22.next=l23;
		ListNode l24 = new ListNode(9);
		//l23.next=l24;
		ListNode l25 = new ListNode(9);
		l24.next=l25;
		ListNode l26 = new ListNode(9);
		l25.next=l26;
		ListNode l27 = new ListNode(9);
		l26.next=l27;
		ListNode l28 = new ListNode(9);
		l27.next=l28;
		ListNode l29 = new ListNode(9);
		l28.next=l29;
		ListNode l210 = new ListNode(9);
		l29.next=l210;
		printListNote(addTwoNumbers(l11, l21));
		
	}
	
	private static void printListNote(ListNode ln) {
		ListNode temp=ln;
		while(temp!=null) {
			System.out.println(temp.val);
			temp=temp.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp1=l1;
		ListNode temp2=l2;
		ListNode result = new ListNode();
		ListNode temp =result;
		int carry=0;
		do {
			carry = createNode(temp,temp1==null?0:temp1.val,temp2==null?0:temp2.val , carry );
			temp1 = temp1==null? null :temp1.next;
			temp2 = temp2==null? null :temp2.next;
			if(temp1!=null || temp2!=null) {
				temp.next=new ListNode();
				temp = temp.next;
			} else if(carry>0) {
				temp.next=new ListNode();
				temp = temp.next;
				createNode(temp,0,0 , carry );
			}
			
		}while(temp1!=null || temp2!=null);
		return result;
	}
	
	private static int createNode(ListNode node, int a, int b, int car) {
		node.val = (a+b+car)%10;
		return (a+b+car)/10;
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
