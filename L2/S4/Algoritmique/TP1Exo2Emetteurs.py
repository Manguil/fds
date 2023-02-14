from random import *
from itertools import *
import matplotlib.pyplot as plt

def AfficheMaisons(Maison):
    n=len(Maison)
    plt.plot([m[0] for m in Maison],[m[1] for m in Maison],'bo',markersize =3,label='maison')
    plt.title(str(n)+' Maisons')
    plt.legend()
    plt.axis('equal')
    plt.show()

def AfficheEmetteurs(Maison,Emetteur,rayon):
    n=len(Maison)
    fig, ax = plt.subplots()
    for i in range(n):
        if Emetteur[i]==1:
            circle=plt.Circle(Maison[i],rayon, color='r')
            ax.add_artist(circle)
    AfficheMaisons(Maison)


def GenererMaisons(Maison,n):
    return [(randint(1,1001),randint(1,1001)) for i in range(n)]
    

def Couvre(Maison,i,j):
    return (Maison[i][0]-Maison[j][0])**2+(Maison[i][1]-Maison[j][1])**2 <= rayon**2

def dansRayon(Maison, i):
    maxMaisonRayon = 0
    for j in range(len(Maison)):
        if Couvre(Maison, i, j):
            maxMaisonRayon += 1
    return maxMaisonRayon

def choixMaison(Maison,MaisonsRestantes):#MaisonsRestantes[i]=0 ssi i n'est pas couverte
    i0=-1
    maxMaisonRayon = 0
    for i in range(len(Maison)):
        if MaisonsRestantes[i]==0 and i0==-1 and maxMaisonRayon < dansRayon(Maison, i):
            i0=i
            maxMaisonRayon = dansRayon(Maison, i)
    return i0

def choixEmetteurGlouton(Maison):
    n=len(Maison)
    Emetteur=[0]*n
    MaisonsRestantes=[0]*n
    while sum(MaisonsRestantes)<n:
        i=choixMaison(Maison,MaisonsRestantes)
        Emetteur[i]=1
        for j in range(n):
            if Couvre(Maison,i,j):
                MaisonsRestantes[j]=1
    return Emetteur
    
def longueur(Emetteur):
    cpt=0
    for x in Emetteur:
        if x==1:
            cpt+=1
    return cpt
    
rayon=200 # rayon de l'émetteur
n=50 #nombre de maisons
Maison=[] #contient les coordonnees cartesiennes des maisons dans [1,1000]x[1,1000]

Maison = GenererMaisons(Maison,n)

#AfficheMaisons(Maison)

Emetteur=choixEmetteurGlouton(Maison)

print("L'algo glouton place",longueur(Emetteur),"émetteurs")

AfficheEmetteurs(Maison,Emetteur,rayon)
