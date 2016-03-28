package br.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstSearch {
	
	
	public static class Edge implements Comparable<Edge> {
		int s, d, w;
		Edge (int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge that) {
			return this.w - that.w;
		}
	}
	public static ArrayList<ArrayList<Edge>> list;
	public static boolean [] visiteds;
	public static int vertices;
	
	public BestFirstSearch(int vertx) {
		vertices = vertx;
		visiteds = new boolean[vertx];
		list = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<vertx; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	
	public static void add(Edge edge) {
		list.get(edge.s).add(edge);
	}
	
	
	public static void dfs(Edge edge) {
		// visiteds[edge.s] = true;
		// Collections.sort(list.get(edge.s));
		for(Edge e : list.get(edge.s)) {
			if( ! visiteds[e.d] ) {
				visiteds[e.d] = true;
				System.out.printf(" %d", e.d);
				dfs(e);
			}
		}
	}
	
	public static void bfs(Edge edge, Edge goal) {
		visiteds[edge.s] = true;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.add(edge);
		while( ! queue.isEmpty() ) {
			Edge x = queue.poll();
			if(isFind(edge, goal))
				break;
			for(Edge e : list.get(x.s)) {
				if(!visiteds[e.d]) {
					System.out.printf(" %d", e.d);
					visiteds[e.d] = true;
					queue.add(e);
				}
			}
		}
	}
	
	
	public static void execute(int vertice) {
		new BestFirstSearch(vertice);
		Edge edge = new Edge(0, 1, 2);
		add(edge);
		add(new Edge(0, 4, 5));
		add(new Edge(0, 5, 1));
		add(new Edge(1, 0, 1));
		add(new Edge(1, 2, 3));
		add(new Edge(2, 1, 2));
		add(new Edge(2, 3, 8));
		add(new Edge(3, 2, 3));
		add(new Edge(3, 4, 5));
		add(new Edge(4, 1, 1));
		add(new Edge(4, 3, 8));
		add(new Edge(4, 5, 1));
		add(new Edge(5, 1, 1));
		add(new Edge(5, 4, 5));
		System.out.printf("%d: ", edge.s);
		//visiteds[edge.s] = true;
		//dfs(edge);
		bfs(edge, new Edge(5,4,10));
	}
	
	public static boolean isFind(Edge search, Edge goal) {
		return search.d == goal.d;
	}
	
	public static void main(String[] args) {
		execute(6);
	}
}
