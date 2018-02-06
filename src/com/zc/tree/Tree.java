package com.zc.tree;

public class Tree {
	private Node root;
	public Node getRoot(){
		return root;
	}
	public static void main(String[] args) {
		Tree tree=new Tree();
		Node rootNode=tree.generateRoot('a');
		Node left=rootNode.appendLeftChild('b');//一个父节点生成左孩子需要传自身,和左孩子里的数据
		Node right=rootNode.appendRightChild('c');//生成右节点
		left.appendBothChild('d','e');//同时生成左节点和右节点
		right.appendBothChild('f','g');
		tree.preOrder(rootNode);
		tree.inOrder(rootNode);
		tree.postOrder(rootNode);
		System.out.println(tree.size(rootNode));
		System.out.println(tree.height(rootNode));
		tree.clear(rootNode);
		tree.preOrder(rootNode);
	}
	/**
	 * 生成根节点
	 * @param elem
	 * @return 根结点
	 */
	private Node generateRoot(char elem) {
		root=new Node(null,elem,null);
		return root;
	}
	//空树,啥也没有,也没有根
	public Tree(){
		
	}
	//先序遍历	根,左,右
	public void preOrder(Node subTree){
		if(subTree!=null){
			visitCurrent(subTree);
			preOrder(subTree.getLchild());
			preOrder(subTree.getRchild());
		}
	}
	
	//中序遍历	左,根,右
	public void inOrder(Node subTree){
		if(subTree!=null){
			inOrder(subTree.getLchild());
			visitCurrent(subTree);
			inOrder(subTree.getRchild());
		}
	}
	
	//后序遍历	左,右,根
	public void postOrder(Node subTree){
		if(subTree!=null){
			postOrder(subTree.getLchild());
			postOrder(subTree.getRchild());
			visitCurrent(subTree);
		}
	}
	
	//输出当前结点的内容(根)
	private void visitCurrent(Node subTree) {
		System.out.println(subTree);
	}
	
	/**
	 * 统计结点数量
	 * @param subTree
	 * @return
	 */
	 private int size(Node subTree){  
	        if(subTree==null){  
	            return 0;  
	        }else{  
	            return 1+size(subTree.getLchild())  
	                    +size(subTree.getRchild());  
	        }  
	    }  
	
	 /**
	  * 递归返回二叉树高度
	 * @param subTree
	 * @return
	 */
	public int height(Node subTree){  
        if(subTree==null)  
            return 0;
        else{  
            int i=height(subTree.getLchild());  
            int j=height(subTree.getRchild());  
            return (i<j)?(j+1):(i+1);  
        }  
    }  
	 
	/**
	 * 清空二叉树
	 * @param subTree
	 */
	public void clear(Node subTree){
		if(subTree==null){
			return;
		}else{
			clear(subTree.getLchild());
			clear(subTree.getRchild());
			subTree=null;
		}
	}
}
