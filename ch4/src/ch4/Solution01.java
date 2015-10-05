package ch4;

import java.util.LinkedList;
import java.util.Stack;

import javax.xml.soap.Node;

public class Solution01 {
	enum State{Unvisited,Visiting,Visited;}
	/*
	 * This problem can be addressed by simply traversing the graph.
	 * Both depth-first and depth-first search are the common method,
	 * and a breadth-first search is implemented in the below solution.
	 */
	class Node{
		public int data;
		public State state;
		public Node[] children;
		
		public Node[] getAdjacent(){
			return children;
		}
	}
	class Graph{
		public Node[] nodes;
		
		public Node[] getNodes(){
			return nodes;
		}
		
		
	}
	
	boolean searchRoute(Graph g, Node start,Node end){
		if(start==end) return true;
		
		Stack<Node> q=new Stack<Node>();
		
		for(Node n:g.getNodes()){
			n.state=State.Unvisited;
		}
		
		start.state=State.Unvisited;
		q.push(start);
		Node u;
		while(!q.isEmpty()){
			u=q.pop();
			if(u!=null){
				for(Node v:u.getAdjacent()){
					if(v.state==State.Unvisited){
						if(v==end){
							return true;
						}else{
							v.state=State.Visiting;
							q.push(v);
						}
					}
				}
				u.state=State.Visited;
			}
		}
		return false;
	}
}
