package day9;

import java.util.Objects;

public class Node {

    private final String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
