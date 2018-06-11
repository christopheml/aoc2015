package day9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphTest {

    @Test
    void acceptance_test() {
        Graph graph = new Graph();
        graph.addNode("London", "Dublin", 464);
        graph.addNode("London", "Belfast", 518);
        graph.addNode("Dublin", "Belfast", 141);

        assertThat(graph.shortestDistance()).isEqualTo(605);
    }

}
