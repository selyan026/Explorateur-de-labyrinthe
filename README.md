# SAE 2.02 Exploration algorithmique d’un problème

Projet réalisé par le groupe 104 :  
IDRI Selyan, FOURRA Ismail, BAKHTAOUI Yassin, BEN AKREMI Ali  
Chargé de TP : Mikal Ziane

## Partie 1 – Représentation des graphes et algorithme de Dijkstra
Nous avons d’abord créé une structure de graphe orienté pondéré : la classe GrapheListAdj, basée sur une liste d’adjacence.

Méthodes principales :
- ajouterSommet, ajouterArc : construction manuelle du graphe
- getSucc, getVoisin : accès aux successeurs et voisins
- getAllSommets, getAllArcs : récupération complète du graphe
- peupler : génération automatique à partir d’une chaîne (ex : "A-B(3), B-C(2)")

L’algorithme de Dijkstra est codé dans la classe Dijkstra, en respectant l’interface ShortestPath.  
Il calcule les distances minimales depuis un sommet source, lève une IllegalArgumentException en cas d’arc de valeur négative.
  
Les tests de DijkstraTest ont tous été validés.


## Partie 2 – Résolution automatique de labyrinthes

Pour adapter Dijkstra aux labyrinthes, on utilise les fichiers .maze (labyrinthe) et .dist (résultats attendus).

La classe GraphMaze permet de convertir un RegularMaze en un graphe exploitable :
- getSucc renvoie les cases voisines accessibles sous forme d’arcs de coût 1

La classe Checker applique automatiquement Dijkstra sur chaque labyrinthe, compare les résultats avec ceux attendus, et affiche "succès" ou "échec".

Une visualisation est possible via la classe Animation, qui affiche le labyrinthe et le chemin trouvé.

Tous les fichiers du dossier bench ont été testés avec succès.


## Bilan

- Implémentation conforme au sujet
- Tous les tests passent
- Code organisé par packages : graph, dijkstra, adaptateur, application
- Dijkstra fonctionne sur des graphes textuels comme sur des labyrinthes binaires
