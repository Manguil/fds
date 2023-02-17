import matplotlib.pyplot as plt
from random import *
import time

###########################################

def TableauAuHasard(n):
    TabHasard=[]
    for i in range(0,n):
        TabHasard.append(randint(1,1000)) 
    return TabHasard

def ChoixPivot(n,T,typepivot):
    global nappelChoixPivot
    global npivot
    nappelChoixPivot+=1
    #
    # A COMPLETER
    #
    return 0 # A SUPPRIMER

def Rang(n,k,T,typepivot):
    if n==1:
         return T[0]
    p = ChoixPivot(n, T, typepivot)
    ni=0
    ns=0
    Ti=[]
    Ts=[]
    #
    # A COMPLETER
    #
    return 0 # A SUPPRIMER

#######Programme Principal########

choix=int(input("Taper 1 pour l'exemple pré-rentré, 2 pour un tableau aléatoire: "))
if choix==1:
    n=12
    Tab=[34,12,4,5,67,7,42,13,45,9,2,31]
else:
    n=int(input("Rentrer la taille du tableau aléatoire: "))
    Tab=TableauAuHasard(n)    

typepivot=int(input("Taper 1 pour un pivot fixe (T[0]), taper 2 pour le choix de pivot du cours et taper 3 pour un pivot aléatoire: "))
npivot=0
nappelChoixPivot=0

rang=int(input("Entrer le rang à déterminer: "))
print("Tableau d'entrée: ",Tab)
print("Rang trouvé: ", Rang(n,rang,Tab,typepivot))
print("Nb pivots: ",npivot," Nb appel fonction ChoixPivot: ",nappelChoixPivot," nb moyen: ",npivot/nappelChoixPivot)
