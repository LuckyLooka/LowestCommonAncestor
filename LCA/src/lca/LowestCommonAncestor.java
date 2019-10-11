package lca;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int value) {
		this.val = value;
		left = null;
		right = null;
	}
}

class BinaryTree {
	Node root;
	public BinaryTree(int rootVal) {
		root = new Node(rootVal);
	}
	public void displayTree(BinaryTree tree) {
		Node current = tree.root;
		Node temp = current;
		System.out.print("(" +current.val +")");
		//Right Wing
		while(current!=null) {
			current = current.right;
			System.out.print(" -- (" +temp.val +")");
		}
		current = temp;
		if (current.left!=null)
			System.out.println(" |");
		while(temp != null) {
			if (temp.right != null) {
				temp = temp.right;
				if (temp.left!=null)
					System.out.print("      \\");
			}
						
		}
		
	}
}

public class LowestCommonAncestor {

	public static void main(String[] args) {
		BinaryTree testTree = new BinaryTree(1);
		testTree.root.left = new Node(2);
		testTree.root.right = new Node(3);
		testTree.root.left.left = new Node(4);
		testTree.root.left.right = new Node(5);
		testTree.root.right.left = new Node(6);
		testTree.root.right.right = new Node(7);
		testTree.root.left.left.left = new Node(8);
		testTree.root.left.left.right = new Node(9);
	}

}
