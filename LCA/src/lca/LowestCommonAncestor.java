package lca;

import java.util.ArrayList; 
import java.util.List;

//Directed Acyclic Graph Node
class Node{
    List<Node> successors;
    int value; 
    public Node(int val) {
    	this.value = val;
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
        return findLCADAG(root, n1, n2); 
    } 
  
    private int findLCADAG(Node root, int n1, int n2) { 
  
    	//check to make sure both nodes are on the graph.
        if(!findPath(root, n1, path1)) {
        		System.out.println("no path to n1");
        	return -1;
        }
        if(!findPath(root, n2, path2)) {
        		System.out.println("no path to n2");
        	return -1;
        }
        
        
//        int i;
//        int shortestPath;
//        if (path1.size() > path2.size())
//        	shortestPath = path2.size();
//        else
//        	shortestPath = path1.size();
//        
//        for (i = 0; i < shortestPath; i++) { 
//              
//         //System.out.println(path1.get(i) + " " + path2.get(i)); 
//            if (!path1.get(i).equals(path2.get(i))) 
//                break; 
//        } 
//  
//        return path1.get(i-1); 
        
        int endPath1 = path1.size()-1;
        int endPath2 = path2.size()-1;
        
        while(endPath1 > -1 && endPath2 > -1) {
        	if (path1.get(endPath1).equals(path2.get(endPath2))) {
        		return path1.get(endPath1-1);
        	}
        	endPath1--;
        	endPath2--;
        }
        return -1;
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
        path.add(root.value); 
  
        if (root.value == n) { 
            return true; 
        } 
        
        //Recursively creates a single path from root to a given node.
        for(int i = 0; i<root.successors.size(); i++) {
        	if(root.successors.get(i)!=null && findPath(root.successors.get(i), n, path))
        		return true;
        }
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
    } 
}


