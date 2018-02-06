package com.zc.graph;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * @description 邻接矩阵模型类
 * @author zc 
 */
public class AMWGraph<E> {
	/*
	 * 图的邻接矩阵(Adjacency Matrix)使用两个数组表示图
	 * 一个一维数组(这里用list)存储图中顶点信息
	 * 一个二维数组(邻接矩阵)存储图中的边或弧的信息
	 * 可表示有向图或无向图
	 * 临界矩阵猪对角线(v0,v0),(v1,v1)...均为0,因为从该顶点到该顶点的距离为0
	 * 无向图的邻接矩阵应该是对称的
	 * 有向图:edges[i][j]表示从i到j的距离
	 * 		出度:一个顶点所有出的和(临界矩阵中的一行的和),入度
	 * 
	 * 邻接矩阵与邻接表的比较

		当图中结点数目较小且边较多时，采用邻接矩阵效率更高。
 		当节点数目远大且边的数目远小于相同结点的完全图的边数时，采用邻接表存储结构更有效率。
	 * */
    private ArrayList<E> vertexList;//存储 顶点 的链表
    private int[][] edges;//邻接矩阵，用来存储边(顶点与顶点之间的关系)
    private int numOfEdges;//边的数目

    public AMWGraph(int n) {
        //初始化矩阵，二维数组，和边的数目
        edges=new int[n][n];
        vertexList=new ArrayList<E>(n);
        numOfEdges=0;
    }

    //得到结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i的数据
    public E getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(E vertex) {
    	//结点用一个list存储,add(E e)
        vertexList.add(vertex);
    }

    //插入边
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }

    //删除边
    public void deleteEdge(int v1,int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }

    //得到当前顶点第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }
    
    //私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited,int  i) {//需要给每个顶点标注是否访问过!!
        //首先访问该结点，在控制台打印出来
        System.out.print(getValueByIndex(i)+"  ");
        //置该结点为已访问
        isVisited[i]=true;
        
        int w=getFirstNeighbor(i);//遍历下一个邻接点
        while (w!=-1) {//只要有邻接点,就一直遍历
            if (!isVisited[w]) {//当前节点未被访问过则遍历其及其邻接点
                depthFirstSearch(isVisited,w);
            }
            w=getNextNeighbor(i, w);//深度遍历完当前结点后获取下一个邻接点
        }
    }
    
    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch() {
    	//用来保存每个顶点是否被访问过,默认都是false
    	boolean[] isVisited=new boolean[getNumOfVertex()];
        for(int i=0;i<getNumOfVertex();i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited,i);
            }
        }
    }
    
    //私有函数，广度优先遍历
    private void broadFirstSearch(boolean[] isVisited,int i) {
        int u,w;
        LinkedList<Integer> queue=new LinkedList<Integer>();
        
        //访问结点i
        System.out.print(getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u=((Integer)queue.removeFirst()).intValue();
            w=getFirstNeighbor(u);
            while(w!=-1) {
                if(!isVisited[w]) {
                        //访问该结点
                        System.out.print(getValueByIndex(w)+"  ");
                        //标记已被访问
                        isVisited[w]=true;
                        //入队列
                        queue.addLast(w);
                }
                //寻找下一个邻接结点
                w=getNextNeighbor(u, w);
            }
        }
    }
    
    //对外公开函数，广度优先遍历
    public void broadFirstSearch() {
    	//用来保存每个顶点是否被访问过,默认都是false
    	boolean[] isVisited=new boolean[getNumOfVertex()];
        for(int i=0;i<getNumOfVertex();i++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }
}