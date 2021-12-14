package com.algorithm;

public class PageRankAlgorithm {

    public static void main(String[] args) {
        String root = "https://edition.cnn.com";
        BFS bfs = new BFS();
        bfs.discoverableWeb(root);
    }

}


