package graph;

import java.util.*;

public class GrapheListAdj implements VarGraph {

    private final Map<String, List<Arc<String>>> ListAdjacence = new HashMap<>();
    private static final int VALEUR_ARC = 1;

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

    // Implémentation imposée par VarGraph (valeur ignorée ici)
    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        ajouterArc(source, destination); // valeur fixée à la constante
    }

    // Ajoute un arc entre deux sommets avec valeur constante
    public void ajouterArc(String source, String destination) {
        ajouterSommet(source);
        ajouterSommet(destination);

        if (contientArc(source, destination)) {
            throw new IllegalArgumentException("L'arc existe déjà !");
        }

        ListAdjacence.get(source).add(new Arc<>(VALEUR_ARC, destination));
        ListAdjacence.get(destination).add(new Arc<>(VALEUR_ARC, source)); // non orienté
    }

    // Donne la liste des arcs sortants d’un sommet
    @Override
    public List<Arc<String>> getSucc(String s) {
        return ListAdjacence.getOrDefault(s, new ArrayList<>());
    }

    // Vérifie si un sommet est présent dans le graphe
    public boolean hasSommet(String noeud) {
        return ListAdjacence.containsKey(noeud);
    }

    // Retourne tous les voisins d'un sommet
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

    // Retourne tous les arcs du graphe, sans doublon
    public List<Arc<String>> getAllArcs() {
        List<Arc<String>> arcs = new ArrayList<>();
        Set<String> dejaVu = new HashSet<>();

        for (String source : ListAdjacence.keySet()) {
            for (Arc<String> arc : ListAdjacence.get(source)) {
                String dest = arc.dst();
                String cle = source.compareTo(dest) < 0 ? source + "-" + dest : dest + "-" + source;
                if (!dejaVu.contains(cle)) {
                    arcs.add(new Arc<>(VALEUR_ARC, dest));
                    dejaVu.add(cle);
                }
            }
        }

        return arcs;
    }


    // Retourne l’ensemble des sommets du graphe
    public Set<String> getAllNoeuds() {
        return ListAdjacence.keySet();
    }
}