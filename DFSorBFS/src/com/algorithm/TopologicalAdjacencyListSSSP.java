package com.algorithm;

import java.util.*;

public class TopologicalAdjacencyListSSSP {

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;

        }
    }
    // Helper method that performs a depth first search on the graph to give
    // us the topological ordering we want. Instead of maintaining a stack
    // of the nodes we see we simply place them inside the ordering array
    // in reverse order for simplicity.
    private static int dfs(
            int i, int at, boolean[] visited, int[] ordering, Map<Integer, List<Edge>> graph) {
visited[at] = true;
List<Edge> edges = graph.get(at);
        if (edges!=null)
            for (Edge edge : edges)
                if (!visited[edge.to])
                    i=dfs(i,edge.to,visited,ordering,graph);

ordering[i]=at;
return i-1;
    }
    // Finds a topological ordering of the nodes in a Directed Acyclic Graph (DAG)
    // The input to this function is an adjacency list for a graph and the number
    // of nodes in the graph.
    //
    // NOTE: 'numNodes' is not necessarily the number of nodes currently present
    // in the adjacency list since you can have singleton nodes with no edges which
    // wouldn't be present in the adjacency list but are still part of the graph!
    //
    public static int[] topologicalSort(Map<Integer,List<Edge>> graph,int numNodes){
        int[] ordering = new int[numNodes];
        boolean [] visited = new boolean[numNodes];

        int i = numNodes-1;
        for (int at=0;at<numNodes;at++){
            if (!visited[at])
                i=dfs(i,at,visited,ordering,graph);
        }
        return ordering;
    }
    public static Integer[] dagShortestPath(Map<Integer,List<Edge>> graph,int start,int numNodes) {
        int[] topSort = topologicalSort(graph, numNodes);
        Integer[] dist = new Integer[numNodes];
        dist[start] = 0;
        for (int i = 0; i < numNodes; i++) {
            int nodeIndex = topSort[i];
            if (dist[nodeIndex] != null) {
                List<Edge> adjacentEdges = graph.get(nodeIndex);
                if (adjacentEdges != null) {
                    for (Edge edges : adjacentEdges){
                    int newDist = dist[nodeIndex]+ edges.weight;
                    if (dist[edges.to] == null) dist[edges.to] = newDist;
                    else dist[edges.to] = Math.min(dist[edges.to],newDist);
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        final int N = 8;
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for (int i=0;i<8;i++) graph.put(i,new ArrayList<>());
        graph.get(0).add(new Edge(0,1,3));
        graph.get(0).add(new Edge(0,2,6));
        graph.get(1).add(new Edge(1,2,4));
        graph.get(1).add(new Edge(1,3,4));
        graph.get(1).add(new Edge(1,4,11));
        graph.get(2).add(new Edge(2,3,8));
        graph.get(2).add(new Edge(2,6,11));
        graph.get(3).add(new Edge(3,4,-4));
        graph.get(3).add(new Edge(3,5,5));
        graph.get(3).add(new Edge(3,6,2));
        graph.get(4).add(new Edge(4,7,9));
        graph.get(5).add(new Edge(5,7,1));
        graph.get(6).add(new Edge(6,7,2));
        //for LongestPath Algorithm we negates the weight
//        graph.get(0).add(new Edge(0,1,-3));
//        graph.get(0).add(new Edge(0,2,-6));
//        graph.get(1).add(new Edge(1,2,-4));
//        graph.get(1).add(new Edge(1,3,-4));
//        graph.get(1).add(new Edge(1,4,-11));
//        graph.get(2).add(new Edge(2,3,-8));
//        graph.get(2).add(new Edge(2,6,-11));
//        graph.get(3).add(new Edge(3,4,4));
//        graph.get(3).add(new Edge(3,5,-5));
//        graph.get(3).add(new Edge(3,6,-2));
//        graph.get(4).add(new Edge(4,7,-9));
//        graph.get(5).add(new Edge(5,7,-1));
//        graph.get(6).add(new Edge(6,7,-2));

        int[] ordering= topologicalSort(graph,N);
        System.out.println(Arrays.toString(ordering));

        // Finds all the shortest paths starting at node 0
        Integer[] dists = dagShortestPath(graph,0,N);
        // Find the shortest path from 0 to 7 which is 11.0
        System.out.print("[");
        for (int i=0 ;i<N;i++){
            if (i==N-1){
                System.out.print((1)*dists[i]);
                break;
            }
            System.out.print((1)*dists[i]+", ");

        }
        System.out.print("]");
    }
}












