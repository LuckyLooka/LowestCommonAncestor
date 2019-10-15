package lca;

import java.util.ArrayList; 
import java.util.List;

//Node data structure
class Node{
	int data;
	Node left;
	Node right;
	public Node(int value) {
		this.data = value;
		left = null;
		right = null;
	}
}
//Solution to LCA by recursively creating lists of the paths from root to nodes, and then comparing these lists
//until unique nodes are reached and returning the node previous to those unique nodes as the LCA.
class LcaSolution{
	Node root; 
    private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>(); 
  
    // Finds the path from root node to given root of the tree. 
    int findLCA(int n1, int n2) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Node root, int n1, int n2) { 
  
    	//check to make sure both nodes are on the tree.
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
            return -1; 
        } 
        
        
        int i;         
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
         //System.out.println(path1.get(i) + " " + path2.get(i)); 
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    } 
      
    // Finds the path from root node to given node of the tree, Stores the 
    // path in a vector path[], returns true if path exists otherwise false 
    private boolean findPath(Node root, int n, List<Integer> path) 
    { 
        // base case 
        if (root == null) { 
            return false; 
        } 
          
        // Store this node . The node will be removed if 
        // not in path from root to n. 
        path.add(root.data); 
  
        if (root.data == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
    } 
//	public void displayTree(Node root) {
//		Node current = root;
//		Node temp = current;
//		System.out.print("(" +current.data +")");
//		//Right Wing
//		while(current!=null) {
//			current = current.right;
//			System.out.print(" -- (" +temp.data +")");
//		}
//		current = temp;
//		if (current.left!=null)
//			System.out.println(" |");
//		while(temp != null) {
//			if (temp.right != null) {
//				temp = temp.right;
//				if (temp.left!=null)
//					System.out.print("      \\");
//			}
//						
//		}
//		
//	}
}

public class LowestCommonAncestor {

	public static void main(String[] args) {
		LcaSolution testTree = new LcaSolution();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		testTree.root.right = new Node(3);
		testTree.root.left.left = new Node(4);
		testTree.root.left.right = new Node(5);
		testTree.root.right.left = new Node(6);
		testTree.root.right.right = new Node(7);
		testTree.root.left.left.left = new Node(8);
		testTree.root.left.left.right = new Node(9);
		
		System.out.println("LCA(4, 5): " + testTree.findLCA(4,5)); 
        System.out.println("LCA(4, 6): " + testTree.findLCA(4,6)); 
        System.out.println("LCA(3, 4): " + testTree.findLCA(3,4)); 
        System.out.println("LCA(2, 4): " + testTree.findLCA(2,4));
	}

}
