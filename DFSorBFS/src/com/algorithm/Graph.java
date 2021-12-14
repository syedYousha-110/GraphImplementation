package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS

public class Graph {

    private LinkedList<Integer> adjacentList[];
    private int numberOfNodes;

    private Graph(int numberOfNodes){
        this.numberOfNodes=numberOfNodes;
        adjacentList = new LinkedList[numberOfNodes];

        for (int i=0; i<numberOfNodes ;i++){
            adjacentList[i] = new LinkedList<Integer>();

            System.out.println(adjacentList[i]);
//            adjacentList[0] = new LinkedList<>(0);
//            adjacentList[1] = new LinkedList<>(1);
//            adjacentList[2] = new LinkedList<>(2);
//            adjacentList[3] = new LinkedList<>(3);
//            adjacentList[4] = new LinkedList<>(4);
//            adjacentList[5] = new LinkedList<>(5);
//            adjacentList[6] = new LinkedList<>(6);

        }
    }
    private void addEdges(int source, int destination){
        adjacentList[source].add(destination);
        adjacentList[destination].add(source);

    }
    private int bfs(int source, int destination){
        boolean visited[] = new boolean[adjacentList.length];

        int parent[] = new int[adjacentList.length];

        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        parent[source] = -1;
        visited[source] = true;
        while (!q.isEmpty()){
            int current = q.poll();
            if (current==destination)break;
            for (int neighbor : adjacentList[current]){
                if (!visited[neighbor]){
                    q.add(neighbor);
                    parent[neighbor]= current;
                    visited[neighbor]=true;
                }
            }
        }
        int cur = destination;
        int distance = 0;
        while (parent[cur] !=-1){
            System.out.println(parent[cur] +"->"+cur);
            cur =parent[cur];
            distance++;
        }
        return distance;
    }
    private static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
//        int v = sc.nextInt();
//        int e = sc.nextInt();

        Graph graph = new Graph(7);
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(0,6);
        graph.addEdges(1,3);
        graph.addEdges(1,4);
        graph.addEdges(2,4);
        graph.addEdges(2,5);
        graph.addEdges(3,6);
        graph.addEdges(4,6);
//        System.out.println("Enter Edges : "+e);
//        for (int i = 0; i<e; i++){
//            int source = sc.nextInt();
//            int destination = sc.nextInt();
//            graph.addEdges(source,destination);
//        }
//        System.out.println("Enter source and destination");
//        int source = sc.nextInt();
//        int destination = sc.nextInt();
        graph.bfs(6,5);

    }
}
