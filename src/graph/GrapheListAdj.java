package graph;

import java.util.*;

public class GrapheListAdj implements VarGraph {

    private final Map<String, List<Arc<String>>> ListAdjacence = new HashMap<>();

    public GrapheListAdj() {
        //Implémente le graphe comme étant vide
    }

    //Implémente un graphe avec une population
    public GrapheListAdj(String description) {
        this();
        peupler(description);
    }

    // Ajoute un sommet si il n'est pas déjà dans le graphe
    @Override
    public void ajouterSommet(String noeud) {
        ListAdjacence.putIfAbsent(noeud, new ArrayList<>());
    }

    // Ajoute un arc si il n'est pas déjà dans le graphe
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

    //Retourne l'ensemble des successeurs d'un sommet
    @Override
    public List<Arc<String>> getSucc(String s) {
        return ListAdjacence.getOrDefault(s, new ArrayList<>());
    }

    //Vérifie si un sommet est dans le graphe
    public boolean hasSommet(String noeud) {
        return ListAdjacence.containsKey(noeud);
    }

    //Retourne les voisins d'un sommet
    public List<String> getVoisin(String noeud) {
        List<String> voisins = new ArrayList<>();
        for (Arc<String> arc : ListAdjacence.getOrDefault(noeud, Collections.emptyList())) {
            voisins.add(arc.dst());
        }
        return voisins;
    }

    //Vérifie si un arc est dans le graphe
    private boolean contientArc(String source, String destination) {
        for (Arc<String> arc : ListAdjacence.getOrDefault(source, new ArrayList<>())) {
            if (arc.dst().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    //Retourne l'ensemble des arcs du graphe
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

    //Retourne l'ensemble des sommets du graphe
    public Set<String> getAllSommets() {
        return ListAdjacence.keySet();
    }
}
