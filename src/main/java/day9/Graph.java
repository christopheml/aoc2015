package day9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private final Set<Vertex> vertices;

    private final Set<Node> nodes;

    public Graph() {
        vertices = new HashSet<>();
        nodes = new HashSet<>();
    }

    public void addNode(String origin, String destination, int distance) {
        Node originNode = new Node(origin);
        Node destinationNode = new Node(destination);
        nodes.add(originNode);
        nodes.add(destinationNode);
        vertices.add(new Vertex(originNode, destinationNode, distance));
    }

    public void readNode(String representation) {
        String[] parts = representation.split(" ");
        addNode(parts[0], parts[2], Integer.parseInt(parts[4]));
    }

    public int shortestDistance() {
        int shortestDistance = Integer.MAX_VALUE;
        List<List<Node>> routes = Permutations.compute(nodes);
        for (List<Node> route : routes) {
            int distance = 0;
            for (int i = 0; i < route.size() - 1; i++) {
                distance += getDistance(route.get(i), route.get(i + 1));
            }
            if (distance < shortestDistance) {
                shortestDistance = distance;
            }
        }
        return shortestDistance;
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
