package dijkstra;

import graph.Graph;

import java.util.HashMap;

public class Dijkstra<T> implements ShortestPath<T> {
    @Override
    public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) {
        ShortestPath.Distances<T> r = new Distances<>(new HashMap<>(), new HashMap<>());
        return null;
    }

}
