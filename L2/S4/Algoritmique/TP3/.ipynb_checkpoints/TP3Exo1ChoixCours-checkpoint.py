import matplotlib.pyplot as plt
from random import *
import time

###########################################

def CoursAuHasard(n):
    Cours = []
    for i in range(n):
        debut = randint(1,81)
        Cours.append([Debut, Debut+randint(1,21), randint(1,11)])
    return Cours
    
def TriBullesCours(Cours):
    #
    # A COMPLETER
    # 
    pass

def CalculPred(n,Cours):
    Pred=n*[-1]
    #
    # A COMPLETER
    #
    return Pred

def ChoixMaxProgD(n,Cours,Pred):
    ValMax=n*[0]
    #
    # A COMPLETER
    #
    return ValMax[n-1]

def ChoixMaxRec(Cours,Pred,k):
    if k<0:
        return 0
    #
    # A COMPLETER
    #

def ChoixMaxProgDSol(n,Cours,Pred,Sol):
    ValMax=n*[0]
    Sol[0]=1
    #
    # A COMPLETER
    #
    return ValMax[n-1]

def CalculSolProgDyn(n,Cours,Pred,Sol):
    CoursChoisis=[]
    i=n-1
    #
    # A COMPLETER
    #
    return CoursChoisis


#######Programme Principal########

choix=int(input("Taper 1 pour un test sur l'exemple donné, 2 pour un ensemble de cours aléatoire: "))
if choix==1:
    Cours=[[76,78,10],[12,17,2],[13,15,1],[19,28,8],[12,20,7],[44,45,9],[43,45,5],[1,8,3]]
    n=8
else:
    n=int(input("Rentrer le nombre de cours voulus: "))
    Cours=CoursAuHasard(n)

print("Cours non triés: ",Cours,"\n")
TriBullesCours(Cours)
print("Cours tries par dates de fin croissantes: ",Cours,"\n")
Pred=CalculPred(n, Cours)
print("Calcul des prédécesseurs: ")
for i in range(0,n):
    print("Pred du cours",i,":",Pred[i]," / ",end='')
    if i%4==3:
        print()
print()
print("Valeur maximale d'un choix de cours en prog dyn: ",ChoixMaxProgD(n,Cours,Pred))
print()
print("Valeur maximale d'un choix de cours en récursif: ", ChoixMaxRec(Cours,Pred,n-1))
print()
Sol=n*[0]
print("Calcul d'une solution de valeur maximale d'un choix de cours en prog dyn: ")
print("Valeur maximale: ", ChoixMaxProgDSol(n,Cours,Pred,Sol))
print("Solution correspondante :", CalculSolProgDyn(n,Cours,Pred,Sol))