from tasCorrection import *
from tasCorrection import NB
from random import randint


pileVide = []
nbIterationInsere = 0
listNbIterationInsere = []
listNbIterationExtraireMax = []
listNbIteration = []
nbIteration = 0
print(NB)
entasser([3,7,8,6], 3, 0)
print(NB)


def maximum(tas):
    return tas[0]


def extraireMax(tas,n):
    max = tas[0]
    tas[0] = tas[n-1]
    tas.pop(n-1)
    entasser(tas, n-1, 0)
    return max


def insere(tas,n,x):
    global nbIterationInsere
    tas.append(0)
    i=n-1
    while i>0 and tas[pere(i)] < x:
        nbIterationInsere += 1
        tas[i] = tas[pere(i)]
        i = pere(i)
    tas[i] = x
    return tas


def complexite(pileVide):
    global listNbIteration
    global nbIteration
    global NB
    global nbIterationInsere
    global listNbIterationInsere
    global listNbIterationExtraireMax
    for k in range(400,1000):
        for i in range(k//2):
            pileVide = insere(pileVide, len(pileVide), randint(0,100))
        
        for i in range(k//2):
            extraireMax(pileVide, len(pileVide))
            
        listNbIterationInsere.append(nbIterationInsere)
        listNbIterationExtraireMax.append(NB)
        
        nbIteration = nbIterationInsere/k + NB/k
        #print(nbIteration)
        listNbIteration.append(nbIteration)
        nbIterationInsere = 0
    
def afficherCourbe(li,name):
    plot(array(range(len(li))),array(li),label=name)
    legend(loc='upper right')
    show()


complexite(pileVide)
#afficherCourbe(listNbIteration,"nb iteration")

''' Afin d'observer la complexité en moyenne des opérations Inserer et ExtraireMax on souhaite réaliser 
l'expérience suivante : à partir de la file vide on va réaliser n opérations (n/2 opérations Inserer,
 suivi de n/2 opérations ExtraireMax), relever le nombre d'itérations (respectivement temps) global, 
 le diviser par n (et ainsi avoir le nombre d'itérations moyen, resp. temps moyen), le conserver dans une liste data. 
 Le tout pour n allant de 400 à 10000. On affiche la courbe associée à data. '''