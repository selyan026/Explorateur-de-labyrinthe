package graph;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GrapheListAdjTest {

    private static final int VALEUR_PAR_DEFAUT_ARC = 1;

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
        graphe.ajouterArc("A", "B", VALEUR_PAR_DEFAUT_ARC);

        assertTrue(graphe.hasSommet("A"));
        assertTrue(graphe.hasSommet("B"));

        assertEquals(1, graphe.getSucc("A").size());
        assertEquals(1, graphe.getSucc("B").size());

        assertEquals("B", graphe.getSucc("A").get(0).dst());
        assertEquals("A", graphe.getSucc("B").get(0).dst());

        assertEquals(VALEUR_PAR_DEFAUT_ARC, graphe.getSucc("A").get(0).val());
    }

    @Test
    public void testAjoutArcDoubleLeveException() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B", VALEUR_PAR_DEFAUT_ARC);

        assertThrows(IllegalArgumentException.class, () -> graphe.ajouterArc("A", "B", VALEUR_PAR_DEFAUT_ARC));
        assertThrows(IllegalArgumentException.class, () -> graphe.ajouterArc("B", "A", VALEUR_PAR_DEFAUT_ARC));
    }

    @Test
    public void testVoisins() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B", VALEUR_PAR_DEFAUT_ARC);
        graphe.ajouterArc("A", "C", VALEUR_PAR_DEFAUT_ARC);

        List<String> voisins = graphe.getVoisin("A");
        assertTrue(voisins.contains("B"));
        assertTrue(voisins.contains("C"));
        assertEquals(2, voisins.size());
    }

    @Test
    public void testSurchargeConstructeur() {
        String description = "A-B(5), B-C(3), C-D(1), E-E(0)";

        GrapheListAdj graphe = new GrapheListAdj(description);

        Set<String> attendus = Set.of("A", "B", "C", "D", "E");
        assertEquals(attendus, graphe.getAllSommets());

        assertEquals(1, graphe.getSucc("A").size());
        assertEquals("B", graphe.getSucc("A").get(0).dst());

        assertEquals(2, graphe.getSucc("B").size());
        assertTrue(graphe.getVoisin("B").containsAll(List.of("A", "C")));

        assertEquals(2, graphe.getSucc("C").size());
        assertTrue(graphe.getVoisin("C").containsAll(List.of("B", "D")));

        assertEquals(1, graphe.getSucc("D").size());
        assertEquals("C", graphe.getSucc("D").get(0).dst());

        assertEquals(1, graphe.getSucc("E").size());
        assertEquals("E", graphe.getSucc("E").get(0).dst());
    }

    @Test
    public void testGetAllNoeuds() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B", VALEUR_PAR_DEFAUT_ARC);
        graphe.ajouterArc("B", "C", VALEUR_PAR_DEFAUT_ARC);
        Set<String> noeuds = graphe.getAllSommets();
        assertEquals(3, noeuds.size());
        assertTrue(noeuds.containsAll(List.of("A", "B", "C")));
    }

    @Test
    public void testGetAllArcsSansDoublons() {
        GrapheListAdj graphe = new GrapheListAdj();
        graphe.ajouterArc("A", "B", VALEUR_PAR_DEFAUT_ARC);
        graphe.ajouterArc("B", "C", VALEUR_PAR_DEFAUT_ARC);

        List<Graph.Arc<String>> arcs = graphe.getAllArcs();
        assertEquals(2, arcs.size());
    }
}
