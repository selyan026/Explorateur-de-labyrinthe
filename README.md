Partie JAVA de la SAE2.02, fait par les membres du Groupe 104 : IDRI Selyan, FOURRA Ismail, BAKHTAOUI Yassin et BEN AKREMI Ali. 
Notre chargé de TP est Monsieur Mikal ZIANE <br> <br> 


Partie 1 – Représentation des graphes et algorithme de Dijkstra <br> <br>

Dans cette première partie, nous avons développé une structure de graphe personnalisée nommée GrapheListAdj, qui implémente les interfaces Graph<String> et VarGraph. Elle utilise une représentation par liste d’adjacence pour gérer dynamiquement les sommets et les arcs pondérés. <br>

Cette classe permet notamment de construire des graphes manuellement à partir d’une description textuelle (ex : "A-B(3), B-C(2)") et est compatible avec l’algorithme de Dijkstra. <br>

L’algorithme de Dijkstra est ensuite implémenté dans la classe Dijkstra, qui respecte l’interface ShortestPath<T>. Il permet de calculer les distances minimales depuis un sommet source vers tous les sommets accessibles.
L’implémentation lève une exception si un arc de valuation négative est détecté, comme exigé dans le sujet. Les tests sont réalisés dans la classe DijkstraTest, en se basant sur les graphes construits avec GrapheListAdj.
