package graph;

import java.util.*;

public class GrapheListAdj implements VarGraph {

    private final Map<String, List<Arc<String>>> ListAdjacence = new HashMap<>();

    public GrapheListAdj() {}

    public GrapheListAdj(String description) {
        this();
        peupler(description);
    }

    @Override
    public void ajouterSommet(String noeud) {
        ListAdjacence.putIfAbsent(noeud, new ArrayList<>());
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        ajouterSommet(source);
        ajouterSommet(destination);


        if (contientArc(source, destination)) {
            throw new IllegalArgumentException("L'arc entre " + source + " et " + destination + " existe déjà !");
        }

        if (source.equals(destination)) {
            ListAdjacence.get(source).add(new Arc<>(valeur, destination));
        } else {
            ListAdjacence.get(source).add(new Arc<>(valeur, destination));
            ListAdjacence.get(destination).add(new Arc<>(valeur, source));
        }
    }



    @Override
    public List<Arc<String>> getSucc(String s) {
        return ListAdjacence.getOrDefault(s, new ArrayList<>());
    }

    public boolean hasSommet(String noeud) {
        return ListAdjacence.containsKey(noeud);
    }

    public List<String> getVoisin(String noeud) {
        List<String> voisins = new ArrayList<>();
        for (Arc<String> arc : ListAdjacence.getOrDefault(noeud, Collections.emptyList())) {
            voisins.add(arc.dst());
        }
        return voisins;
    }

    private boolean contientArc(String source, String destination) {
        for (Arc<String> arc : ListAdjacence.getOrDefault(source, new ArrayList<>())) {
            if (arc.dst().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public List<Arc<String>> getAllArcs() {
        List<Arc<String>> arcs = new ArrayList<>();
        Set<String> dejaVu = new HashSet<>();

        for (String source : ListAdjacence.keySet()) {
            for (Arc<String> arc : ListAdjacence.get(source)) {
                String dest = arc.dst();
                String cle = source.compareTo(dest) < 0 ? source + "-" + dest : dest + "-" + source;
                if (!dejaVu.contains(cle)) {
                    arcs.add(new Arc<>(arc.val(), dest)); // garder la vraie valeur
                    dejaVu.add(cle);
                }
            }
        }
        return arcs;
    }

    public Set<String> getAllSommets() {
        return ListAdjacence.keySet();
    }
}
