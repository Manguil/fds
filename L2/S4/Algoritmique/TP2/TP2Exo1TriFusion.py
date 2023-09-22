import matplotlib.pyplot as plt
import random
import time

###########################################

def TableauAuHasard(n):
    TabHasard=[random.randint(1,10001) for i in range(n)]
    return TabHasard

def TriFusion(n,T):
    if n>1:
        n1=n//2
        n2 = n - n1
        T1=T[0:n1]
        T2=T[n2:]
        gauche = TriFusion(n1,T1)
        droite = TriFusion(n2,T2)
        fusionne = Fusion(n1,n2,gauche,droite,T)
        return fusionne

        

def Fusion(n1, n2, T1, T2, T):
    i1 = 0
    i2 = 0
    i = 0
    while(i1 < n1 and i2 < n2):
        if i1 <= i2:
            T[i] = T1[i1]
            i += 1
            i1 += 1
        else :
            T[i] = T1[i2]
            i += 1
            i2 += 1
    if i1 == n1:
        while i2 < n2:
            T[i] = T[i2]
            i += 1
            i2 += 1
    else :
        while i1 < n1:
            T[i] = T[i1]
            i += 1
            i1 += 1


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
    Tab=TableauAuHasard(n)
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