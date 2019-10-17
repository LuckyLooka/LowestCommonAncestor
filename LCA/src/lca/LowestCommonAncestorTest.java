package lca;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	
	@Test
	void testLcaDAGStandardCase() {
		LowestCommonAncestor testDAG = new LowestCommonAncestor();
		//Creation of DAG nodes
		testDAG.root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		//Creation of DAG successor Lists
		List<Node> list1 = new ArrayList<>();
		List<Node> list2 = new ArrayList<>();
		List<Node> list3 = new ArrayList<>();
		List<Node> list4 = new ArrayList<>();
		List<Node> list5 = new ArrayList<>();
		List<Node> list6 = new ArrayList<>();
		List<Node> list7 = new ArrayList<>();
		
		//Assigning to each Node in the DAG their respective successor list.
		list1.add(node2); list1.add(node3);
		testDAG.root.successors = list1;
		list2.add(node4);
		node2.successors = list2;
		list3.add(node5);list3.add(node6);
		node3.successors = list3;
		list4.add(node7);
		node4.successors = list4;
		list5.add(node6);list5.add(node7);
		node5.successors = list5;
		list6.add(node8);
		node6.successors = list6;
		list7.add(node8);
		node7.successors = list7;
		
		assertEquals("LCA is incorrect, should be 4 but instead returned" +testTree.findLCA(8,9), 4, testTree.findLCA(8,9));
		
		assertEquals("LCA is incorrect, should be 1 but instead returned" +testTree.findLCA(7,9), 1, testTree.findLCA(7,9));
		
		assertEquals("LCA is incorrect, should be 3 but instead returned" +testTree.findLCA(6,7),3, testTree.findLCA(6,7));
		
		assertEquals("LCA is incorrect, should be 2 but instead returned" +testTree.findLCA(9,5), 2, testTree.findLCA(9,5));
		
		
	}
	
	@Test
	void nullRootLca() {
		//Root is null by default constructor
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertEquals("LCA returned incorrect value, should be -1 for null root", -1, testTree.findLCA(2, 3));		
	}
	
	@Test
	void missingNodeTest() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		testTree.root.right = new Node(3);
		testTree.root.left.left = new Node(4);
		
		//Testing if n1 is missing
		assertEquals(-1, testTree.findLCA(4, 5));
		//Testing if n2 is missing
		assertEquals(-1, testTree.findLCA(6, 1));
		//Testing if both n1 and n2 are missing
		assertEquals(-1, testTree.findLCA(6, 9));
	}
	
	

}
