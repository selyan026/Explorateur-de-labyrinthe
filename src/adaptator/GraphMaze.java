package adaptator;

import graph.Graph;
import maze.Maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphMaze <C> implements Graph <C> {
    private final Maze<C> maze;

    public GraphMaze(Maze<C> maze) {
        this.maze = maze;
    }
    @Override
    public List<Arc<C>> getSucc(C cell) {
        List<Arc<C>> successeurs = new ArrayList<>();
        Set<C> voisins = maze.openedNeighbours(cell);
        for (C voisin : voisins) {
            successeurs.add(new Arc<>(1, voisin));
        }
        return successeurs;
    }
}