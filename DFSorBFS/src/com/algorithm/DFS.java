package com.algorithm;

import java.util.*;
import java.util.stream.IntStream;

public class DFS {
    private Stack<Vertex> stack;
    private List<Vertex> list;

    public class Vertex{
        private String name;
        private boolean visited;
        private List<Vertex> neighbourList;
        private Vertex node;
        public void setReference(Vertex node){
            this.node=node;
        }
        public Vertex getNode(){
            return node;
        }
        public void addNeighbour(Vertex vertex){
            this.neighbourList.add(vertex);
        }
        public String getName() {
            return name;
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

        public List<Vertex> getNeighbourList() {
            return neighbourList;
        }

        public void setNeighbourList(List<Vertex> neighbourList) {
            this.neighbourList = neighbourList;
        }

        public Vertex(String name){
            this.name=name;
            this.neighbourList=new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
    //DFA(List list=[S,A,B,C,D,E,G])
    public void dfa(List<Vertex> vertexList){
        for (Vertex v: vertexList){     // v = S
            if (!v.isVisited()){        //S is not yet visited
                v.setVisited(true);     // S is set to visited
                dfaWithStack(v);        // S is sent to the function DFAwithstack As argument
            }
        }
    }

    private void dfaWithStack(Vertex rootVertex) {
         this.stack.add(rootVertex);            //stack: rootVertex picked S vertex
            rootVertex.setVisited(true);         //rootvertex which is S is setvisited(true)
         while(!stack.isEmpty()){           //loop until stack isempty()
             Vertex actualVertex = this.stack.pop(); //actualvertex=S;
             System.out.print(actualVertex+" ");
             for (Vertex v: actualVertex.getNeighbourList()){ // S -> [A ,B ,G]
                 if (!v.isVisited()){ //A isvisited() returns false and !isVisited true
                     v.setVisited(true); //now A is set to visited(true)
                     this.stack.push(v);//A is push to the stack
                     actualVertex=null;
                 }

             }
         }
    }
    public DFS(){
        this.stack=new Stack<>();
        Vertex S = new Vertex("S");
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex G = new Vertex("G");

//        Scanner sc = new Scanner(System.in);
//        var x = sc.next();
//        var Z = new Vertex("z");
//        S.setReference(Z);


        list = new ArrayList<>();

        list.add(S);
        list.add(A);
        list.add(B); //list = [S,A,B,C,D,E,G]
        list.add(C);
        list.add(D);
        list.add(E);
        list.add(G);

        S.addNeighbour(G);
        S.addNeighbour(B);
        S.addNeighbour(A);

        A.addNeighbour(S);
        A.addNeighbour(D);
        A.addNeighbour(C);

        B.addNeighbour(S);
        B.addNeighbour(E);
        B.addNeighbour(D);

        C.addNeighbour(G);
        C.addNeighbour(A);

        D.addNeighbour(G);
        D.addNeighbour(B);
        D.addNeighbour(A);

        E.addNeighbour(B);

        G.addNeighbour(S);
        G.addNeighbour(D);
        G.addNeighbour(C);

        System.out.print("S ->");
        System.out.println(S.getNeighbourList());
        System.out.print("A ->");
        System.out.println(A.getNeighbourList());
        System.out.print("B ->");
        System.out.println(B.getNeighbourList());
        System.out.print("C ->");
        System.out.println(C.getNeighbourList());
        System.out.print("D ->");
        System.out.println(D.getNeighbourList());
        System.out.print("E ->");
        System.out.println(E.getNeighbourList());
        System.out.print("G ->");
        System.out.println(G.getNeighbourList());
        System.out.print("Open List : [");


//        list.add(S);
//        list.add(A);
//        list.add(B);
//        list.add(C);
//        list.add(D);
//        list.add(E);
//        list.add(G);
            dfa(list);

    }

    public static void main(String[] args) {
    new DFS();
        System.out.print("]");
    }
}

