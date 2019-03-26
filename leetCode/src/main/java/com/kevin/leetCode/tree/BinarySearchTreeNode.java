package com.kevin.leetCode.tree;

public class BinarySearchTreeNode {
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode insert(TreeNode newNode) {
		if(root == null) {
			return root = newNode;
		} else if(newNode.getData() > root.getRightNode().getData()){
			root = root.getRightNode();
			insert(newNode);
		} else {
			root = root.getLeftNode();
			insert(newNode);
		}
		root.get
		
	}
	
}
