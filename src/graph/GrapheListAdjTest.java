package graph;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GrapheListAdjTest {

    @Test
    public void testAjoutSommet() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterSommet("A");

        assertTrue(graphe.hasSommet("A"));
        assertEquals(0, graphe.getSucc("A").size());
    }

    @Test
    public void testAjoutArc() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B");

        assertTrue(graphe.hasSommet("A"));
        assertTrue(graphe.hasSommet("B"));

        assertEquals(1, graphe.getSucc("A").size());
        assertEquals(1, graphe.getSucc("B").size());

        assertEquals("B", graphe.getSucc("A").get(0).dst());
        assertEquals("A", graphe.getSucc("B").get(0).dst());

        assertEquals(1, graphe.getSucc("A").get(0).val());
    }

    @Test
    public void testAjoutArcDoubleLeveException() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B");

        assertThrows(IllegalArgumentException.class, () -> graphe.ajouterArc("A", "B"));
        assertThrows(IllegalArgumentException.class, () -> graphe.ajouterArc("B", "A"));
    }

    @Test
    public void testVoisins() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B");
        graphe.ajouterArc("A", "C");

        List<String> voisins = graphe.getVoisin("A");
        assertTrue(voisins.contains("B"));
        assertTrue(voisins.contains("C"));
        assertEquals(2, voisins.size());
    }

    @Test
    public void testSurchargeConstructeur() {
        // Format avec des valeurs entre parenthèses
        String description = "A-B(5), B-C(3), C-D(1), E:";

        GrapheListAdj graphe = new GrapheListAdj(description);

        // Sommets attendus
        Set<String> attendus = Set.of("A", "B", "C", "D", "E");
        assertEquals(attendus, graphe.getAllNoeuds());

        // Vérifie que chaque arc existe
        assertEquals(1, graphe.getSucc("A").size());
        assertEquals("B", graphe.getSucc("A").get(0).dst());

        assertEquals(2, graphe.getSucc("B").size());
        assertTrue(graphe.getVoisin("B").containsAll(List.of("A", "C")));

        assertEquals(2, graphe.getSucc("C").size());
        assertTrue(graphe.getVoisin("C").containsAll(List.of("B", "D")));

        assertEquals(1, graphe.getSucc("D").size());
        assertEquals("C", graphe.getSucc("D").get(0).dst());

        assertEquals(0, graphe.getSucc("E").size()); // sommet isolé
    }

    @Test
    public void testGetAllNoeuds() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B");
        graphe.ajouterArc("B", "C");

        Set<String> noeuds = graphe.getAllNoeuds();
        assertEquals(3, noeuds.size());
        assertTrue(noeuds.containsAll(List.of("A", "B", "C")));
    }

    @Test
    public void testGetAllArcsSansDoublons() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B");
        graphe.ajouterArc("B", "C");

        List<Graph.Arc<String>> arcs = graphe.getAllArcs();
        assertEquals(2, arcs.size());
    }
}
