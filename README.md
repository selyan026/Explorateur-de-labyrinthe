# Le labyrinthe de Dijkstra

Projet réalisé dans le cadre de la SAE 2.02 : Exploration algorithmique d’un problème  
Groupe 104 :  
IDRI Selyan, FOURRA Ismail, BAKHTAOUI Yassin, BEN AKREMI Ali  
Chargé de TP : Mikal Ziane

## Partie 1 : Représentation des graphes et algorithme de Dijkstra

Nous avons développé une structure de graphe orienté pondéré à l’aide d’une liste d’adjacence (GrapheListAdj).  
Cette structure permet d’ajouter des sommets et arcs, et d’interroger les successeurs ou voisins d’un sommet.

Méthodes principales implémentées :  
• ajouterSommet, ajouterArc : construction du graphe  
• getSucc, getVoisin : exploration des sommets  
• getAllSommets, getAllArcs : récupération complète  
• peupler : génération automatique depuis une chaîne textuelle (ex. "A-B(3), B-C(2)")

L’algorithme de Dijkstra est codé dans la classe Dijkstra, en respectant l’interface ShortestPath.  
Il calcule les distances minimales depuis un sommet source, et lève une exception si un arc de coût négatif est rencontré.

Tous les tests unitaires dans DijkstraTest ont été validés.

## Partie 2 : Résolution automatique de labyrinthes

Pour étendre Dijkstra à des labyrinthes, nous avons utilisé les fichiers .maze (labyrinthe) et .dist (distances attendues depuis le départ)

Classes principales :  
• GraphMaze : convertit un RegularMaze en un graphe compatible, via getSucc qui retourne les cases accessibles avec un coût de 1  
• Checker : applique Dijkstra, compare les résultats à ceux attendus, et affiche un succès ou un échec  
• Animation : permet de visualiser graphiquement le parcours dans le labyrinthe

Tous les fichiers du dossier bench ont été testés avec succès.

## Bilan

Implémentation complète et conforme au sujet  
Tous les tests passent  
Code organisé par packages : graph, dijkstra, adaptator, applications  
Dijkstra fonctionne aussi bien sur des graphes textuels que sur des labyrinthes binaires
