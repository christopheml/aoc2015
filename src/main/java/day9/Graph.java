package day9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Graph {

    private final Set<Vertex> vertices;

    private final Set<Node> nodes;

    Graph() {
        vertices = new HashSet<>();
        nodes = new HashSet<>();
    }

    void addNode(String origin, String destination, int distance) {
        var originNode = new Node(origin);
        var destinationNode = new Node(destination);
        nodes.add(originNode);
        nodes.add(destinationNode);
        vertices.add(new Vertex(originNode, destinationNode, distance));
    }

    void readNode(String representation) {
        String[] parts = representation.split(" ");
        addNode(parts[0], parts[2], Integer.parseInt(parts[4]));
    }

    int shortestDistance() {
        List<List<Node>> routes = Permutations.compute(nodes);
        return routes.stream().mapToInt(this::getDistance).min().orElseThrow();
    }

    private int getDistance(List<Node> route) {
        int distance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            distance += getDistance(route.get(i), route.get(i + 1));
        }
        return distance;
    }

    private Integer getDistance(Node origin, Node destination) {
        return vertices.stream()
            .filter(vertex -> vertex.contains(origin))
            .filter(vertex -> vertex.contains(destination))
            .mapToInt(Vertex::getDistance)
            .findAny()
            .orElseThrow();
    }

}
