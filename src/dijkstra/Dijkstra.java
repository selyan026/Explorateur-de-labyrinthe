package dijkstra;

import graph.Graph;
import java.util.*;

public class Dijkstra<T> implements ShortestPath<T> {

    @Override
    public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) {
        Map<T, Integer> dist = new HashMap<>();
        Map<T, T> pred = new HashMap<>(); // Stock les prédécesseurs
        Set<T> visited = new HashSet<>(); // Sommets déjà visités
        PriorityQueue<T> file = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        // Initialisation avec un distance de 0 et pas de prédécesseurs
        dist.put(src, 0);
        pred.put(src, null);
        file.add(src);

        // parcours les sommets
        while (!file.isEmpty()) {
            T sommet = file.poll();
            if (!visited.add(sommet)) continue;
            animator.accept(sommet, dist.get(sommet));

            // exploration des voisins
            for (Graph.Arc<T> arc : g.getSucc(sommet)) {
                if (arc.val() < 0) throw new IllegalArgumentException();
                int newDist = dist.get(sommet) + arc.val();

                if (dist.getOrDefault(arc.dst(), Integer.MAX_VALUE) > newDist) {
                    dist.put(arc.dst(), newDist);
                    pred.put(arc.dst(), sommet);
                    file.add(arc.dst());
                }
            }
        }
        return new Distances<>(dist, pred);
    }
}
