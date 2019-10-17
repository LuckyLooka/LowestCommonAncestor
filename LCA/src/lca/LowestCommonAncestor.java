package lca;

import java.util.ArrayList; 
import java.util.List;

class DAG {
	   Node root; // assuming only one root exists

	   class Node{
	      List<Node> successors;
	      List<Node> parents;
	      int value; 
	   }
	}
//Solution to LCA by recursively creating lists of the paths from root to nodes, and then comparing these lists
//until unique nodes are reached and returning the node previous to those unique nodes as the LCA.
class LowestCommonAncestor{
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
        if(!findPath(root, n1, path1)) {
        		System.out.println("no path to n1");
        	return -1;
        }
        if(!findPath(root, n2, path2)) {
        		System.out.println("no path to n2");
        	return -1;
        }
        
        
        int i;
        int shortestPath;
        if (path1.size() > path2.size())
        	shortestPath = path2.size();
        else
        	shortestPath = path1.size();
        
        for (i = 0; i < shortestPath; i++) { 
              
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
    
    //Attempt to display binary tree in console, gave up as it is unnecessary waste of time.
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


