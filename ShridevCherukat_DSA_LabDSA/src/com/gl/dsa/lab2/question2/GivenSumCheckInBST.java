package com.gl.dsa.lab2.question2;

import java.util.HashSet;
import java.util.Scanner;

public class GivenSumCheckInBST {
	// Creating a class Node to traverse through the BST.
	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	}

	// Method for creating a new node when a value is given to add to BST by user.
	static Node NewNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	// Method to insert the values that user inputs as elements of the BST.
	static Node insert(Node root, int key) {
		Node newNode = NewNode(key);
		Node x = root;
		Node currentParent = null;
		while (x != null) {
			currentParent = x;
			if (key < x.nodeData) {
				x = x.leftNode;
			} else if (key > x.nodeData) {
				x = x.rightNode;
			} else {
				System.out.println("Value already exists!!");
				return newNode;

			}
		}
		if (currentParent == null) {
			currentParent = newNode;
		} else if (key < currentParent.nodeData) {
			currentParent.leftNode = newNode;
		} else {
			currentParent.rightNode = newNode;
		}
		return currentParent;

	}

	// Checking if pairs exist for the given sum.
	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		// Base condition.
		if (root == null) {
			return false;
		}
		// Checking for the pairs in the left subtree.
		if (findpairUtil(root.leftNode, sum, set)) {
			return true;
		}
		// Checking if the (sum - root.nodeData) is present in the set, if yes then pair
		// found.
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found (" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else {
			// Else checking right subtree for pairs.
			set.add(root.nodeData);
			return findpairUtil(root.rightNode, sum, set);
		}
	}

	// If findpairUtil method gives true then pairs exist else no.
	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<>();
		if (!findpairUtil(root, sum, set)) {
			System.out.println("Pairs do not exist!!");
		}
	}

	// Driver code
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Node root = null;
		Node result = null;

		GivenSumCheckInBST obj = new GivenSumCheckInBST();
		System.out.println("Enter the Number of Elements to insert: ");
		int size = input.nextInt();
		for (int i = 0; i < size; i++) {
			System.out.println("Enter element " + (i + 1) + " : ");
			int value = input.nextInt();
			if (root == null) {
				root = insert(root, value);
			} else {
				result = insert(root, value);
				if (result.nodeData == value)

					i -= 1;
			}
		}
		boolean OnceMore = true;
		String exit = "a";
		while (OnceMore) {
			System.out.println("--------------------------");
			System.out.println("Enter the sum to check with the elements in BST: ");
			int sum = input.nextInt();
			obj.findPairWithGivenSum(root, sum);
			System.out.println("--------------------------");

			System.out.println("Press s to exit, else any key to continue!");
			exit = input.next();
			if (exit.equals("s")) {
				OnceMore = false;
			}
		}
		System.out.println("Program completed successfully!");
		input.close();
	}
}
