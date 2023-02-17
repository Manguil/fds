import matplotlib.pyplot as plt
from random import *
import time

###########################################

def TableauAuHasard(n):
    TabHasard=[]
    #
    # A COMPLETER
    #

def TriFusion(n,T):
    if n>1:
        n1=n//2 
        n2=n-n1 
        T1=[]
        T2=[]
    #
    # A COMPLETER
    #

def Fusion(n1, n2, T1, T2, T):
    i1 = 0
    i2 = 0
    i = 0
    #
    #A COMPLETER
    #

def TriBulles(n,T):
    pass
    #
    # A COMPLETER (et enlever pass)
    #

#######Programme Principal########

choix=int(input("Taper 1 pour un test sur le TriFusion, 2 pour un comparatif TriFusion/TriBulles: "))
if choix==1:
    Tab=[0]
    n=int(input("Entrez la taille du tableau à trier: "))
    #Tab=TableauAuHasard(n)
    print("Tableau à trier: ",Tab)
    TabFusion=list(Tab)
    TriFusion(n, TabFusion)
    print("Après TriFusion: ",TabFusion)
    TriBulles(n, Tab)
    print("Après TriBulles: ",Tab)
else:    
    #Valeurs de n choisies    
    abscisses = [n for n in range(1,1000,10)]
    #Temps de calcul
    tps1 = []
    tps2 = []
    for n in range(1,1000,10):
        T=TableauAuHasard(n)
        T2=list(T)
        t=time.time()
        TriBulles(n, T)
        tps1.append(time.time()-t)
        t=time.time()
        TriFusion(n, T2)
        tps2.append(time.time()-t)
    #Tracé
    plt.plot(abscisses, tps1)
    plt.plot(abscisses, tps2)
    plt.show()