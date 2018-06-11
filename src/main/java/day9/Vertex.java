package day9;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

    private final int distance;

    private final Set<Node> edges = new HashSet<>(2);

    public Vertex(Node origin, Node destination, int distance) {
        edges.add(origin);
        edges.add(destination);
        this.distance = distance;
    }

    public boolean contains(Node node) {
        return edges.contains(node);
    }

    public int getDistance() {
        return distance;
    }

}
