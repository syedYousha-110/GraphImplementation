package com.algorithm;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    static int newDist=0;

    static class AdjListNode{
        String name;
        int node,weight;

        public AdjListNode(int node, int weight) {
            setName(name);
            setNode(node);
            setWeight(weight);
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getNode() {
            return node;
        }
        public void setNode(int node) {
            this.node = node;
        }
        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    public static int[] dijkstra(int Nodes, ArrayList<ArrayList<AdjListNode>> graph, int source){
        boolean visited[]=new boolean[Nodes];
        int previous[]=new int[Nodes];
        int distance[] =new int[Nodes];

        for (int i =0;i<Nodes;i++){
        visited[i]=false;
        distance[i]=Integer.MAX_VALUE;
        previous[i]=-1;
    }
        distance[0]=0;
        PriorityQueue<AdjListNode> pq = new PriorityQueue<>((v1,v2) -> v1.getWeight()- v2.getWeight());
        pq.add(new AdjListNode(source,0));
        while (!pq.isEmpty()){
            AdjListNode current = pq.poll();
            visited[current.getNode()]=true;
            if (distance[current.getNode()]<current.getWeight()) continue;
            for (AdjListNode node : graph.get(current.getNode())){
                if (visited[node.getNode()]) continue;
                newDist=distance[node.getNode()]+node.getWeight();
                if (newDist<distance[node.getWeight()]){
                    previous[node.getNode()]=current.getNode();
                    distance[node.getNode()]=newDist;
                    pq.add(new AdjListNode(node.getNode(),newDist));
                }
            }
        }
return distance;
    }

    public static void main(String[] args) {

    }

}
