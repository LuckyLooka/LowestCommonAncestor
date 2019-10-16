package lca;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

	//	@Test
//	void test() {
//		
//	}
	
	@Test
	void testLcaStandardCase() {
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
		
		assertEquals("LCA is incorrect, should be 4 but instead returned" +testTree.findLCA(8,9), 4, testTree.findLCA(8,9));
		
		assertEquals("LCA is incorrect, should be 1 but instead returned" +testTree.findLCA(7,9), 1, testTree.findLCA(7,9));
		
		assertEquals("LCA is incorrect, should be 3 but instead returned" +testTree.findLCA(6,7),3, testTree.findLCA(6,7));
		
		assertEquals("LCA is incorrect, should be 2 but instead returned" +testTree.findLCA(9,5), 2, testTree.findLCA(9,5));
		
		
	}
	
	@Test
	void nullTreeLca() {
		
		
	}
	@Test
	void missingNodeTest() {
		
	}
	
	@Test
	void BinaryTreeCreation() {
	
	}

}
