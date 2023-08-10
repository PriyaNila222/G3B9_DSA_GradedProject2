package com.gl.driver;

import com.gl.service.Node;

public class Main {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	public static void main(String[] args) {
		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		tree.BSTToSkewed(node, 0);
		tree.traverseRightSkewed(headNode);

	}

	public void BSTToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}

		if (order > 0) {
			BSTToSkewed(root.right, order);
		} else {
			BSTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			BSTToSkewed(leftNode, order);
		} else {
			BSTToSkewed(rightNode, order);
		}
	}

	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

}
