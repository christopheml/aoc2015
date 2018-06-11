package day9;

import java.util.HashSet;
import java.util.Set;

class Vertex {

    private final int distance;

    private final Set<Node> edges = new HashSet<>(2);

    Vertex(Node origin, Node destination, int distance) {
        edges.add(origin);
        edges.add(destination);
        this.distance = distance;
    }

    boolean contains(Node node) {
        return edges.contains(node);
    }

    int getDistance() {
        return distance;
    }

}
