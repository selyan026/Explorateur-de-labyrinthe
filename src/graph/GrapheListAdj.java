package graph;

import java.util.*;

public class GrapheListAdj implements VarGraph {

    private final Map<String, List<Arc<String>>> ListAdjacence = new HashMap<>();

    public GrapheListAdj() {
        // HashMap déjà initialisé comme vide
    }

    // Constructeur avec une chaîne au format "A-B(5), A-C(10), B-C(3)"
    public GrapheListAdj(String description) {
        this(); // appelle le constructeur vide
        peupler(description);
    }

    // Ajouté un sommet au graphe si il n'est pas présent
    @Override
    public void ajouterSommet(String noeud) {
        ListAdjacence.putIfAbsent(noeud, new ArrayList<>());
    }

    // Ajouter un arc entre deux noeuds avec une valeur (non orienté donc bidirectionnel)
        @Override
        public void ajouterArc(String source, String destination, Integer valeur) {
            if (contientArc(source, destination)) {
                throw new IllegalArgumentException("L'arc existe déjà !");
            }
            ajouterSommet(source);
            ajouterSommet(destination);
            ListAdjacence.get(source).add(new Arc<>(valeur, destination));
            ListAdjacence.get(destination).add(new Arc<>(valeur, source)); // car non orienté
        }

    // Donne la liste des arcs sortants d’un sommet
    @Override
    public List<Arc<String>> getSucc(String s) {
        return ListAdjacence.getOrDefault(s, new ArrayList<>());
    }

    // Vérifie si un sommet est présent dans le graphe
    public boolean HasSommet (String noeud) {
        return ListAdjacence.containsKey(noeud);
    }

    // Retourne tout les voisins d'un sommet
    public List<String> getVoisin(String noeud) {
        List<Arc<String>> arcs = ListAdjacence.getOrDefault(noeud, new ArrayList<>());
        List<String> voisins = new ArrayList<>();
        for (Arc<String> arc : arcs) {
            voisins.add(arc.dst());
        }
        return voisins;
    }

    // Vérifie si un arc existe déjà entre deux sommets
    private boolean contientArc(String source, String destination) {
        List<Arc<String>> arcs = ListAdjacence.get(source);
        if (arcs == null) return false;
        for (Arc<String> arc : arcs) {
            if (arc.dst().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    // Retourne l’ensemble des noeuds du graphe
    public Set<String> getAllNoeuds() {
        return ListAdjacence.keySet();
    }
}