package com.zc.tree;

public class Node {
	private char data;
	private Node lchild;
	private Node rchild;
	public Node(char data){
		this.data=data;
	}
	public Node(Node lchild,char data,Node rchild){
		this.lchild=lchild;
		this.data=data;
		this.rchild=rchild;
	}
	
	/**
	 * @param parent 父节点
	 * @param c 生成结点的数据域
	 * @return 生成的左孩子结点
	 */
	public Node appendLeftChild(char c) {
		//生成新结点,即左孩子,不指定它的左孩子和右孩子,只指定数据域
		Node newNode=new Node(c);
		this.setLchild(newNode);
		return newNode;
	}
	
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public Node getLchild() {
		return lchild;
	}
	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}
	public Node getRchild() {
		return rchild;
	}
	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}
	@Override
	public String toString() {
		return String.valueOf(data);
	}
	/**
	 * @param root 父节点
	 * @param c 数据域
	 * @return 返回生成的结点
	 */
	public Node appendRightChild(char c) {
		Node newNode=new Node(c);
		this.setRchild(newNode);
		return newNode;
	}
	/**
	 * @param c
	 * @param d
	 * @return 返回生成的结点数组[左孩子,右孩子]
	 */
	public Node[] appendBothChild(char c, char d) {
		Node leftNode=new Node(c);
		Node rightNode=new Node(d);
		this.setLchild(leftNode);//this即为parent
		this.setRchild(rightNode);
		return new Node[]{leftNode,rightNode};
	}
}
