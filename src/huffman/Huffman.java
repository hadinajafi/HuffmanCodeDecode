package huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
public class Huffman {
	ArrayList<Node> nodeList;
	char[] dataChar;
	Map<Character, String> m = new HashMap<>();
	Node root = new Node();
	public Huffman(String data) {
		freq(data);
		sortNodeList();
		buildHuffmanTree();
		//gethuffmanCode();
	}
	
	public void buildHuffmanTree() {
		Node node1, node2;
		while(nodeList.size() != 1) {
			node1 = nodeList.get(0);
			node2 = nodeList.get(1);
			Node newNode = new Node();
			newNode.setFreq(node1.getFreq() + node2.getFreq());
			newNode.data = '*';
			newNode.leftChild = node1;
			node1.position = "0";
			newNode.rightChild = node2;
			node2.position = "1";
			nodeList.remove(0);
			nodeList.remove(0);
			nodeList.add(0, newNode);
			sortNodeList();
			root = newNode;
			//System.out.println(newNode.leftChild.data + " " + newNode.rightChild.data);
			
		}
		//System.out.println(root.rightChild.rightChild.position + " " + root.rightChild.rightChild.data);
	}
	
	public String gethuffmanCode() {
		Stack<Node> s = new Stack<>();
		String chars = "";
		s.push(root);
		String p = "";
		Node temp;
		while(!s.isEmpty()) {
			temp = s.pop();
			if(temp.rightChild.data == '*') {
				s.push(temp.rightChild);
				p = temp.position;
			}
			else {
				temp.rightChild.position = p + temp.position + temp.rightChild.position;
				System.out.println(temp.rightChild.data + ":" + temp.rightChild.position);
				chars += temp.rightChild.data + ":" + temp.rightChild.position + "\n";
				m.put(temp.rightChild.data, temp.rightChild.position);
			}
			if(temp.leftChild.data == '*') {
				s.push(temp.leftChild);
				p = temp.position;
			}
			else {
				temp.leftChild.position = p + temp.position + temp.leftChild.position;
				System.out.println(temp.leftChild.data + ":" + temp.leftChild.position);
				chars += temp.leftChild.data + ":" + temp.leftChild.position + "\n";
				m.put(temp.leftChild.data, temp.leftChild.position);
			}
		}
		return chars;
	}
	
	private void freq(String data) {
		this.dataChar = data.toCharArray();
		nodeList = new ArrayList<>();
		for(int i = 0; i < dataChar.length; i++) {
			if(nodeList.isEmpty())
				nodeList.add(new Node(dataChar[i]));
			else {
				findFreq(dataChar[i]);
			}
		}
	}
	
	private void findFreq(char ch) {
		for(int i = 0; i < nodeList.size(); i++) {
			if(nodeList.get(i).data == ch) {
				nodeList.get(i).increaseFreq();
				return;
			}
		}
		nodeList.add(new Node(ch));
	}
	
	private void sortNodeList() {
		Collections.sort(nodeList);
		//System.out.println(nodeList.get(2).data);
	}
	public void printFreq() {
		for(Node x : nodeList) {
			System.out.println(x.data + " " + x.getFreq());
		}
	}
	public String printHuffmanCompressedText() {
		String code = "";
		for(char x:dataChar) {
			code += m.get(x);
		}
		return code;
	}
}
