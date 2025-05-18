# SAE 2.02 — Graphes et Labyrinthes
## Membres de l’équipe
- IDRI Selyan 
- BEN AKREMI Ali
- FOURRA Ismail
- BAKHTAOUI Yassin
Notre chargé de TP est Monsieur Mikal ZIANE <br> <br> 

## Fonctionnalités implémentées
- **Implémentation de l'algorithme de Dijkstra** dans la classe `Dijkstra`, conforme à l’interface `ShortestPath<T>`.
- **Structure de graphe personnalisée** `GrapheListAdj` basée sur une liste d’adjacence.
- **Adaptateur `GraphMaze`** codé pour connecter un `RegularMaze` à l’interface `Graph`.
- **Checker opérationnel** : tous les fichiers `.maze` et `.dist` fournis dans `bench/` passent les tests sans erreur.
- **Animation graphique** fonctionnelle avec `Animation.java` : le chemin trouvé s’affiche correctement sur les labyrinthes.
- **Tests unitaires** présents, dont ceux fournis sur Moodle (`DijkstraTest`, `GrapheListAdjTest`, etc.).
- **Sérialisation/lecture** des distances (`Distances.writeDist()` / `Distances.readDist()`).

## Limites ou problèmes
- Aucun bug critique n’a été identifié.
- Tous les cas de test fournis passent. L'algorithme lève correctement une `IllegalArgumentException` si un arc a une valuation négative.

## Remarques
- La classe `Dijkstra` est **générique**, fonctionne avec tout type de graphe conforme à l’interface `Graph<T>`.
- Le projet respecte les principes de **clarté du code**, de **non-duplication**, de **taille raisonnable des méthodes** (10 à 15 lignes), et **d'encapsulation**.
- Le diagramme d’architecture est fourni dans le fichier `architecture.pdf`.

