package day9;

import common.PuzzleInput;

public class Solution {

    public static void main(String... args) {
        Graph graph = new Graph();
        PuzzleInput.read("/day9.txt").stream().forEach(graph::readNode);
        System.out.println("Shortest distance is " + graph.shortestDistance());
        System.out.println("Longest distance is " + graph.longestDistance());
    }

}
