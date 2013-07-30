package com.qsoft.longdt;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SingleLinkedListTest extends TestCase {

	private ArrayList<Node> strArray;

	private String newStr;

	private Node nodeAnchor;

	private Node nodeToDelete;

	private Node nodeFirst;

	private Node nodeLast;

	private Node nodeBeforeNodeAnchor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		strArray = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Node node = new Node();
			node.setNode("String " + i);
			int nextIndex = i < 4 ? i + 1 : -1;
			int prevIndex = i > 0 ? i - 1 : -1;
			node.setNextNodeIndex(nextIndex);
			node.setPrevNodeIndex(prevIndex);
			strArray.add(node);
		}
		nodeAnchor = new Node();
		nodeAnchor.setNode("String 2");
		nodeAnchor.setNextNodeIndex(3);
		nodeAnchor.setPrevNodeIndex(1);

		nodeToDelete = new Node();
		nodeToDelete.setNode("String 3");
		nodeToDelete.setNextNodeIndex(4);
		nodeToDelete.setPrevNodeIndex(2);

		nodeFirst = new Node();
		nodeFirst.setNode("String 0");
		nodeFirst.setNextNodeIndex(1);
		nodeFirst.setPrevNodeIndex(-1);

		nodeLast = new Node();
		nodeLast.setNode("String 4");
		nodeLast.setNextNodeIndex(-1);
		nodeLast.setPrevNodeIndex(3);

		nodeBeforeNodeAnchor = new Node();
		nodeBeforeNodeAnchor.setNode("String 1");
		nodeBeforeNodeAnchor.setNextNodeIndex(0);
		nodeBeforeNodeAnchor.setPrevNodeIndex(2);

		newStr = "New Strings With Random Position Per Test";
	}

	// Step 1
	public void testCreateNewLinkListWithEmptyList() {
		SingleLinkedList linkedList = new SingleLinkedList();
		assertEquals(0, linkedList.size());
	}

	// Step 2
	public void testCreateNewLinkListWithObjectList() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		assertEquals(strArray, list.getList());
	}

	// Step 3
	public void testGetSizeOfLinkList() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		assertEquals(strArray.size(), list.size());
	}

	// Step 4
	public void testInsertAfterIndexN() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		list.insertAfter(nodeAnchor, newStr);

		assertEquals(strArray.size() + 1, list.size());
		assertEquals(newStr, list.get(3).getNode());
	}

	// Step 5
	public void testDeleteANode() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		list.delete(nodeToDelete);

		assertEquals(strArray.size() - 1, list.size());
	}

	// Step 6
	public void testGetTheFirstNode() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		Node firstNode = list.first();

		assertEquals(nodeFirst.getNextNodeIndex(), firstNode.getNextNodeIndex());
		assertEquals(nodeFirst.getNode(), firstNode.getNode());
		assertEquals(nodeFirst.getPrevNodeIndex(), firstNode.getPrevNodeIndex());
	}

	// Step 7
	public void testGetTheLastNode() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		Node lastNode = list.last();

		assertEquals(nodeLast.getNextNodeIndex(), lastNode.getNextNodeIndex());
		assertEquals(nodeLast.getNode(), lastNode.getNode());
		assertEquals(nodeLast.getPrevNodeIndex(), lastNode.getPrevNodeIndex());
	}

	// Step 8
	public void testGetTheNodeBeforeAnother() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		Node targetNode = list.before(nodeAnchor);

		assertEquals(nodeBeforeNodeAnchor.getNextNodeIndex(),
				targetNode.getNextNodeIndex());
		assertEquals(nodeBeforeNodeAnchor.getNode(), targetNode.getNode());
		assertEquals(nodeBeforeNodeAnchor.getPrevNodeIndex(),
				targetNode.getPrevNodeIndex());
	}
}
