package com.gl.dsa.lab2.question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketsImplementation {
	// Setting a boolean variable to check if there are actually brackets in the
	// given string.
	static boolean justLettersorNumbers = false;

	private boolean BalancedOrNot(String brackets) {
		// Implementation of the Balanced Brackets method.

		// Initializing a stack as it has LIFO which is good for this problem.
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < brackets.length(); i++) {
			// Checking each character in the string.
			char s = brackets.charAt(i);
			// If not an opening or closing bracket we are going to skip that character and
			// continue.
			if (s == '(' || s == '{' || s == '[' || s == ']' || s == '}' || s == ')') {
				justLettersorNumbers = false;
				if (s == '(' || s == '{' || s == '[') {
					// If an opening bracket is encountered then we push it into the stack and then
					// move on to the next character.
					stack.push(s);
					continue;
				}
				// At this point if the stack is empty, then return false as not balanced.
				if (stack.isEmpty()) {
					return false;
				}
				char poppedBracket;
				// Check each closing bracket encountered and check if there is a mismatch in
				// the popped bracket from stack.
				switch (s) {
				case '}':
					poppedBracket = stack.pop();
					if (poppedBracket == '[' || poppedBracket == '(') {
						return false;
					}
					break;
				case ']':
					poppedBracket = stack.pop();
					if (poppedBracket == '{' || poppedBracket == '(')
						return false;
					break;
				case ')':
					poppedBracket = stack.pop();
					if (poppedBracket == '{' || poppedBracket == '[')
						return false;
					break;
				}
			} else {
				justLettersorNumbers = true;
				continue;
			}
		}
		// finally if balanced the stack is supposed to be empty else not balanced.
		return (stack.isEmpty());

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the series of brackets to check if they are balanced or not: ");
		String expression = input.next();
		BalancedBracketsImplementation obj = new BalancedBracketsImplementation();
		boolean status = obj.BalancedOrNot(expression);
		if (justLettersorNumbers) {
			System.out.println("Please enter a valid string WITH brackets to evaluate if balanced or not!");
		}
		if (status == true && justLettersorNumbers == false) {
			System.out.println("The entered String has Balanced Brackets!");
		} else if (status == false && justLettersorNumbers == false) {
			System.out.println("The entered Strings do not contain Balanced Brackets!");
		}
		input.close();
	}
}
