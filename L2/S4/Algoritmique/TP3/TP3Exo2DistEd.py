from random import *
from math import sqrt
from itertools import *
import matplotlib.pyplot as plt

###########################################

def AfficheGraph(points,G):
    n=len(points)
    plt.plot([p[0] for p in points],[p[1] for p in points],'bo',markersize =5,zorder=3)
    #zorder: plus c'est eleve, plus c'est devant. Par defaut, les lignes sont a 2, les point a 1
    plt.title('Graphe G')
    nomSommets=[i for i in range(0,n)]
    for i in range(0,n):
        plt.text(points[i][0]+10,points[i][1]+10,nomSommets[i], fontsize=10)
    for i in range(0,len(G)):
        for j in range(0,len(G[i])): #on relie i a son jeme voinsin
            plt.plot([points[i][0],points[G[i][j]][0]],[points[i][1],points[G[i][j]][1]],'r-') 
    plt.show()

def AfficheGraphEtArbre(points,G,pere):
    n=len(points)
    plt.plot([p[0] for p in points],[p[1] for p in points],'bo',markersize =5,zorder=3)
    #zorder: plus c'est eleve, plus c'est devant. Par defaut, les lignes sont a 2, les point a 1
    plt.title('Graphe G')
    nomSommets=[i for i in range(0,n)]
    for i in range(0,n):
        plt.text(points[i][0]+10,points[i][1]+10,nomSommets[i], fontsize=10)
    for i in range(0,len(G)):
        for j in range(0,len(G[i])): #on relie i a son jeme voinsin
            plt.plot([points[i][0],points[G[i][j]][0]],[points[i][1],points[G[i][j]][1]],'0.9')
    for i in range(1,n):
        plt.plot([points[i][0],points[pere[i]][0]],[points[i][1],points[pere[i]][1]],'r-',zorder=2.5)
    plt.show()

#######Initialisation Graphe########

def InitGraphFix(points,G):
    points.extend([[962,909],[601,645],[813,594],[997,439],[373,383],[782,172],[526,403],[400,742],[281,148],[158,530]])
    G.extend([[1,2,3,7],[0,2,6,7],[0,1,3,5,6],[0,2,5],[6,7,8,9],[2,3,6,8],[1,2,4,5,8],[0,1,4,9],[4,5,6,9],[4,7,8]])

#######Parcours largeur########

def ParcoursLargeur(G,ordre,pere,niv):
    n=len(G)
    dejaVu=[0]*n
    aTraiter=[0]
    dejaVu[0]=1
    ordre[0]=1
    pere[0]=0
    niv[0]=0
    temps=2
    while aTraiter:
        v=aTraiter[0]
        aTraiter.pop(0)
        for x in G[v]:
            if dejaVu[x]==0:
                dejaVu[x]=1
                aTraiter.append(x)
                ordre[x]=temps
                temps=temps+1
                pere[x]=v
                niv[x]=niv[v]+1

#######Parcours profondeur########

def ParcoursProfondeur(G,debut,fin,pere):
    n=len(G)
    dejaVu=[0]*n
    aTraiter=[0]
    dejaVu[0]=1
    debut[0]=1
    pere[0]=0
    temps=2
    while aTraiter:
        x=aTraiter[-1]
        if not G[x]:
            aTraiter.pop()
            fin[x]=temps
            temps=temps+1
        else:
            y=G[x][-1]
            G[x].pop()
            if dejaVu[y]==0:
                dejaVu[y]=1
                aTraiter.append(y)
                debut[y]=temps
                temps=temps+1
                pere[y]=x

#######Programme Principal########
points=[]
G=[]
InitGraphFix(points, G)
AfficheGraph(points, G)

print("Parcours en largeur:")
n=len(G)
ordre=[-1]*n
pere=[-1]*n
niv=[-1]*n
ParcoursLargeur(G,ordre,pere,niv)
print(ordre)
print(pere)
print(niv)
AfficheGraphEtArbre(points,G,pere)

print("Parcours en profondeur:")
pere=[-1]*n
debut=[-1]*n
fin=[-1]*n
G1=[]
for L in G:
    G1.append(list(L))
print(G)
print(G1)
ParcoursProfondeur(G,debut,fin,pere)
print(debut)
print(fin)
print(pere)
print(G)
print(G1)
AfficheGraphEtArbre(points,G1,pere)
