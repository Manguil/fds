from random import *
import operator

def CoursAuHasard(n):
    Cours=[]
    for i in range(0,n):
        #
        # A completer
        # 
        Cours.append([0,0])
    return Cours

def TriBulles(Cours):
    #
    # A completer
    #
    print("Cours triés par dates de fin croissantes: \n",Cours)

def glouton(Cours):
    TriBulles(Cours)
    L=[]
    #
    # A completer
    #
    return L

   
#=================================================================

alea=int(input('Taper 1 pour utiliser l\'exemple pré-rempli, taper 2 pour choisir une instance au hasard:'))
if alea==1:
    n=10
    Cours=[[76,78],[12,17],[13,15],[19,28],[12,20],[43,45],[44,45],[1,8],[68,78],[85,88]]    
else:
    n=int(input('Entrez le nombre de cours: '))
    Cours=CoursAuHasard(n)
print("Ensemble de cours disponibles: \n",Cours)
print("Choix de cours effectué :", glouton(Cours))
