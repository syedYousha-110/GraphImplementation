package com.algorithm;

import java.util.*;

public class BFS {

    private Queue<Node> openlist;
    private List<Node> list;

    public void discoverableWeb(String root) {

    }

    private class Node {
        String name;
        boolean visited;
        List<Node> neighbours;
        public void setName(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
        public void addNeighbours(Node node){
            this.neighbours.add(node);
        }
        public List<Node> getNeighbours(){
            return this.neighbours;
        }

        Node(String name){
        this.setName(name);
        this.neighbours=new ArrayList<>();
        }
        @Override
        public String toString() {
            return this.name;
        }

        public List<Node> getNeighboursList() {
            return neighbours;
        }
    }
    public void bfa(List<Node> node){
        for (Node n: node){
            if(!n.isVisited()){
                if (n!=null){
                    n.setVisited(true);
                    BFSwithQueue(n);
                }
            }
        }
        System.out.println("]");
    }

    public void BFSwithQueue(Node node){
        this.openlist.add(node);
        for (Node neighbour : node.getNeighbours()){
            if (!neighbour.isVisited())
            if (neighbour!=null)
                neighbour.setVisited(true);
                this.openlist.add(neighbour);
        }
        while (!openlist.isEmpty()) {
            Node elem = openlist.remove();
            System.out.print(elem+" ");
           elem.setVisited(true);
            for (Node neighbour: elem.getNeighbours()){
                if (neighbour!=null){
                    if (!neighbour.isVisited()){
                       neighbour.setVisited(true);
                        this.openlist.add(neighbour);
                    }
                }
            }
        }
    } // E B D S A G
    public BFS(){
        this.openlist=new LinkedList<>();
        Node S = new Node("S");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node G = new Node("G");

//        Scanner sc = new Scanner(System.in);
//        var x = sc.next();
//        var Z = new Vertex("z");
//        S.setReference(Z);

        list = new ArrayList<>();
        list.add(E);
        list.add(S);
        list.add(A);
        list.add(B); //list = [S,A,B,C,D,E,G]
        list.add(C);
        list.add(D);
        list.add(G);

        S.addNeighbours(A);
        S.addNeighbours(B);
        S.addNeighbours(G);

        A.addNeighbours(C);
        A.addNeighbours(D);
        A.addNeighbours(S);

        B.addNeighbours(D);
        B.addNeighbours(E);
        B.addNeighbours(S);

        C.addNeighbours(A);
        C.addNeighbours(G);

        D.addNeighbours(A);
        D.addNeighbours(B);
        D.addNeighbours(G);

        E.addNeighbours(B);

        G.addNeighbours(C);
        G.addNeighbours(D);
        G.addNeighbours(S);

        System.out.print("S ->");
        System.out.println(S.getNeighboursList());
        System.out.print("A ->");
        System.out.println(A.getNeighboursList());
        System.out.print("B ->");
        System.out.println(B.getNeighboursList());
        System.out.print("C ->");
        System.out.println(C.getNeighboursList());
        System.out.print("D ->");
        System.out.println(D.getNeighboursList());
        System.out.print("E ->");
        System.out.println(E.getNeighboursList());
        System.out.print("G ->");
        System.out.println(G.getNeighboursList());
        System.out.print("Open List : [ ");


//        list.add(S);
//        list.add(A);
//        list.add(B);
//        list.add(C);
//        list.add(D);
//        list.add(E);
//        list.add(G);
            bfa(list);

    }

    public static void main(String[] args) {
        new BFS();

    }

}
