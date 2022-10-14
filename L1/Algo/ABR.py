from random import shuffle

import matplotlib.pyplot as plt
import networkx as nx


class ABR:
    def __init__(self, racine=None):
        if racine is not None:
            self.racine = racine
        else:
            self.racine = None

    def inserer(self, z):
        y = None
        x = self.racine
        while x != None:
            y = x
            if z.clef < x.clef:
                x = x.gauche
            else:
                x = x.droit
        z.pere = y
        if y == None:
            self.racine = z
        else:
            if z.clef < y.clef:
                y.gauche = z
            else:
                y.droit = z

    def genArbre(self, n=0):
        l = list(range(n))
        shuffle(l)
        for i in range(n):
            self.inserer(Sommet(l[i]))

    def parcoursInfixe(self, x):
        if x != None:
            self.parcoursInfixe(x.gauche)
            print(x.clef)
            self.parcoursInfixe(x.droit)

    def recherche(self, x, c):
        if x == None or x.clef == c:
            return x
        if c < x.clef:
            return self.recherche(x.gauche, c)
        else:
            return self.recherche(x.droit, c)


class Sommet:
    def __init__(self, clef=None):
        self.pere = None
        self.gauche = None
        self.droit = None
        if clef is not None:
            self.clef = clef
        else:
            self.clef = None


def afficher(T):
    G = nx.DiGraph()

    def construireGraphe(x, G):
        if x is not None:
            G.add_node(x.clef)
            if x.gauche is not None:
                G.add_edge(x.clef, x.gauche.clef, gd="red")
                construireGraphe(x.gauche, G)
            if x.droit is not None:
                G.add_edge(x.clef, x.droit.clef, gd="blue")
                construireGraphe(x.droit, G)

    construireGraphe(T.racine, G)
    attr = nx.get_edge_attributes(G, "gd")
    colorsOfEdges = [c for e, c in attr.items()]
    colorsOfVertices = ["yellow"] + ["blue"] * (G.number_of_nodes() - 1)
    nx.draw_planar(
        G, with_labels=True, edge_color=colorsOfEdges, node_color=colorsOfVertices
    )
    pos = nx.planar_layout(G)
    labelsOfEdges = dict(
        [
            (
                (
                    u,
                    v,
                ),
                "gauche" if d["gd"] == "red" else "droit",
            )
            for u, v, d in G.edges(data=True)
        ]
    )
    nx.draw_networkx_edge_labels(G, pos, edge_labels=labelsOfEdges)
    print("racine de l'arbre :", T.racine.clef)
    plt.show()


arbre = ABR()
arbre.genArbre(10)
print(arbre.recherche(arbre.racine, 8))
print(arbre.parcoursInfixe(arbre.recherche(arbre.racine, 8)))
afficher(arbre)