package com.algorithm;



import java.util.*;

public class UniformCostSearch {
    List<Node> list;
    private final Queue<Node> openList;
    private final Queue<Node> closedList;
    private final Queue<Node> open;

    int distance = 0;
    List<Integer> dist;
    public void Dfs(List<Node> nodes) {
        for (Node n : nodes) {
            if (n.isVisited()) {
                closedList.add(n);
                BfsWithQueue(n);
            }
        }
    }

    private void BfsWithQueue(Node node) {
        open.add(node);
        int cost = Integer.MAX_VALUE;

            for (Node node1 : openList) {
                    if (node1.getFrom() != null) {
                        if (cost>=node1.getFrom().getDistance()) {
                            cost = node1.getFrom().getDistance();
                           // System.out.println(node1+" "+node1.getFrom().getDistance());
                        }
                    }

            }
            for (Node node1:openList){
                    if (node1.getFrom() != null) {
                        if (node1.getFrom().getDistance() == cost) {
                            closedList.add(node1);
                            openList.remove(node1);

                        }
                    }

            }
            Node leafNode;
            leafNode = closedList.poll();//s
        if (leafNode!=null)
            if (leafNode.isVisited()) {
                for (Edge edge : leafNode.getEdges()) { //B A G
                    if (!edge.getTo().getEdges().isEmpty()) {
                            openList.add(edge.getTo());
                            distance = distance + edge.getDistance();
                            System.out.println(edge + " " + "Total cost " + distance);
                            if (edge.getTo().isVisited())
                                BfsWithQueue(edge.getTo());
                                //edge.getTo().setVisited(true);
                                //dist.add(distance);
                            distance=distance-edge.getDistance();
                        }else{
                            distance = distance + edge.getDistance();
                                }

                        if (edge.getTo().getEdges().isEmpty()) {
                            if (!edge.getTo().getName().equals("G")){
                                distance = distance - edge.getDistance();
                            break;
                        }else{
                                dist.add(distance);
                                System.out.println(edge + " " + "Total cost " + distance);
                                System.out.println();
                                distance = distance - edge.getDistance();
                                edge.getTo().setVisited(true);
                            }
                    }
                    }

                }
        }






    public UniformCostSearch() {
        this.openList = new LinkedList<>();
        list = new ArrayList<>();
        dist= new ArrayList<>();
        this.closedList = new LinkedList<>();
        this.open = new LinkedList<>();
        //Node Created
        Node S = new Node("S");
        Node G = new Node("G");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        //Edges created
        Edge G_S = new Edge(G, S, 9);
        Edge A_S = new Edge(A, S, 2);
        Edge B_S = new Edge(B, S, 1);
        Edge C_A = new Edge(C, A, 2);
        Edge D_A = new Edge(D, A, 3);
        Edge D_B = new Edge(D, B, 2);
        Edge E_B = new Edge(E, B, 4);
        Edge G_C = new Edge(G, C, 4);
        Edge G_D = new Edge(G, D, 4);
        //Edges of Nodes
        S.addEdges_to(G_S);
        S.addEdges_to(A_S);
        S.addEdges_to(B_S);
        A.addEdges_to(C_A);
        A.addEdges_to(D_A);
        B.addEdges_to(D_B);
        B.addEdges_to(E_B);
        C.addEdges_to(G_C);
        D.addEdges_to(G_D);

        list.add(S);
        Dfs(list);

    }

    public void search_2() {
        distance = 0;
        openList.clear();
        list.clear();
        dist.clear();
        Node S = new Node("S");
        Node G = new Node("G");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");

        Edge S_A = new Edge(A, S, 1);
        Edge S_G = new Edge(G, S, 12);

        Edge A_B = new Edge(B, A, 3);
        Edge A_C = new Edge(C, A, 1);

        Edge B_D = new Edge(D, B, 3);
        Edge C_D = new Edge(D, C, 1);
        Edge C_G = new Edge(G, C, 2);
        Edge D_G = new Edge(G, D, 3);

        S.addEdges_to(S_A);
        S.addEdges_to(S_G);

        A.addEdges_to(A_B);
        A.addEdges_to(A_C);

        B.addEdges_to(B_D);
        C.addEdges_to(C_D);
        C.addEdges_to(C_G);
        D.addEdges_to(D_G);

        list.add(S);
        Dfs(list);
    }

    class Node {
        String name;
        boolean Visited;
        public List<Edge> to;
        int size = 0;
        Edge From;



        public Edge getFrom() {
            return From;
        }

        public void setFrom(Edge from) {
            this.From = from;
        }

        public Node(String name) {
            this.setName(name);
            to = new ArrayList<>();
        }

        public void addEdges_to(Edge edge) {
            edge.to.setFrom(edge);
            this.to.add(edge);
            size++;
            insertionSort(getEdges());
        }

        private void insertionSort(List<Edge> list) {
            int n = list.size();
            for (int k = 1; k < n; k++) {
                Edge edge = list.get(k);
                int dist = list.get(k).getDistance();
                int j = k;
                while (j > 0 && list.get(j - 1).getDistance() > dist) {
                    list.add(j, list.get(j - 1));
                    list.remove(j + 1);
                    j--;
                }
                list.add(j, edge);
                list.remove(j + 1);
            }
        }

        public List<Edge> getEdges() {

            return this.to;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isVisited() {
            return !Visited;
        }

        public void setVisited(boolean visited) {
            this.Visited = visited;
        }

        public String toString() {
            return name + " ";
        }
    }

    class Edge {
        Node to;
        int distance;
        Node from;

        public Edge(Node to, Node from, int distance) {
            setTo(to);
            setDistance(distance);
            setFrom(from);
        }

        public Node getTo() {
            return to;
        }

        public void setTo(Node to) {
            this.to = to;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setFrom(Node from) {
            this.from = from;
        }

        public String toString() {
            return "From Node(" + from.getName() + ") Towards Node(" + to.getName() + ") Cost: " +
                    distance;
        }
    }

        public static void main(String[] args) {
            UniformCostSearch Graph = new UniformCostSearch();
            System.out.println("Closed List = " + Graph.open);
            System.out.println("Solution Cost = " + Graph.dist);
            Graph.search_2();
            System.out.println("Closed List = " + Graph.open);
            System.out.println("Solution Cost = " + Graph.dist);
        }

}