package lca;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	
	@Test
	void testLcaStandardCase() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		testTree.root.right = new Node(3);
		testTree.root.left.left = new Node(4);
		testTree.root.left.right = new Node(5);
		testTree.root.right.left = new Node(6);
		testTree.root.right.right = new Node(7);
		testTree.root.left.left.left = new Node(8);
		testTree.root.left.left.right = new Node(9);
		
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
