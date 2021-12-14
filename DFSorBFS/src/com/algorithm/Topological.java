package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological {

    private final Stack<Vertex> stack;
    private final ArrayList<Vertex> order;

    public static class Vertex{

        private String name;
        private boolean visited;
        private int size=0;
        private List<Vertex> neighbourList;
       // private Vertex node;

//        public void setReference(Vertex node){
//            this.node=node;
//        }
        public boolean isEmpty(){
            return size==0;
        }
//        public Vertex getNode(){
//            return node;
//        }
        public void addNeighbour(Vertex vertex){
            this.neighbourList.add(vertex);
            size++;
        }
//       public String getName() {
//            return name;
//        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isVisited() {
            return !this.visited;
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
            setName(name);
            setNeighbourList(new ArrayList<>());
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public Topological() {
        this.stack = new Stack<>();
        this.order= new ArrayList<>();
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        Vertex J = new Vertex("J");
        Vertex K = new Vertex("K");
        Vertex L = new Vertex("L");
        Vertex M = new Vertex("M");

        List<Vertex> list = new ArrayList<>();
        list.add(H);
        list.add(E);
        list.add(C);
//        list.add(A);
//        list.add(B);
//        list.add(D);
//        list.add(F);
//        list.add(G);
//        list.add(I);
//        list.add(J);
//        list.add(K);
//        list.add(L);
//        list.add(M);

        A.addNeighbour(D);
        B.addNeighbour(D);
        C.addNeighbour(A);
        C.addNeighbour(B);
        D.addNeighbour(H);
        D.addNeighbour(G);
        E.addNeighbour(A);
        E.addNeighbour(D);
        E.addNeighbour(F);
        F.addNeighbour(K);
        F.addNeighbour(J);
        G.addNeighbour(I);
        H.addNeighbour(J);
        H.addNeighbour(I);
        I.addNeighbour(L);
        J.addNeighbour(M);
        J.addNeighbour(L);
        K.addNeighbour(J);

//        System.out.print("Open List : [ ");

        topologicalSort(list);
    }
    public void topologicalSort(List<Vertex> list){
        for (Vertex vertex : list){//H
            if (vertex.isVisited()){//H is not visited
                topologicalSearch(vertex);//order(H)
                vertex.setVisited(true);
            }
        }

    }

    private void topologicalSearch(Vertex vertex) {
        stack.push(vertex);//H-> I
        for (Vertex nei : vertex.getNeighbourList()){//I && J->I has M neigbour
                    if (nei.isVisited() && !vertex.isEmpty()){//I is not visited && I has its neighbour -> M is not visited and list empty
                        topologicalSearch(nei);//order(I)
                        nei.setVisited(true);
                       }

                }
        Vertex v=stack.pop();
       order.add(v);

        return;
        }




    public static void main(String[] args) {
      Topological top=  new Topological();
        System.out.println("Open List : "+top.order);
        System.out.print("Topological Order : [");
        for (int i = top.order.size()-1 ; i>=0 ;i--){
            System.out.print(top.order.get(i));
            if (i==0)continue;
            System.out.print(", ");
        }
        System.out.println("]");

    }
}
