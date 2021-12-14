package com.algorithm;


import java.util.*;

public class TopShortestPath {
    private Stack<Node> stack;
    public static class Node{
        private String name;
        private boolean visited;
        private int distance= Integer.MAX_VALUE;
        private List<Node> neighbours;

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public Node(String name){
            setDistance(distance);
            setName(name);
            setNeighbours(new ArrayList<>());
        }
        public void addNeighbours(Node node,int distance){
            setDistance(distance);
            neighbours.add(node);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
        public String toString() {
            return this.name;
        }

    }

    public TopShortestPath(){
        this.stack = new Stack<>();
        List<Node> nodes = new ArrayList<>();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");

        A.addNeighbours(B,3);

    }

}
