package huffman;

import java.util.Stack;

public class Tree {
private Node root;
	
	public Tree(char data) {
		root = new Node();
		root.data = data;
	}
	public Tree() {
		root = new Node();
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return this.root;
	}
	public Object getRootData() {
		return this.root.data;
	}
	public int NumberNodes() {
		int c = 0;
		Node temp = new Node();
		Stack<Node> stack = new Stack<>();
		if(this.root == null)
			return 0;
		stack.push(root);
		while(!stack.isEmpty()) {
			temp = stack.pop();
			c++;
			if(temp.rightChild != null) {
				stack.push(temp.rightChild);
			}
			if(temp.leftChild != null) {
				stack.push(temp.leftChild);
			}
		}
		return c;
	}
	public boolean isLeaf(Node node) {
		if(node == null)
			return false;
		if(node.leftChild == null && node.rightChild == null) {
			return true;
		}
		return false;
	}
	public int NumberLeaf(Node root) {
		int leaf = 0;
		if(root == null)
			return 0;
		if(root.leftChild != null) {
			leaf += NumberLeaf(root.leftChild);
		}
		if(root.rightChild != null) {
			leaf += NumberLeaf(root.rightChild);
		}
		if(root.leftChild == null && root.rightChild == null)
			leaf++;
		return leaf;
	}
	public int NumberLeftChilds(Node root) {
		if (root == null) {
			return 0;
		}
		int l =0, r = 0;
		if(root.leftChild != null) {
			l = 1 + NumberLeftChilds(root.leftChild);
		}
		if(root.rightChild != null) {
			r = NumberLeftChilds(root.rightChild);
		}
		return l + r;
	}
}

class Node implements Comparable{
	Node rightChild = null;
	Node leftChild = null;
	String position = "";
	char data;
	private int freq = 1;
	public Node() {}
	public Node(char data) {
		this.data = data;
	}
	
	public boolean isLeaf(Node node) {
		if(node.leftChild == null && node.rightChild == null) {
			return true;
		}
		return false;
	}
	
	public void increaseFreq() {
		freq++;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getFreq() {
		return freq;
	}
	@Override
	public int compareTo(Object compareNode) {
		int compareFreq = ((Node)compareNode).getFreq();
		return this.freq - compareFreq;
	}
}

