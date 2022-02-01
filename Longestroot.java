package com.Longestroot.main;

import java.util.ArrayList;

class Node{
	
	Node left;
	Node right;
	int data;
}

public class Longestroot {
	
	static Node newNode(int data) {
		
		Node node=new Node();
		node.data=data;
		node.left=node.right = null;
		return node;
						
	}
	
	private static ArrayList<Integer> findLongestPath(Node root) {
		
		if (root == null) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> rightNode = findLongestPath(root.right);
		ArrayList<Integer> leftNode = findLongestPath(root.left);
		
		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.data);
		} else {
			rightNode.add(root.data);
		}
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode );
		
	}

	public static void main(String[] args) {
		
	Node root=newNode(100);
	root.left = newNode(20);
	root.right = newNode(130);
	root.left.left = newNode(10);
	root.left.right = newNode(50);
	root.right.left = newNode(110);
	root.right.right = newNode(140);
	//root.left.left.left = newNode(5);
	
	ArrayList<Integer> outputPath = findLongestPath(root);
	
	System.out.println(outputPath);
	
	for (int i = outputPath.size() -1; i >= 0; i--)  {
		
		System.out.print("->" + outputPath.get(i));
	}
	}
	
	
}
